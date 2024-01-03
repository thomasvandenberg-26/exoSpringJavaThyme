package com.ipi.jva320.service;

import com.ipi.jva320.model.SalarieAideADomicile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SalarieController {
    @Autowired
    SalarieAideADomicileService salarieService;
//    List<SalarieAideADomicileService salarieAideADomicileServices = new ArrayList<SalarieAideADomicileService>();
    @GetMapping(value = "/salaries/{id}")
    public String salarie(final ModelMap modelMap, @PathVariable long id)
    {
          SalarieAideADomicile salarie = salarieService.getSalarie(id);
          modelMap.put("salarie", salarie);

          return "detail_Salarie";
    }
    @GetMapping(value = "/salaries")
   public String listSalarie()
    {
            List<SalarieAideADomicile> list = salarieService.getSalaries();
//            modelMap.put("salaries",list);
            return "list";

    }
    @RequestMapping(value = "/salaries/aide/new")
    public String creerSalarieForm(){

      return "form_Creation_Salarie";
    }
    @GetMapping(value = "/listRecherche")
    public String  recherche(@RequestParam("nom") String nomSaisi, ModelMap modelMap) {
        SalarieAideADomicile salarie = null;

        List<SalarieAideADomicile> listSalarieByNom = new ArrayList<SalarieAideADomicile>();
        String nom = "";
        for (SalarieAideADomicile s : salarieService.getSalaries()) {
            if (s.getNom().contains(nomSaisi)) {
                listSalarieByNom.add(s);

            }
        }
        modelMap.put("list", listSalarieByNom);
       return  "list";
    }
}


