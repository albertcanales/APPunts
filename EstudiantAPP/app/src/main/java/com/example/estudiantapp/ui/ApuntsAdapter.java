package com.example.estudiantapp.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudiantapp.R;
import com.example.estudiantapp.db.Apunt;
import com.example.estudiantapp.db.ApuntsCollection;

import java.util.List;

public abstract class ApuntsAdapter extends RecyclerView.Adapter<ApuntsAdapter.ViewHolder> {

    final Context context;
    final ApuntsCollection apuntsCollection;

    ApuntsAdapter(ApuntsCollection apuntsCollection, Context context) {
        this.apuntsCollection = new ApuntsCollection(apuntsCollection.getApunts());
        this.context = context;
    }

    @NonNull
    @Override
    public abstract ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        onBindChildrenViewHolder(position);
        holder.name.setText(getItemName(position));
    }

    abstract void onBindChildrenViewHolder(int position);

    @Override
    public abstract int getItemCount();

    abstract String getItemName(int position);

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name;

        ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name);
        }
    }
}
