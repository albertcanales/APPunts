package com.example.estudiantapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.estudiantapp.R;

public class TeoriaAdapter extends ApuntsAdapter {

    private ViewHolder holder;

    TeoriaAdapter(List<Apunt> apuntList, Context context) {
        super(apuntList, context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_points, parent, false);
        holder = new ViewHolder(v);
        return holder;
    }

    @Override
    void onBindChildrenViewHolder(int position) {
        Apunt a = apuntList.get(position);
        //this.holder.textX.setText(String.format(Locale.getDefault(), "x\n%.1f", adjustToUnit(p.getX(), 1)));
        //this.holder.textY.setText(String.format(Locale.getDefault(), "y\n%.1f", adjustToUnit(p.getY(), 1)));
        //this.holder.textZ.setText(String.format(Locale.getDefault(), "z\n%.1f", adjustToUnit(p.getZ(), 1)));
    }

    @Override
    public int getItemCount() {
        return apuntList.size();
    }

    @Override
    String getItemName(int position) {
        return apuntList.get(position).getName();
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
