package com.inteca.restServices;

import com.inteca.exceptions.FamilyNotFoundException;
import com.inteca.exceptions.ValidationFailException;
import com.inteca.family.Family;
import com.inteca.family.FamilyRepository;
import com.inteca.family.FamilyService;
import com.inteca.familyMember.FamilyMember;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FamilyRestController {
    private final FamilyRepository familyRepository;
    private final FamilyService familyService;

    public FamilyRestController(FamilyRepository familyRepository, FamilyService familyService) {
        this.familyRepository = familyRepository;
        this.familyService = familyService;
    }

    @PostMapping("/create-family")
    @ResponseBody
    public Long createFamily(@RequestBody FamilyTDO familyTDO) {

        if (!familyService.validateFamily(familyTDO)) {
            throw new ValidationFailException();
        }
        Family family = familyTDO.getFamily();
        familyRepository.save(family);
        familyService.sendFamilyMembers(familyTDO);


        Family returnFamily = new Family();
        returnFamily.setId(family.getId());

        return family.getId();
    }

    @GetMapping("/family/{id}")
    @ResponseBody
    public FamilyTDO getFamily(@PathVariable Long id) {
        FamilyTDO familyTDO = new FamilyTDO();

//        Optional returning either desired family, or "not found" exception when family at given id does not exist.
        Family family = familyRepository.findById(id).orElseThrow(() -> new FamilyNotFoundException(id));

//        WebClient GET call to FamilyMember RestApi:
        List<FamilyMember> familyMembers = List.of(familyService.getFamilyMembers(id));

        familyTDO.setFamily(family);
        familyTDO.setFamilyMembers(familyMembers);
        return familyTDO;
    }
}
