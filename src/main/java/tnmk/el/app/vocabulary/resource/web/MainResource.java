package tnmk.el.app.vocabulary.resource.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tnmk.common.infrastructure.projectinfo.ProjectInfoProperties;
import tnmk.el.app.common.entity.UriPrefixConstants;
import tnmk.el.app.security.entity.User;
import tnmk.el.app.security.helper.SecurityContextHelper;

/**
 * @author khoi.tran on 11/6/16.
 */
@Controller
public class MainResource {
    @Autowired
    private ProjectInfoProperties projectInfoProperties;

//    @RequestMapping("/")
//    public String defaultPage(Model model) {
//        return greetingPage(model);
//    }

    @RequestMapping(UriPrefixConstants.WEB_PREFIX + "/main")
    public String greetingPage(Model model) {
        User user = SecurityContextHelper.validateExistAuthenticatedUser();
        model.addAttribute("projectInfo", projectInfoProperties);
        model.addAttribute("user", user);
        return "main";
    }
}
