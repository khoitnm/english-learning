//package tnmk.el.app.security.config_old;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import tnmk.el.app.security.service.UserAuthenticationService;
//
///**
// * @author khoi.tran on 1/28/17.
// */
////@Configuration
////@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserAuthenticationService userAuthenticationService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers(
//                        "/**/*.css",
//                        "/**/*.js",
//                        "/**/*.png",
//                        "/**/*.jpg").permitAll()
//                .antMatchers("/", "/register", "/api/users").permitAll()
//                .anyRequest().authenticated()
//                .and().
//                formLogin().defaultSuccessUrl("/main", false).loginPage("/login").permitAll()
//                .and()
//                .logout().permitAll();
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userAuthenticationService).passwordEncoder(passwordEncoder());
////        inMemoryAuthentication().withUser("user").password("password").roles("USER");
//    }
//}
