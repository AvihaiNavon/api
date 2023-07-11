package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.json.JSONObject;

public class CatFactModel {
    private static final String REQUEST_ADRESS = "https://catfact.ninja/fact?max_length=140";
    private static final String JSON_OBJECT_STRING = "fact";
    public static String catFactModel(){
        GetRequest getRequest = Unirest.get(REQUEST_ADRESS);// לוקח בקשה מהאתר
        HttpResponse<String> response = null;
        try {
            response = getRequest.asString();// הופך לסטרינג
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        String json = response.getBody(); // חילץ את הגקסון
        JSONObject jsonObject = new JSONObject(json);//לוקח חלק רלוונטי מהגקסון
        String result=jsonObject.getString(JSON_OBJECT_STRING);
        System.out.println(result);
        return result;
    }
}
