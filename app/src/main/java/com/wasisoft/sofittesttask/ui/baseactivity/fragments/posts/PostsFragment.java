package com.wasisoft.sofittesttask.ui.baseactivity.fragments.posts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.wasisoft.sofittesttask.R;
import com.wasisoft.sofittesttask.model.Posts;

import java.util.List;


public class PostsFragment extends Fragment {
    private RecyclerView recyclerView;
    private PostsViewModel postsViewModel;
    private ProgressBar progressBar;
    private Observer<List<Posts>> postsObserver = posts -> {
        progressBar.setVisibility(View.INVISIBLE);
        if (posts != null) recyclerView.setAdapter(new PostsRecyclerAdapter(posts));
    };

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        postsViewModel = new ViewModelProvider(this).get(PostsViewModel.class);
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progress_bar);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        postsViewModel.liveDataOfPosts.observe(getViewLifecycleOwner(), postsObserver);
    }
}