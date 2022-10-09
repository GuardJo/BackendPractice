package org.example.was;

import org.example.was.calculator.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class RequestHandler implements Runnable{
    private final static Logger log = LoggerFactory.getLogger(RequestHandler.class);
    private final Socket clientSocket;

    public RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        log.info("new Thread [{}] started", Thread.currentThread().getName());

        try (InputStream in = clientSocket.getInputStream();
             OutputStream out = clientSocket.getOutputStream()) {
            DataOutputStream dataOutputStream;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                dataOutputStream = new DataOutputStream(out);

                HttpRequest httpRequest = new HttpRequest(br);

                if (httpRequest.isGetMethod() && httpRequest.getUrlPath().equals("/calculate")) {
                    RequestLine requestLine = httpRequest.getRequestLine();

                    int operand1 = Integer.parseInt(requestLine.getQueryStrings().getValue("operand1"));
                    String operator = requestLine.getQueryStrings().getValue("operator");
                    int operand2 = Integer.parseInt(requestLine.getQueryStrings().getValue("operand2"));

                    int result = Calculator.calculate(operand1, operator, operand2);
                    byte[] body = String.valueOf(result).getBytes();

                    HttpResponse httpResponse = new HttpResponse(dataOutputStream);
                    httpResponse.response200Header("application/json", body.length);
                    httpResponse.responseBody(body);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
