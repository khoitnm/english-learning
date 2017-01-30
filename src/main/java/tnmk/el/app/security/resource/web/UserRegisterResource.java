package tnmk.el.app.security.resource.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tnmk.el.app.common.entity.UriPrefixConstants;

/**
 * @author khoi.tran on 1/28/17.
 */
@Controller
public class UserRegisterResource {
    @RequestMapping(UriPrefixConstants.WEB_PREFIX + "/register")
    public String registerUser() {
        return "register";
    }
}
