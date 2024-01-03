package com.ipi.jva320.service;

import com.ipi.jva320.exception.SalarieException;
import com.ipi.jva320.model.SalarieAideADomicile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class creerSalarie {



    @Autowired
    SalarieAideADomicileService salarieAideADomicileService;
    @PostMapping (value="/salaries/aide/new")
    public String creerEmploye(@ModelAttribute("salarie") SalarieAideADomicile salarieService, ModelMap model) throws SalarieException {

        salarieAideADomicileService.creerSalarieAideADomicile(salarieService);
        return "redirect:/list";

    }

    @PostMapping(value="/salaries/creerSalarie/modifier")
    public String modifierSalarie(@ModelAttribute("salarie") SalarieAideADomicile salarieService,

                                  ModelMap model) throws SalarieException {
       salarieAideADomicileService.updateSalarieAideADomicile(salarieService);
          return "redirect:/list";
    }
   @GetMapping(value="/salaries/{id}/delete")
    public String supprimerSalarie(@ModelAttribute("salarie") SalarieAideADomicile salarieService,
                                   @PathVariable Long id,
                                   ModelMap model) throws SalarieException{
        salarieAideADomicileService.deleteSalarieAideADomicile(id);
       return "redirect:/list";
    }
}
