package com.wasisoft.sofittesttask.ui.baseactivity.fragments.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wasisoft.sofittesttask.R;
import com.wasisoft.sofittesttask.model.News;

import java.util.List;

public class HeaderRecyclerAdapter extends RecyclerView.Adapter<HeaderRecyclerAdapter.MyViewHolder> {
    private List<News> news;

    public HeaderRecyclerAdapter(List<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item_design, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(news.get(position));
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewHeader;
        private TextView textViewDesc;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewHeader = itemView.findViewById(R.id.header_image_view);
            textViewDesc = itemView.findViewById(R.id.header_text_view);
        }

        void onBind(News news) {
            Glide.with(imageViewHeader.getContext()).load(news.getImage()).placeholder(R.drawable.ic_placeholder).into(imageViewHeader);
            textViewDesc.setText(news.getDesc());
        }
    }
}
