package com.example.home_for_pet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home_for_pet.R;
import com.example.home_for_pet.fragments.MessagesList;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>{

    private final List<MessagesList> messagesLists;
    private final Context context;

    public MessageAdapter(List<MessagesList> messagesList, Context context) {
        this.messagesLists = messagesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat2,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MyViewHolder holder, int position) {

        MessagesList List2 = messagesLists.get(position);
        //if(!list2.getProfilePic().isEmpty()){



        //}







    }


    @Override
    public int getItemCount() {
        return messagesLists.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView message ;
        private ImageView profilpic;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            profilpic= itemView.findViewById(R.id.profilpic);

        }
    }
}