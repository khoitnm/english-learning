package tnmk.el;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import tnmk.el.infrastructure.projectprofile.ProjectProfileConstants;

public class ServletInitializer extends SpringBootServletInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServletInitializer.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.profiles(this.getDefaultProfile()).sources(MainApplication.class);
    }

    private String getDefaultProfile() {
        String profile = System.getProperty("spring.profiles.active");
        if (profile != null) {
            LOGGER.info("Running with Spring profile(s) : {}", profile);
            return profile;
        }

        LOGGER.warn("No Spring profile configured, running with default configuration");
        return ProjectProfileConstants.DEV;
    }
}
