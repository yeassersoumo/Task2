package com.example.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvm.R;
import com.example.mvvm.model.Character;
import com.example.mvvm.model.Wand;
import com.google.gson.Gson;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Gson gson = new Gson();
        Character character = gson.fromJson(getIntent().getStringExtra("obj"), Character.class);

        ImageView imageView = findViewById(R.id.characterImage);
        Glide.with(imageView)
                .load(character.getImage())
                .apply(RequestOptions.fitCenterTransform())
                 .into(imageView);



        TextView name = findViewById(R.id.characterName);
        name.setText("Name: " + character.getName());

        TextView species = findViewById(R.id.characterSpecies);
        species.setText("Species: " + character.getSpecies());

        TextView gender = findViewById(R.id.characterGender);
        gender.setText("Gender: " + character.getGender());

        TextView house = findViewById(R.id.characterHouse);
        house.setText("House: " + character.getHouse());

        TextView dateOfBirth = findViewById(R.id.characterDateOfBirth);
        dateOfBirth.setText("Date of Birth: " + character.getDateOfBirth());

        TextView yearOfBirth = findViewById(R.id.characterYearOfBirth);
        yearOfBirth.setText("Year of Birth: " + character.getYearOfBirth());

        TextView ancestry = findViewById(R.id.characterAncestry);
        ancestry.setText("Ancestry: " + character.getAncestry());

        TextView eyeColour = findViewById(R.id.characterEyeColour);
        eyeColour.setText("Eye color: " + character.getEyeColour());

        TextView hairColour = findViewById(R.id.characterHairColour);
        hairColour.setText("HairColour: " + character.getHairColour());

        TextView wood = findViewById(R.id.characterWood);
        wood.setText("Wood: " + character.getWand().getWood());

        TextView core = findViewById(R.id.characterCore);
        core.setText("Core: " + character.getWand().getCore());

        TextView length = findViewById(R.id.characterLength);
        length.setText("Length: " + character.getWand().getLength());

        TextView patronus = findViewById(R.id.characterPatronus);
        patronus.setText("Patronus: " + character.getPatronus());

        TextView hogwartsStudent = findViewById(R.id.characterHogwartsStudent);
        hogwartsStudent.setText("HogwartsStudent: " + character.getHogwartsStudent());

        TextView hogwartsStaff = findViewById(R.id.characterHogwartsStaff);
        hogwartsStaff.setText("HogwartsStaff: " + character.getHogwartsStaff());

        TextView actor = findViewById(R.id.characterActor);
        actor.setText("Actor: " +character.getActor());

        TextView isAlive = findViewById(R.id.characterAlive);
        isAlive.setText(character.getAlive()?"Alive":"Dead");


    }


}
