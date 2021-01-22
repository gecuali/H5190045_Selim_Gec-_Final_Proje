package com.h5190045.selim_gecu_final.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.h5190045.selim_gecu_final.R;
import com.h5190045.selim_gecu_final.model.PlanetModel;
import com.h5190045.selim_gecu_final.util.GlideUtil;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetViewHolder> {


    List<PlanetModel> planets;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(int position);
    }


    public PlanetAdapter(List<PlanetModel> planets, Context context, OnItemClickListener listener) {
        this.planets = planets;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Yeni bir view holder oluşturur

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_planet,parent,false);
        return new PlanetViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder viewHolder, int position) {
        //Jsondan alınan verileri, PlanetViewHolder'da belirtilen alanlara card view'ın ön yüzüne basar
        viewHolder.txtPlanetName.setText(planets.get(position).getGezegenAdi());
        viewHolder.txtPlanetExplanation.setText(planets.get(position).getGezegenYaricapi());
        viewHolder.txtPlanetExplanation2.setText(planets.get(position).getDunyayaUzakligi());
        viewHolder.txtPlanetExplanation3.setText(planets.get(position).getGezegenYuzeySicakligi());
        GlideUtil.downloadImageAndShow(context,planets.get(position).getLogoUrl(),viewHolder.imgPlanetLogo);

    }

    @Override
    public int getItemCount() {

        return planets.size();
    }
}
