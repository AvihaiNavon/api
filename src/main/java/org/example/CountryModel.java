package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // קריטי להוסיף - לוקח את הגקסון ולוקח רק את האיבריים הרלוונטים
public class CountryModel { // נהוג לכתוב מודל לגקסונים
    private String name;
    private String alpha2Code;
    private String alpha3Code;
    private List<String> latlng;
   

    public List<String> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<String> latlng) {
        this.latlng = latlng;
    }

    public String getName() {
        return name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    @Override
    public String toString() {
        return "CountryModel{" +
                "name='" + name + '\'' +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", alpha3Code='" + alpha3Code + '\'' +
                ", borders=" + latlng +
                '}';
    }
}
