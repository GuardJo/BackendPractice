package org.example.was;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 요구사항
 * GET /caluate?operand1=1&operator=+&operand2=2
 * 위와 같은 형식의 URL 열기
 */
public class WebApplicationServer {
    private final int port;
    private static Logger logger = LoggerFactory.getLogger(WebApplicationServer.class);

    public WebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(this.port)) {
            logger.info("WebApplication Server Started! (port : {})", this.port);

            Socket clientSocket;
            logger.info("waiting client...");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("Client Connected!");

                try (InputStream in = clientSocket.getInputStream();
                     OutputStream out = clientSocket.getOutputStream()) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    DataOutputStream dataOutputStream = new DataOutputStream(out);

                    String line = "";
                    while ((line = br.readLine()) != "") {
                        System.out.println(line);
                    }
                }
            }
        }
    }
}
