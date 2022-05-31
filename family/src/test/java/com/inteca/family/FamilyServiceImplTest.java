package com.inteca.family;


import com.inteca.familyMember.FamilyMember;
import com.inteca.restServices.FamilyTDO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

class FamilyServiceImplTest {
    FamilyRepository familyRepository;
    WebClient.Builder webClient;
    @Disabled
    @Test
    void validateFamily() {
        FamilyService familyService = new FamilyServiceImpl(familyRepository, webClient);
        Family family = new Family(1L,"Test1",1,1,1);

        FamilyMember familyMember1 = new FamilyMember("Name1",family.getFamilyName(),4,family.getId());
        FamilyMember familyMember2 = new FamilyMember("Name1",family.getFamilyName(),12,family.getId());
        FamilyMember familyMember3 = new FamilyMember("Name1",family.getFamilyName(),32,family.getId());

        //Family member list with the correct data:
        List<FamilyMember> familyMembers1 = new ArrayList<>();
        familyMembers1.add(familyMember1);
        familyMembers1.add(familyMember2);
        familyMembers1.add(familyMember3);

        //Family member list with the wrong data:
        List<FamilyMember> familyMembers2 = new ArrayList<>();
        familyMembers2.add(familyMember1);
        familyMembers2.add(familyMember1);
        familyMembers2.add(familyMember1);

        FamilyTDO familyTDOCorrect = new FamilyTDO(family, familyMembers1);
        FamilyTDO familyTDOWrong = new FamilyTDO(family, familyMembers2);

        assertTrue(familyService.validateFamily(familyTDOCorrect),"Family added");
        assertFalse(familyService.validateFamily(familyTDOWrong),"Validation has failed");
    }

    @Test
    @Disabled
    void sendFamilyMembers() {
//      Test POST method adding a family and checking for the 200 code
        Family family = new Family("Test",0,0,1);
        FamilyMember familyMember = new FamilyMember("Name","Test",33,family.getId());
        List<FamilyMember> familyMembers = List.of(familyMember);
        FamilyTDO familyTDO = new FamilyTDO(family, familyMembers);

        given().contentType("application/json").body(familyTDO).when()
                .post("http://localhost:8080/create-family").then().statusCode(200);
    }

    @Test
    @Disabled
    void getFamilyMembers() {
//        Test GET method matching family id and family member's age
        given().get("http://localhost:8080/family/1").then().body("family.id",equalTo(1));
        given().get("http://localhost:8080/family/1").then().body("familyMembers.age[0]",equalTo(33));
    }
}