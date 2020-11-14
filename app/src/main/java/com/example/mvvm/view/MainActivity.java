package com.example.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.mvvm.R;
import com.example.mvvm.adapter.HarryPotterCharacterListAdapter;
import com.example.mvvm.model.Character;
import com.example.mvvm.viewmodel.CharacterListViewModel;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HarryPotterCharacterListAdapter.ItemClickListener{

    private List<Character> characterList;
    private HarryPotterCharacterListAdapter adapter;
    private CharacterListViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter =  new HarryPotterCharacterListAdapter(this, characterList, (HarryPotterCharacterListAdapter.ItemClickListener) this);
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(CharacterListViewModel.class);
        viewModel.getCharactersListObserver().observe(this, new Observer<List<Character>>() {
            @Override
            public void onChanged(List<Character> characterList) {
                if(characterList != null) {
                    MainActivity.this.characterList = characterList;
                    adapter.setCharacterList(characterList);


                }
            }
        });
        viewModel.makeApiCall();
    }

    @Override
    public void onCharactersClick(Character character) {
        Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
        Gson gson = new Gson();
        String myJson = gson.toJson(character);
        intent.putExtra("obj", myJson);
        startActivity(intent)
        ;

    }
}
