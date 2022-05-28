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

import com.example.home_for_pet.R;
import com.example.home_for_pet.adapters.CategoryAdapter;
import com.example.home_for_pet.models.CategoryModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView catRecyclerView;

    //category recyclv
    CategoryAdapter categoryAdapter;
    List<CategoryModel> categoryModelList;

    //FireSrtore
    FirebaseFirestore db;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root= inflater.inflate(R.layout.fragment_home, container, false);
        catRecyclerView = root.findViewById(R.id.rec_category);
        //ImageSlider imageSlider= root.findViewById(R.id.image_slider);
        //List<SliderModel> sliderModels= new ArrayList<>();
        //sliderModels.add(new SlideModels(R.drawble.banner1,"Siscount On Shoes Items",ScaleTypes.CENTER_CROP)));
        //imageSlider.setImageList(slideModels);

        catRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoryModelList=new ArrayList<>();
        categoryAdapter=new CategoryAdapter(getActivity(),categoryModelList);
        catRecyclerView.setAdapter(categoryAdapter);
        db.collection("category")
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


                        }
                    }
                });
        return root;
    }
}