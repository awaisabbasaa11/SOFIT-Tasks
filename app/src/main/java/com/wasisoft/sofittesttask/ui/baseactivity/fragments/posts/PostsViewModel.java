package com.wasisoft.sofittesttask.ui.baseactivity.fragments.posts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.wasisoft.sofittesttask.model.Posts;
import com.wasisoft.sofittesttask.repository.PostsRepository;

import java.util.List;

public class PostsViewModel extends ViewModel {
    public LiveData<List<Posts>> liveDataOfPosts;

    public PostsViewModel() {
        PostsRepository repository = PostsRepository.getRepository();
        liveDataOfPosts = repository.getPosts();
    }

}