package tnmk.el.app.vocabulary.resource.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tnmk.common.infrastructure.projectinfo.ProjectInfoProperties;

/**
 * @author khoi.tran on 11/6/16.
 */
@Controller
public class GreetingResource {
    @Autowired
    private ProjectInfoProperties projectInfoProperties;

    @RequestMapping("/greetingPage")
    public String greeting(Model model) {
        model.addAttribute("projectInfo", projectInfoProperties);
        return "greeting";
    }
}
