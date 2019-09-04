package com.yesipov;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 1) Послать POST запрос на https://postman-echo.com/post где в BODY передать foo1=bar1&foo2=bar2 в формате x-www-form-urlencoded
 Ответ распарсить и вывести.
* */

public class Main {

    private static final String URL = "https://postman-echo.com/post";

    public static void main(String[] args) throws Exception {
        String body = "foo1=bar1&foo2=bar2";

        String json = HttpUtil.sendRequest(URL, null, body);
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(json).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyRequestResult = gson.toJson(jsonObject);

        System.out.println(prettyRequestResult);
    }
}
