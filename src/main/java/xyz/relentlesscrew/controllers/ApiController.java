package xyz.relentlesscrew.controllers;

import spark.Filter;
import xyz.relentlesscrew.util.JsonUtil;

import static spark.Spark.halt;

public class ApiController {

    public static Filter beforeApiCall = (request, response) -> {
        try {
            String apiKey = request.headers("apiKey");
            if (!apiKey.equals(System.getenv("API_KEY")) ) {
                throw halt(401, JsonUtil.responseJson(response,"Invalid apiKey...").toString());
            }
        } catch (NullPointerException e) {
            throw halt(401, JsonUtil.responseJson(response,"Invalid apiKey...").toString());
        }
    };
}
