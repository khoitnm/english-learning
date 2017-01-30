//package tnmk.el.app.security.config_old;
//
//import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
//import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
//import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
//
///**
// * @author khoi.tran on 1/29/17.
// */
////@Configuration
////@EnableResourceServer
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class OAuth2ResourceServerConfig extends GlobalMethodSecurityConfiguration {
//    /**
//     * This bean helps us to config @PreAuthorize annotation.
//     * Example:
//     * <pre>
//     * @PreAuthorize("#oauth2.hasScope('read')")
//     * @RequestMapping(method = RequestMethod.GET, value = "/foos/{id}")
//     * @ResponseBody
//     * public Foo findById(@PathVariable long id) {
//     *      return new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4));
//     * }
//     * </pre>
//     */
//    @Override
//    protected MethodSecurityExpressionHandler createExpressionHandler() {
//        return new OAuth2MethodSecurityExpressionHandler();
//    }
//}
