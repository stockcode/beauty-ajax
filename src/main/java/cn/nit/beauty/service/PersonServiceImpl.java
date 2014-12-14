package cn.nit.beauty.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import cn.nit.beauty.domain.Pay;

import com.google.gson.Gson;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class PersonServiceImpl implements PersonService {

    Gson gson = new Gson();

    @Override
    public String Notify(String id, String type, String tradeno) {

        Unirest.setDefaultHeader("X-Bmob-Application-Id",
                "19fee4b5da44fc283e4c58e9f860ea96");
        Unirest.setDefaultHeader("X-Bmob-REST-API-Key",
                "2c8b047dd9e5f8b9d18cb908bd200b48");
        Unirest.setDefaultHeader("Content-Type", "application/json");

        Pay pay = new Pay(id, type, tradeno);

        HttpResponse<String> result = null;
        try {
            result = Unirest
                    .post("https://api.bmob.cn/1/functions/pay").body(gson.toJson(pay)).asString();

            String resp = result.getBody();

            System.err.println(resp);
        } catch (UnirestException e) {
            e.printStackTrace();
        }


        return "success";
    }


}
