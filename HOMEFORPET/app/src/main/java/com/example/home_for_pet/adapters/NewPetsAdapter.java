package com.example.home_for_pet.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.home_for_pet.R;
import com.example.home_for_pet.activities.DetailedActivity;
import com.example.home_for_pet.models.NewPetsModel;

import java.util.List;

public class NewPetsAdapter extends RecyclerView.Adapter<NewPetsAdapter.ViewHolder> {
    private Context context;
    private List<NewPetsModel> list;

    public NewPetsAdapter(Context context, List<NewPetsModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_pits,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImg_url()).into(holder.newImg);
        holder.newName.setText(list.get(position).getName());
        holder.newType.setText(list.get(position).getType());
        holder.newPosition.setText(list.get(position).getLocalisation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailedActivity.class);
                //intent.putExtra("detailed",list.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView newImg;
        TextView newName,newType,newPosition;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            newImg = itemView.findViewById(R.id.new_img);
            newName = itemView.findViewById(R.id.new_product_name);
            newType = itemView.findViewById(R.id.type);
            newPosition = itemView.findViewById(R.id.pos);


        }
    }
}
