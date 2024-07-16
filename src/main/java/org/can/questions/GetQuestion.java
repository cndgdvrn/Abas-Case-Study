package org.can.questions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetQuestion {
    public static void getRequest() {
        try {
            URL url = new URL("https://api.restful-api.dev/objects/7");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");

            int status = con.getResponseCode();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            JSONObject jsonResponse = new JSONObject(response.toString());
            System.out.println("--------------------------------------------------------------");
            System.out.println("GET Request: " + url);
            System.out.println("------------------------ GET Response ------------------------");
            System.out.println(jsonResponse.toString(4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
