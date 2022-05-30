package com.inteca.family;

import com.inteca.familyMember.FamilyMember;
import com.inteca.restServices.FamilyTDO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {
    private final FamilyRepository familyRepository;
    private final WebClient.Builder webClient;

    public FamilyServiceImpl(FamilyRepository familyRepository, WebClient.Builder webClient) {
        this.familyRepository = familyRepository;
        this.webClient = webClient;
    }

    @Override
    public boolean validateFamily(FamilyTDO familyTDO) {
        Family family = familyTDO.getFamily();
        List<FamilyMember> familyMembers = familyTDO.getFamilyMembers();

        int noOfInfants = 0;
        int noOfChildren = 0;
        int noOfAdults = 0;

        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.getAge() < 0) {
                return false;
            } else if (familyMember.getAge() <= 4) {
                noOfInfants++;
            } else if (familyMember.getAge() > 4 && familyMember.getAge() < 16) {
                noOfChildren++;
            } else {
                noOfAdults++;
            }
        }
        return (noOfInfants == family.getNrOfInfants() && noOfChildren == family.getNrOfChildren() && noOfAdults == family.getNrOfAdults());
    }

    @Override
    public void sendFamilyMembers(FamilyTDO familyTDO) {
        Family family = familyTDO.getFamily();
        Long familyId = familyRepository.findByFamilyName(family.getFamilyName()).getId();
        for (FamilyMember familyMember : familyTDO.getFamilyMembers()) {
            familyMember.setFamilyId(familyId);
            webClient.build().post()
                    .uri(GLOBAL_URL + CREATE_FAMILY_URL)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(Mono.just(familyMember), FamilyMember.class)
                    .retrieve().bodyToMono(FamilyMember.class).block();
        }
    }

    @Override
    public FamilyMember[] getFamilyMembers(Long id) {
        return webClient.build().get()
                .uri(GLOBAL_URL + GET_FAMILY_MEMBERS_URL + id)
                .retrieve().bodyToMono(FamilyMember[].class).block();
    }
}
