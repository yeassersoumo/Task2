package com.example.mvvm.network;

import com.example.mvvm.model.Character;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("characters")
    Call<List<Character>> getAllUsers();

}
