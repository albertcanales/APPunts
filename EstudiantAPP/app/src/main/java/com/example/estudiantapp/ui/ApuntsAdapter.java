package com.example.estudiantapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudiantapp.R;
import com.example.estudiantapp.db.Apunt;
import com.example.estudiantapp.db.ApuntsCollection;

public class ApuntsAdapter extends RecyclerView.Adapter<ApuntsAdapter.ViewHolder> {

    final Context context;
    final ApuntsCollection apuntsCollection;

    ApuntsAdapter(ApuntsCollection apuntsCollection, Context context) {
        this.apuntsCollection = new ApuntsCollection(apuntsCollection.getApunts());
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_apunts, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        onBindChildrenViewHolder(position);
        holder.name_tv.setText(getItemName(position));
        holder.author_tv.setText(getItemAuthor(position));
    }

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

    String getItemName(int position) {
        return apuntsCollection.getApunts().get(position).getPdfName();
    }

    String getItemAuthor(int position) {
        return apuntsCollection.getApunts().get(position).getAuthor();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name_tv;
        final TextView author_tv;

        ViewHolder(View v) {
            super(v);
            name_tv = v.findViewById(R.id.name_tv);
            author_tv = v.findViewById(R.id.author_tv);
        }
    }
}
