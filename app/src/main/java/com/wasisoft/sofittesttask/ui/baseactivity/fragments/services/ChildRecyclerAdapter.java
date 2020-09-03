package com.wasisoft.sofittesttask.ui.baseactivity.fragments.services;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wasisoft.sofittesttask.R;
import com.wasisoft.sofittesttask.model.GovernmentServiceChild;

import java.util.List;

public class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildRecyclerAdapter.MyViewHolder> {
    private List<GovernmentServiceChild> childList;

    public ChildRecyclerAdapter(List<GovernmentServiceChild> childList) {
        this.childList = childList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item_design, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(childList.get(position));
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private ImageView imageViewIcon;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.title_text_view);
            imageViewIcon = itemView.findViewById(R.id.image_view_icon);
        }

        void onBind(GovernmentServiceChild child) {
            Glide.with(imageViewIcon.getContext()).load(child.getImage()).centerInside().placeholder(R.drawable.ic_placeholder).into(imageViewIcon);
            textViewTitle.setText(child.getTitle());
        }
    }
}
