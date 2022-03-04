package com.example.navegation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.example.navegation.databinding.FragmentBottom1Binding;

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
    private FragmentBottom1Binding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentBottom1Binding.inflate(inflater, container, false)).getRoot();
    }

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
        binding.viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0: default:
                        return new Imagen1mapa();
                    case 1:
                        return new Imagen2mapa();
                    case 2:
                        return new Imagen1mapa();
                }
            }

            @Override
            public int getItemCount() {
                return 3;
            }
        });


    }




}