package com.example.project;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        String[] paradigms = recyclerList.get(position).getParadigm();
        holder.paradigmLayout.removeAllViews();
        for (String paradigm: paradigms) {
            TextView textView = new TextView(holder.paradigmLayout.getContext());
            textView.setText(paradigm);
            textView.setBackgroundResource(R.drawable.tag_background);
            textView.setPadding(10, 0, 10, 0);
            holder.paradigmLayout.addView(textView);
        }
    }

    @Override
    public int getItemCount() {
        return recyclerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        LinearLayout paradigmLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.item_name);
            paradigmLayout = itemView.findViewById(R.id.item_paradigm);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(recyclerList.get(getAdapterPosition()));
        }
    }
    public interface OnClickListener {
        void onClick(RecyclerItem recyclerItem);
    }

    public void filter(String[] paradigms) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
            && Arrays.stream(paradigms).allMatch(Objects::isNull)) {
            notifyDataSetChanged();
            return;
        }
        List<RecyclerItem> newList = new ArrayList<>();
        for (RecyclerItem item: recyclerList) {
            for (String paradigm: paradigms) {
                if (paradigm == null) { continue; }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    if (!Arrays.stream(item.getParadigm()).anyMatch(paradigm::equals)) {
                        if (newList.contains(item)) {
                            newList.remove(item);
                        }
                        break;
                    }
                    if (!newList.contains(item)) { newList.add(item); }
                }
            }
        }
        recyclerList = newList;
        notifyDataSetChanged();
    }
}
