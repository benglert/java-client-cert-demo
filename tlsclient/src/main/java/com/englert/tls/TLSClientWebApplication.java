package com.englert.tls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TLSClientWebApplication  {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TLSClientWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TLSClientWebApplication.class, args);
    }
/*
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        String os = System.getProperty("os.name");
        String osProfile = "linux";
        if (os.contains("Windows")) {
            osProfile = "windows";
        }
        LOGGER.info("Loading os profile: {}", osProfile);
        servletContext.setInitParameter("spring.profiles.active", osProfile);
    }

 */
}
