package com.h5190045.selim_gecu_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190045.selim_gecu_final.R;
import com.h5190045.selim_gecu_final.model.PlanetModel;
import com.h5190045.selim_gecu_final.util.Constants;
import com.h5190045.selim_gecu_final.util.GlideUtil;
import com.h5190045.selim_gecu_final.util.ObjectUtil;

public class DetailsActivity extends AppCompatActivity {

    ImageView imgDetailsBanner;
    TextView txtHeader;
    TextView txtDetail;

    //Aşağıdaki metod, başlangıçta çalışan metoddur ve layout olarak activity_details.xml set edilmiştir
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();


    }

    private void init() { //Alınan verilere göre detay ön yüz görünümünü ayarlar
        String movedPlanetString = getIntent().getStringExtra(Constants.CLICKED_PLANETS_HEADER);
        PlanetModel planetModel = ObjectUtil.jsonStringToPlanet(movedPlanetString);

        imgDetailsBanner=findViewById(R.id.imgDetailsBanner);
        txtHeader=findViewById(R.id.txtHeader);
        txtDetail=findViewById(R.id.txtDetail);

        txtHeader.setText(planetModel.getGezegenAdi());
        txtDetail.setText(planetModel.getAciklama());

        GlideUtil.downloadImageAndShow(getApplicationContext(),planetModel.getKapakImgUrl(),imgDetailsBanner);

    }
}