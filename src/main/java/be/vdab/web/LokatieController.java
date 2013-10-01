/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.web;
    
import be.vdab.entities.Karakter;
import be.vdab.services.KarakterService;
import be.vdab.services.LokatieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * LokatieController.java.
 * 
 * Spring controller voor navigatie van de lokaties.
 * 
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 1.0: 30-09-2013 (tmtvl): initial version.
 */
@Controller
@RequestMapping("/lokatie")
@SessionAttributes("karakter")
public class LokatieController {
    private final LokatieService lokatieService;
    private final KarakterService karakterService;
    
    @Autowired
    public LokatieController(LokatieService lokatieService, 
            KarakterService karakterService){
        this.lokatieService = lokatieService;
        this.karakterService = karakterService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findKarakterLokatie(@RequestParam long karakterId){
        ModelAndView mav = new ModelAndView("lokatie");
        Karakter k = karakterService.read(karakterId);
        if(k.getLokatie() == null){
            k.setLokatie(lokatieService.read(1));
        }
        mav.addObject("lokatie", k.getLokatie());
        mav.addObject("karakter", k);
        return mav;
    }
    
    @RequestMapping(value = "/hoofdmenu", method = RequestMethod.GET)
    public String hoofdmenu(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "redirect:/hoofdmenu";
    }
    
    @RequestMapping(value = "/afmelden", method = RequestMethod.POST)
    public String afmelden(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "redirect:/afmelden";
    }
    
}
