package com.example.navegation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bottom2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bottom1Fragment extends Fragment {
    ImageView profile,exclamacion;
    ImageView map,carmarket,earth;
    ImageView backgroundmap;
    NavController navController;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        exclamacion = view.findViewById(R.id.exclamacion);
        exclamacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_fragment_menutopnav_to_options1Fragment);
            }
        });
        profile = view.findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_fragment_menutopnav_to_options2Fragment);
            }
        });
        carmarket = view.findViewById(R.id.carmarketbutton);
        carmarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_fragment_menubotnav_to_bottom2Fragment);
            }
        });
        earth = view.findViewById(R.id.earthbutton);
        earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_fragment_menubotnav_to_bottom3Fragment);
            }
        });


        backgroundmap = view.findViewById(R.id.backgroundmap);



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom1, container, false);
    }



}