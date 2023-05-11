package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<RecyclerItem> recyclerList;
    private OnClickListener onClickListener;
    private LayoutInflater layoutInflater;

    public RecyclerViewAdapter(Context context, List<RecyclerItem> recyclerList, OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.layoutInflater = LayoutInflater.from(context);
        this.recyclerList = recyclerList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.name.setText(recyclerList.get(position).getName());
        holder.paradigm.setText(recyclerList.get(position).getParadigm());
    }

    @Override
    public int getItemCount() {
        return recyclerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView paradigm;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.item_name);
            paradigm = itemView.findViewById(R.id.item_paradigm);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(recyclerList.get(getAdapterPosition()));
        }
    }
    public interface OnClickListener {
        void onClick(RecyclerItem recyclerItem);
    }
}
