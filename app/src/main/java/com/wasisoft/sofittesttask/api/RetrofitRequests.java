package com.wasisoft.sofittesttask.api;

import com.wasisoft.sofittesttask.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitRequests {
    @GET("posts")
    Call<List<Posts>> getPosts();
}
