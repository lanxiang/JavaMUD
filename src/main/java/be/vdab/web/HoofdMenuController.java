/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
package be.vdab.web;
    
import be.vdab.services.GebruikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tim Van den Langenbergh (tmtvl)
 * @version 0.1: 01-10-2013 (tmtvl): Initial version.
 */
@Controller
@RequestMapping("/hoofdmenu") // Dit wordt "/" wanneer alles klaar is
public class HoofdMenuController {
    private final GebruikerService gebruikerService;
    
    @Autowired
    public HoofdMenuController(GebruikerService gebruikerService){
        this.gebruikerService = gebruikerService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView hoofdmenu(){
        ModelAndView mav = new ModelAndView("hoofdmenu");
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView hoofdmenu(@RequestParam long gebruikerId){
        ModelAndView mav = new ModelAndView("hoofdmenu");
        mav.addObject("gebruiker", gebruikerService.read(gebruikerId));
        return mav;
    }
    
}
