package com.lwc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @RequestMapping("/companyIndex")
    public String companyIndex(){
        return "company/companylist";
    }

}
