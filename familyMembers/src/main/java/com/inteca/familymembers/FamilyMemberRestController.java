package com.inteca.familymembers;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FamilyMemberRestController {
    private final FamilyMemberRepository familyMemberRepository;

    public FamilyMemberRestController(FamilyMemberRepository familyMemberRepository) {
        this.familyMemberRepository = familyMemberRepository;
    }

    @GetMapping("/family-members/{familyId}")
    @ResponseBody
    public List<FamilyMember> searchFamilyMember (@PathVariable Long familyId) {
        return familyMemberRepository.findAllByFamilyId(familyId);
    }

    @PostMapping("/family-members/create")
    public void createFamilyMember(@RequestBody FamilyMember familyMember) {
        familyMemberRepository.save(familyMember);
    }
}
