package com.ipi.jva320.service;

import com.ipi.jva320.model.SalarieAideADomicile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {

    @Autowired
    SalarieAideADomicileService salarieAideADomicileService;
    @GetMapping(value ="/list" )
    public String AfficherListeSalarie(final ModelMap model){
        List<SalarieAideADomicile> salaries = salarieAideADomicileService.getSalaries();
       model.put("salaries", salaries);
        return "list";



    }
}
