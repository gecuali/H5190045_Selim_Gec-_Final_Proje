package com.h5190045.selim_gecu_final.util;

import com.google.gson.Gson;
import com.h5190045.selim_gecu_final.model.PlanetModel;

public class ObjectUtil {
    //String verilerini Json'a dönüştürür
    public  static String planetToJsonString(PlanetModel planetModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(planetModel);
    }
    //Alınan Json verilerini String'e dönüştürür
    public  static PlanetModel jsonStringToPlanet(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,PlanetModel.class);
    }
}
