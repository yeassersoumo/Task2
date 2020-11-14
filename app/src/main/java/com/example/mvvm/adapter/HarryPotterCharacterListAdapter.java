package com.example.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvm.R;
import com.example.mvvm.model.Character;

import java.util.List;

public class HarryPotterCharacterListAdapter extends RecyclerView.Adapter<HarryPotterCharacterListAdapter.ViewHolder> {

    private Context context;

    private List<Character> characterList;
    private ItemClickListener clickListener;

    public HarryPotterCharacterListAdapter(Context context, List<Character> characterList, ItemClickListener clickListener) {
        this.context = context;
        this.characterList = characterList;
        this.clickListener = clickListener;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText("Name: " + this.characterList.get(position).getName());
        holder.gender.setText("Gender: " + this.characterList.get(position).getGender());
        holder.hairColor.setText("Hair Color: " + this.characterList.get(position).getHairColour());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onCharactersClick(characterList.get(position));

            }
        });

        Glide.with(context)
                .load(this.characterList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {

        if (this.characterList != null) {
            return this.characterList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, gender, hairColor;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            gender = (TextView) itemView.findViewById(R.id.gender);
            hairColor = (TextView) itemView.findViewById(R.id.hairColor);
            imageView = (ImageView) itemView.findViewById(R.id.image);

        }
    }

    public interface ItemClickListener {
        void onCharactersClick(Character character);


    }


}
