package com.inteca.restServices;

import com.inteca.family.Family;
import com.inteca.familyMember.FamilyMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FamilyTDO {

    private Family family;
    private List<FamilyMember> familyMembers;

}
