package com.h5190045.selim_gecu_final.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190045.selim_gecu_final.R;

public class PlanetViewHolder extends RecyclerView.ViewHolder {

    ImageView imgPlanetLogo;
    TextView txtPlanetName;
    TextView txtPlanetExplanation;
    TextView txtPlanetExplanation2;
    TextView txtPlanetExplanation3;

    //Card view'da bulunan itemlerin atanacağı yerler buradan çekilir
    public PlanetViewHolder(@NonNull View cardView, PlanetAdapter.OnItemClickListener listener) {
        super(cardView);

        imgPlanetLogo =cardView.findViewById(R.id.imgPlanetLogo);
        txtPlanetName =cardView.findViewById(R.id.txtPlanetName);
        txtPlanetExplanation =cardView.findViewById(R.id.txtPlanetExplanation);
        txtPlanetExplanation2 =cardView.findViewById(R.id.txtPlanetExplanation2);
        txtPlanetExplanation3 =cardView.findViewById(R.id.txtPlanetExplanation3);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onClick(getAdapterPosition());
            }
        });
    }
}
