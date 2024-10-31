package com.example.project_work_giornale.controller;

import com.example.project_work_giornale.model.Notizia;
import com.example.project_work_giornale.service.NotiziaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/intelligenzaartificiale")
public class IntelligenzaArtificialeController {

    @Autowired
    private NotiziaService notiziaService;

    @GetMapping
    public String getPage(Model model) {
        List<Notizia> notizie = notiziaService.getNotizieByCategoria("Intelligenza Artificiale");
        model.addAttribute("notizie", notizie);
        return "intelligenza-artificiale";
    }

}
