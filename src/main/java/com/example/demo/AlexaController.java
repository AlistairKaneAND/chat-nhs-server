package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@RestController
@RequestMapping("/alexa")
public class        AlexaController {
    private static String BASE_URL = "https://sandbox.api.service.nhs.uk/hello-world/hello/world";

    @GetMapping
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping(path="/nhs-hello")
    public String nhsHello() throws IOException {
        URL obj = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
        
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            return"GET request not worked, response code: " + responseCode;
        }
    }
}
