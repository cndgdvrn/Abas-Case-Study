package org.can.questions;

import org.can.pojo.PostRequestData;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostQuestion {
    public static void postRequest () {
        try {
            URL url = new URL("https://api.restful-api.dev/objects");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            PostRequestData.Data data = new PostRequestData.Data();
            PostRequestData postRequestData = new PostRequestData();
            data.setYear(2024);
            data.setPrice(2024.99);
            data.setCPUModel("Intel Core i9");
            data.setHardDiskSize("2 TB");
            postRequestData.setData(data);
            postRequestData.setName("Tamamiyle bir test bilgisayarı");

            JSONObject json = new JSONObject(postRequestData);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = json.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            System.out.println("------------------------ POST Request ------------------------");
            System.out.println(json.toString(4));

            JSONObject jsonResponse = new JSONObject(response.toString());
            System.out.println("------------------------ POST Response ------------------------");
            System.out.println(jsonResponse.toString(4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
