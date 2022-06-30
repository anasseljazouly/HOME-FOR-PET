package com.example.home_for_pet.fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.home_for_pet.R;
import com.example.home_for_pet.adapters.CategoryAdapter;
import com.example.home_for_pet.adapters.NewPetsAdapter;
import com.example.home_for_pet.models.CategoryModel;
import com.example.home_for_pet.models.NewPetsModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView catRecyclerView,newPetsRecyclerview;

    //category recyclv
    CategoryAdapter categoryAdapter;
    List<CategoryModel> categoryModelList;

    //new pet recycle..
    NewPetsAdapter newPetsAdapter;
    List<NewPetsModel> newPetsModelsList;



    //FireSrtore
    //FirebaseFirestore db;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root= inflater.inflate(R.layout.fragment_home, container, false);



        catRecyclerView = root.findViewById(R.id.rec_category);
        newPetsRecyclerview= root.findViewById(R.id.new_product_rec);
        //ImageSlider imageSlider= root.findViewById(R.id.image_slider);
        //List<SliderModel> sliderModels= new ArrayList<>();
        //sliderModels.add(new SlideModels(R.drawble.banner1,"Siscount On Shoes Items",ScaleTypes.CENTER_CROP)));
        //imageSlider.setImageList(slideModels);

        catRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoryModelList=new ArrayList<>();
        categoryAdapter=new CategoryAdapter(getActivity(),categoryModelList);
        catRecyclerView.setAdapter(categoryAdapter);
        db.collection("Category")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                CategoryModel categoryModel= document.toObject(CategoryModel.class);
                                 categoryModelList.add(categoryModel);
                                 categoryAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(),""+task.getException(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        //New pets
        newPetsRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        newPetsModelsList = new ArrayList<>();
        newPetsAdapter = new NewPetsAdapter(getContext(),newPetsModelsList);
        newPetsRecyclerview .setAdapter(newPetsAdapter);
        db.collection("NewPets")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                NewPetsModel newPetsModel = document.toObject(NewPetsModel.class);
                                newPetsModelsList.add(newPetsModel);
                                newPetsAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(),""+task.getException(),Toast.LENGTH_SHORT).show();


                        }
                    }
                });
        return root;
    }
}