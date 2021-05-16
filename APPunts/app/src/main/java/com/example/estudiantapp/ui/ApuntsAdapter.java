package com.example.estudiantapp.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudiantapp.R;
import com.example.estudiantapp.activities.BibliotecaActivity;
import com.example.estudiantapp.db.Apunt;
import com.example.estudiantapp.db.ApuntsCollection;

public class ApuntsAdapter extends RecyclerView.Adapter<ApuntsAdapter.ViewHolder> {

    final Context context;
    final ApuntsCollection apuntsCollection;

    public ApuntsAdapter(ApuntsCollection apuntsCollection, Context context) {
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
        holder.name_tv.setText(getItemName(position));
        holder.author_tv.setText(getItemAuthor(position));
        holder.layout.setOnClickListener(
                new BibliotecaActivity.ChangeToApunt(apuntsCollection.getApunts().get(position)));
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
        final LinearLayout layout;
        final TextView name_tv;
        final TextView author_tv;

        ViewHolder(View v) {
            super(v);
            layout = v.findViewById(R.id.list_lay);
            name_tv = v.findViewById(R.id.name_tv);
            author_tv = v.findViewById(R.id.author_tv);
        }
    }
}
