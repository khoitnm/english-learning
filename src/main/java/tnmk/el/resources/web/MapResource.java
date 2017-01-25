package tnmk.el.resources.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author khoi.tran on 11/6/16.
 */
@Controller
public class MapResource {

    @RequestMapping("/mapPage")
    public ModelAndView openMap(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return new ModelAndView("static/contents/map");
    }

    @RequestMapping("/mapPage2")
    public String openMap2(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        return "contents/map";
    }

    @RequestMapping("/mapPage3")
    public String openMap3(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        return "map";
    }
}
