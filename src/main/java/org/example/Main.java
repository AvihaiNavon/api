package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        // לעיתים צריך לקחת כתובת ולשנות אותה ל com
        // JSON Formatter תוסף לכרום לסידור גקסון
        //חייב להוסיף ספרייה
//          <dependencies>
//        <!-- https://mvnrepository.com/artifact/com.mashape.unirest/unirest-java -->
//        <dependency>
//            <groupId>com.mashape.unirest</groupId>
//            <artifactId>unirest-java</artifactId>
//            <version>1.4.9</version>
//        </dependency>
        //ולהוסיף בנוסף
//        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
//<dependency>
//    <groupId>com.fasterxml.jackson.core</groupId>
//    <artifactId>jackson-core</artifactId>
//    <version>2.15.2</version>
//</dependency>
        //ולהוסיף
//        <dependency>
//            <groupId>com.fasterxml.jackson.core</groupId>
//            <artifactId>jackson-databind</artifactId>
//            <version>2.15.0</version>
//        </dependency>
//    </dependencies>
        // ואז לעדכן את ה pom

        // get- לקבל מידע
        GetRequest getRequest= Unirest.get("https://restcountries.com/v2/name/France");//בונים את הבקשה
        try {
            HttpResponse<String> response=getRequest.asString();//לקבל את התשובה/תגובה כסטרינג
            //200- ok קוד תקין תגובה תקינה
            //404- not found שגיאה אצלנו
            //500-server issue בעיה בצד השני
            System.out.println("Code: "+ response.getStatus());// קבלת סטאטוס בקשה
            System.out.println("JSON: "+ response.getBody());// קבלת הגקסון
            String json=response.getBody();
            ObjectMapper objectMapper= new ObjectMapper(); // שיוצרים לבחור באופציה השניה של גקסון, לוקח סטרינג והופך לאובקייקט
            List<CountryModel> countryModel=objectMapper.readValue(json, new TypeReference<>() {});// לבנות את המחלקה לפי המשתנים של הגקסון
            for (CountryModel countryModel1:countryModel){
                System.out.println(countryModel1.getAlpha2Code());
            }
            for (CountryModel countryModel1:countryModel){
                System.out.println(countryModel1.getLatlng());
            }

            CatFactModel.catFactModel();// שיטת חילוץ של דוד


        } catch (UnirestException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}