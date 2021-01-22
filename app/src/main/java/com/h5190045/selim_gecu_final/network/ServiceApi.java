package com.h5190045.selim_gecu_final.network;

import com.h5190045.selim_gecu_final.model.PlanetModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //json dosyasını belirtiyoruz. Detay verilerimiz internet üzerinden bu json dosyası üzerinden çekiliyor
    @GET("planets.json")
    Observable<List<PlanetModel>> getPlanets();
}
