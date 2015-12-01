package by.guru13.spring.controller;

import by.guru13.spring.entities.Tablet;
import by.guru13.spring.service.TabletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-контроллер для работы с планшетом.
 * <p>
 *
 * @author Alexey Guryanchyck
 */
@Controller
@SessionAttributes("listForCompare")
public class TabletController {

    private TabletService tabletService;
    private List<Tablet> listForCompare = new ArrayList<Tablet>();

    @Autowired(required = true)
    @Qualifier(value = "tabletService")
    public void setTabletService(TabletService ps) {
        this.tabletService = ps;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome() {

        return "home";
    }

    @RequestMapping(value = "/tablet", method = RequestMethod.GET)
    public String listTablets(Model model) {
        model.addAttribute("tablet", new Tablet());
        model.addAttribute("listTablets", this.tabletService.listTablets());
        return "tablet";
    }

    @RequestMapping(value = "/tablets")
    public String showTablets(ModelMap model) {
        model.addAttribute("tablets", new Tablet());
        model.addAttribute("listTablets", this.tabletService.listTablets());
        return "tablets";
    }

    @RequestMapping(value = "/toCompare")
    public String compareTablets(ModelMap model, SessionStatus session) {
        session.setComplete();
        model.addAttribute("listForCompare", listForCompare);
        return "compare";
    }

    @RequestMapping(value = "/addToCompare/{id}", method = RequestMethod.GET)
    public String compareTablets(@PathVariable("id") int id, ModelMap model) {
        Tablet tablet = this.tabletService.getTabletById(id);

            listForCompare.add(tablet);

        model.addAttribute("listForCompare", listForCompare);

        return "redirect:/toCompare";
    }

    @RequestMapping(value = "/removeToCompare/{id}", method = RequestMethod.GET)
    public String removeCompareTablet(@PathVariable int id) {
        // почему если не переписал equals и hashcode, то заработало???
        listForCompare.remove(id);
        return "redirect:/toCompare";
    }


    @RequestMapping(value = "/tablet/add", method = RequestMethod.POST)
    public String addTablet(@ModelAttribute("tablet") Tablet t) {

        if (t.getId() == 0) {
            this.tabletService.addTablet(t);
        } else {
            this.tabletService.updateTablet(t);
        }
        return "redirect:/tablet";
    }

    @RequestMapping("/remove/{id}")
    public String removeTablet(@PathVariable("id") int id) {

        this.tabletService.removeTablet(id);
        return "redirect:/tablet";
    }

    @RequestMapping("/edit/{id}")
    public String editTablet(@PathVariable("id") int id, Model model) {
        model.addAttribute("tablet", this.tabletService.getTabletById(id));
        model.addAttribute("listTablets", this.tabletService.listTablets());
        return "tablet";
    }
}
