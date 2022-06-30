package com.example.home_for_pet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.home_for_pet.R;
import com.example.home_for_pet.models.NewPetsModel;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailedActivity extends AppCompatActivity {

            ImageView detailedImg;
            TextView name,description,localisation,type;
            NewPetsModel newPetsModel = null;
            private FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        firestore=FirebaseFirestore.getInstance();

        final Object obj=getIntent().getSerializableExtra("detailed");

        final Button Btn = findViewById(R.id.add);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DetailedActivity.this, EditActivity.class);
                startActivity(intent);
                finish();

            }
        });

        if(obj instanceof NewPetsModel){
            newPetsModel=(NewPetsModel) obj;
        }

        detailedImg=findViewById(R.id.detailed_img);
        name =findViewById(R.id.detailed_name);
        description=findViewById(R.id.desc);
        localisation=findViewById(R.id.loc);
        type=findViewById(R.id.race);

        if(newPetsModel !=null){
            Glide.with(getApplicationContext()).load(newPetsModel.getImg_url()).into(detailedImg);
            name.setText(newPetsModel.getName());
            description.setText(newPetsModel.getDescription());
            localisation.setText(newPetsModel.getLocalisation());
            type.setText(newPetsModel.getType());

        }

    }
}