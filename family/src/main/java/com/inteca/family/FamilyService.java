package com.inteca.family;

import com.inteca.familyMember.FamilyMember;
import com.inteca.restServices.FamilyTDO;

public interface FamilyService {
       String GLOBAL_URL = "http://familymemberapp:8080/";
       String CREATE_FAMILY_URL = "family-members/create";
       String GET_FAMILY_MEMBERS_URL = "family-members/";

    boolean validateFamily(FamilyTDO familyTDO);

    void sendFamilyMembers(FamilyTDO familyTDO);

    FamilyMember[] getFamilyMembers(Long id);
    }

