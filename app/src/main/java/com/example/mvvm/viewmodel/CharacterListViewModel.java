package com.example.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.model.Character;
import com.example.mvvm.network.API;
import com.example.mvvm.network.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterListViewModel extends ViewModel {
    private MutableLiveData<List<Character>> characterList;

    public CharacterListViewModel() {

        characterList = new MutableLiveData<>();

    }
    public MutableLiveData<List<Character>> getCharactersListObserver() {
        return characterList;

    }

    public void makeApiCall() {
        APIService APIService = API.getRetrofitClient().create(APIService.class);
        Call<List<Character>> call = APIService.getAllUsers();

        call.enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {
                characterList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Character>> call, Throwable t) {
                characterList.postValue(null);
            }
        });

    }


        }
