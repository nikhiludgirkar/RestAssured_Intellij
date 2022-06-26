package com.bookstore.utils;

import org.json.*;

import java.io.*;

public class JsonParser {

    public static String getJsonValue(JSONObject oo, String key) throws JSONException {
//        System.out.println(oo.get(key));
        return String.valueOf(oo.get(key));
    }


    public static Object readJsonFile(String fileName, String key) throws IOException {
        FileReader fr = null;
        try {
            fr = new FileReader(System.getProperty("user.dir") + "/src/main/java/com/bookstore/testdata/" + fileName + ".json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        String content, str = "";
        StringBuffer sb = new StringBuffer();
        while ((content = br.readLine()) != null) {
//            str = str + content;
            sb.append(content);
        }

        JSONObject obj = new JSONObject(sb.toString());
        return getJsonValue(obj, key);
    }
}