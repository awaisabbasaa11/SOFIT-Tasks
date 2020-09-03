package com.wasisoft.sofittesttask.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.wasisoft.sofittesttask.api.RetrofitRequests;
import com.wasisoft.sofittesttask.api.RetrofitService;
import com.wasisoft.sofittesttask.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsRepository {
    private static PostsRepository repository;
    private RetrofitRequests postsRequest;

    private PostsRepository() {
        postsRequest = RetrofitService.createServices(RetrofitRequests.class);
    }

    public static PostsRepository getRepository() {
        if (repository == null) repository = new PostsRepository();
        return repository;
    }

    public LiveData<List<Posts>> getPosts() {
        final MutableLiveData<List<Posts>> mutableResponse = new MutableLiveData<>();
        postsRequest.getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (response.isSuccessful()) mutableResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return mutableResponse;
    }
}
