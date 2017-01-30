package tnmk.el.app.security.resource.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tnmk.el.app.security.entity.User;
import tnmk.el.app.security.service.UserService;
import tnmk.el.app.common.entity.UriPrefixConstants;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

    @RequestMapping(value = UriPrefixConstants.API_PREFIX + "/users", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}