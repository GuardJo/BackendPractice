package org.example.was;

import org.example.was.calculator.Calculator;
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

                    HttpRequest httpRequest = new HttpRequest(br);

                    if (httpRequest.isGetMethod() && httpRequest.getUrlPath().equals("/calculate")) {
                        RequestLine requestLine = httpRequest.getRequestLine();

                        int operand1 = Integer.parseInt(requestLine.getQueryStrings().getValue("operand1"));
                        String operator = requestLine.getQueryStrings().getValue("operator");
                        int operand2 = Integer.parseInt(requestLine.getQueryStrings().getValue("operand2"));

                        int result = Calculator.calculate(operand1, operator, operand2);

                        logger.info("result : {}", result);
                    }
                }
            }
        }
    }
}
