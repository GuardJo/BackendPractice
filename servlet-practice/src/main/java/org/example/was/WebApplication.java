package org.example.was;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplication {
    private static final Logger log = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String[] args) throws LifecycleException {
        String webAppDir = "webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("/", new File(webAppDir).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();

    }
}
