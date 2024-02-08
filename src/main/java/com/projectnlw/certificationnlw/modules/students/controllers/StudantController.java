package com.projectnlw.certificationnlw.modules.students.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.projectnlw.certificationnlw.modules.students.dto.VerifyHasCertificationDTO;
import com.projectnlw.certificationnlw.modules.students.useCases.VerifyIfHasCertificationUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/students")
public class StudantController {
    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;
    @PostMapping("/verifyifhascertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO){

        var result = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);
        if( result ){
            return "Usuario já fez a prova";
        }
        return "Usuario pode fazer a prova";
    }
}
