package com.wasisoft.sofittesttask.ui.baseactivity.fragments.posts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wasisoft.sofittesttask.R;
import com.wasisoft.sofittesttask.model.Posts;
import com.wasisoft.sofittesttask.util.Constants;

import java.util.List;

public class PostsRecyclerAdapter extends RecyclerView.Adapter<PostsRecyclerAdapter.MyViewHolder> {
    private List<Posts> posts;

    public PostsRecyclerAdapter(List<Posts> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item_design, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewHeader;
        private TextView textViewTitle;
        private TextView textViewDesc;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewHeader = itemView.findViewById(R.id.image_view);
            textViewTitle = itemView.findViewById(R.id.title_text_view);
            textViewDesc = itemView.findViewById(R.id.desc_text_view);
        }

        void onBind(Posts post) {
            Glide.with(imageViewHeader.getContext()).load(Constants.ICON_SELLER_URL).placeholder(R.drawable.ic_placeholder).into(imageViewHeader);
            textViewDesc.setText(post.getBody());
            textViewTitle.setText(post.getTitle());
        }
    }

}
