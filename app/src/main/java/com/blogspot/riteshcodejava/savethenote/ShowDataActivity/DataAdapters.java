package com.blogspot.riteshcodejava.savethenote.ShowDataActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.riteshcodejava.savethenote.R;

import java.util.ArrayList;


public class DataAdapters extends RecyclerView.Adapter<DataAdapters.ViewHolder> {
    Context context;
    ArrayList<DataModels> list;

    public DataAdapters(Context context, ArrayList<DataModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.costume_datalayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String idText =  String.valueOf(list.get(position).getId());
    holder.iDTextView.setText(idText);
    holder.desTextView.setText(list.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView iDTextView,desTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iDTextView = itemView.findViewById(com.blogspot.riteshcodejava.savethenote.R.id.idTextView);
            desTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
