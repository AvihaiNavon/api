package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiPath {
    public static String generateAPI(String requestAddress, String line) {
        String newString = "";
        try {
            GetRequest getRequest = Unirest.get(requestAddress);
            HttpResponse<String> response = getRequest.asString();
                String json = response.getBody(); // חילץ את הגקסון
                newString = parseFromJson(json, line);

                System.out.println(newString);


        } catch (Exception e) {

        }
        return newString;

    }
    private static String parseFromJson(String jsonResponse, String line) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
                return jsonObject.getString(line);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
