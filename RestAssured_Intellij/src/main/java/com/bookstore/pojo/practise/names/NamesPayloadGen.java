package com.bookstore.pojo.practise.names;

import com.bookstore.utils.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NamesPayloadGen {

    public static void main(String[] args) throws IOException {
        List<NamesDetails> setList = new ArrayList<NamesDetails>();
        List<NamesDetails.Preferences> preferencesList = new ArrayList<NamesDetails.Preferences>();
        NamesDetails.Preferences preferences = new NamesDetails.Preferences();
        preferences.setDescription((String)JsonParser.readJsonFile("names", "preferencesList.description"));
        preferences.setId(Integer.parseInt((String)JsonParser.readJsonFile("names", "preferencesList.id")));
        preferences.setImage((String)JsonParser.readJsonFile("names", "preferencesList.image"));
        preferences.setName((String)JsonParser.readJsonFile("names", "preferencesList.name"));
        preferencesList.add(preferences);
        NamesDetails namesDetails = new NamesDetails();
        namesDetails.setId(Integer.parseInt((String)JsonParser.readJsonFile("names", "namesDetailsList.id")));
        namesDetails.setName((String)JsonParser.readJsonFile("names", "namesDetailsList.name"));
        namesDetails.setAlias("Alias");
        namesDetails.setDescription("desc");
        namesDetails.setId(333);
        namesDetails.setShortDescription("shortDesc");
        namesDetails.setPreferencesList(preferencesList);
        setList.add(namesDetails);
        NamesPojo pojo = new NamesPojo();
        pojo.setNamesDetailsList(setList);
        ObjectMapper obj = new ObjectMapper();
        String s = obj.writeValueAsString(pojo);
        System.out.println(s);
    }
}
