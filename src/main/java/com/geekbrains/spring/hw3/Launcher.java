package com.geekbrains.spring.hw3;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;
import java.security.ProtectionDomain;

public class Launcher {
    public static void main(String[] args) {
        Server server = new Server(8189);

        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/app");
        // http://localhost:8189/app/
        webAppContext.setWar(location.toExternalForm());

        server.setHandler(webAppContext);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            System.out.println("Ошибка запуска сервера - " + e);
        }

    }
}
