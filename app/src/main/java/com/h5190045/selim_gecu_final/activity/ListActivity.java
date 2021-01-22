package com.h5190045.selim_gecu_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.h5190045.selim_gecu_final.R;
import com.h5190045.selim_gecu_final.adapter.PlanetAdapter;
import com.h5190045.selim_gecu_final.model.PlanetModel;
import com.h5190045.selim_gecu_final.network.Service;
import com.h5190045.selim_gecu_final.util.Constants;
import com.h5190045.selim_gecu_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListActivity extends AppCompatActivity { //Bu dosya liste ekranıdır

    RecyclerView recyclerView;

    //Aşağıdaki metod, başlangıçta çalışan metoddur ve layout olarak activity_list.xml set edilmiştir
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();

    }



    private  void  init() {
        getPlanets();
    }

    void  getPlanets() { //Gezegenleri Al

        new Service().getServiceApi().getPlanets().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PlanetModel>>() {

                    List<PlanetModel> planets=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<PlanetModel> planetList) {
                        planets=planetList; // Gelen verileri alır
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        if(planets.size()>0) {
                            initRecycleView(planets); //Gelen veriler ile Recycle View hazırlar
                        }
                    }

                });
    }


    private  void  initRecycleView(List<PlanetModel> planetList) { //Gelen veriler ile Recycle View'ın genel verilerini oluşturur
        recyclerView =findViewById(R.id.rcvPlanets);
        PlanetAdapter planetAdapter =new PlanetAdapter(planetList, getApplicationContext(), new PlanetAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) { //Tıklananın Json verilerini alır

                PlanetModel clickedPlanet = planetList.get(position);
                Toast.makeText(getApplicationContext(), getString(R.string.clicked_planet) + " " + clickedPlanet.getGezegenAdi(), Toast.LENGTH_SHORT).show();

                openNextActivity(clickedPlanet); //sonraki activityi açar
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(planetAdapter);
    }

    private void openNextActivity(PlanetModel clickedPlanet) { //3. Ekranı (Detay Ekranını) açar

        Intent secondActivityIntent=new Intent(getApplicationContext(),DetailsActivity.class);
        String clickedPlanetString = ObjectUtil.planetToJsonString(clickedPlanet);

        secondActivityIntent.putExtra(Constants.CLICKED_PLANETS_HEADER,clickedPlanetString);
        startActivity(secondActivityIntent);

    }

    public void onBackPressed() { //Geri tuşuna basıldığında dialog açar
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.exit_title))
                .setMessage(getString(R.string.exit_message))
                .setNegativeButton(getString(R.string.exit_negative_button), null) //Hayır'a basıldığında uygulamada kalır
                .setPositiveButton(getString(R.string.exit_positive_button), new DialogInterface.OnClickListener() { //Evete bastığında uygulamadan çıkar

                    public void onClick(DialogInterface dialog, int which) {
                        ListActivity.super.onBackPressed();
                    }
                }).create().show();
    }
}