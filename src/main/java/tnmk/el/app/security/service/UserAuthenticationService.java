package tnmk.el.app.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tnmk.el.app.security.entity.User;
import tnmk.el.app.security.model.UserAuthentication;

/**
 * @author khoi.tran on 1/28/17.
 */
@Service
public class UserAuthenticationService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Cannot find username '" + username + "'");
        }
        return new UserAuthentication(user);
    }
}
