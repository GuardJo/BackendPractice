package org.example.was;

import org.example.was.calculator.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 요구사항
 * GET /calculate?operand1=1&operator=+&operand2=2
 * 위와 같은 형식의 URL 열기
 */
public class WebApplicationServer {
    private final int port;
    private static final Logger logger = LoggerFactory.getLogger(WebApplicationServer.class);

    public WebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(this.port)) {
            logger.info("WebApplication Server Started! (port : {})", this.port);

            Socket clientSocket;
            logger.info("waiting client...");

            // 사용자 요청이 올 때마다 Thread 생성
            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("Client Connected!");

                new Thread(new RequestHandler(clientSocket)).start();
            }
        }
    }
}
