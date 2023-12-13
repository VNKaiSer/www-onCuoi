package com.example.votandat_20115031_01.frontend.controllers;

import com.example.votandat_20115031_01.backend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CandidateController {
    @Autowired private CandidateService service;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/candidate")
    public String getCandidate(Model model){
        model.addAttribute("candidates", service.getAllCandidate());
        return "candidate/index";
    }

    @GetMapping("/candidate/detail/{id}")
    public String getCandidateDetail(Model model, @PathVariable long id){
        model.addAttribute("candidates", service.getCandidateById(id));
        return "candidate/detail";
    }

    @GetMapping("/candidate/report1")
    public String getReport1(Model model){
        model.addAttribute("showTable", false);
        return "candidate/report1";
    }

    @PostMapping("/candidate/report1")
    public String postReport1(Model model, @RequestParam("company") String company){
        model.addAttribute("showTable", true);
        model.addAttribute("candidates", service.getCandidateReport(company));
        System.out.println(company);
        return "candidate/report1";
    }

    @GetMapping("/candidates/report2")
    public String getReport2(Model model){
        model.addAttribute("candidates", service.findCandidateThan5Exp());
        return "candidate/report2";
    }
}
