package com.example.estudiantapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.estudiantapp.R;
import com.example.estudiantapp.db.Apunt;
import com.example.estudiantapp.db.ApuntsCollection;

import java.util.List;

public class TeoriaAdapter extends ApuntsAdapter {

    private ViewHolder holder;

    TeoriaAdapter(ApuntsCollection apuntsCollection, Context context) {
        super(apuntsCollection, context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_apunts, parent, false);
        holder = new ViewHolder(v);
        return holder;
    }

    @Override
    void onBindChildrenViewHolder(int position) {
        Apunt a = apuntsCollection.getApunts().get(position);
        //this.holder.textX.setText(String.format(Locale.getDefault(), "x\n%.1f", adjustToUnit(p.getX(), 1)));
        //this.holder.textY.setText(String.format(Locale.getDefault(), "y\n%.1f", adjustToUnit(p.getY(), 1)));
        //this.holder.textZ.setText(String.format(Locale.getDefault(), "z\n%.1f", adjustToUnit(p.getZ(), 1)));
    }

    @Override
    public int getItemCount() {
        return apuntsCollection.getApunts().size();
    }

    @Override
    String getItemName(int position) {
        return apuntsCollection.getApunts().get(position).getPdfName();
    }

    static class ViewHolder extends ApuntsAdapter.ViewHolder {
        //final TextView textX, textY, textZ;

        ViewHolder(View v) {
            super(v);
            //textX = v.findViewById(R.id.angleX);
            //textY = v.findViewById(R.id.angleY);
            //textZ = v.findViewById(R.id.angleZ);
        }
    }
}
