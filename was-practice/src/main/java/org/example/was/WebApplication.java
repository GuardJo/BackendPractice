package org.example.was;

import java.io.IOException;

public class WebApplication {
    public static void main(String[] args) {
        WebApplicationServer webApplicationServer = new WebApplicationServer(8080);

        try {
            webApplicationServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
