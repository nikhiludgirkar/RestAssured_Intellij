package com.bookstore.meta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeaderConfig {
    public static HashMap<String, String> getHeaders(){
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        return headers;
    }
}
