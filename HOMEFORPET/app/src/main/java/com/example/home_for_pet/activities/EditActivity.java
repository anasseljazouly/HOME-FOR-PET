package  com.example.home_for_pet.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.home_for_pet.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        EditText name, category, location, desc;
        Button add;

        name = findViewById(R.id.detailed_name);
        category = findViewById(R.id.race);
        location = (EditText) findViewById(R.id.localisation);
        desc = (EditText) findViewById(R.id.detailes_desc);

    private void processinsert(){
        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("category",category.getText().toString());
        map.put("location",location.getText().toString());
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("NewPets")
                .add(map)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        name.setText("");
                        category.setText("");
                        location.setText("");
                        Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Could not insert",Toast.LENGTH_LONG).show();
                    }
                });

    }
}}