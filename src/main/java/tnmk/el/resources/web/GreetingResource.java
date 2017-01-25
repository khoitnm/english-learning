package tnmk.el.resources.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author khoi.tran on 11/6/16.
 */
@Controller
public class GreetingResource {
    @RequestMapping("/greetingPage")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        return "greeting";
    }
}
