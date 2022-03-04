package com.example.navegation;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.aghajari.axanimation.AXAnimation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tutorial#} factory method to
 * create an instance of this fragment.
 */
public class tutorial extends Fragment {

    ImageView imageView;
    NavController navController;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        imageView = view.findViewById(R.id.mapbutton);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_tutorial_to_bottom1Fragment);
            }
        });

        GradientDrawable gd1 = new GradientDrawable();
        gd1.setColors(new int[]{Color.CYAN, Color.BLUE});
        gd1.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);

        GradientDrawable gd2 = new GradientDrawable();
        gd2.setColors(new int[]{Color.BLUE, Color.CYAN});
        gd2.setOrientation(GradientDrawable.Orientation.TL_BR);
        gd2.setCornerRadius(100);
        gd2.setStroke(100, Color.GRAY, 0, 0);

        ColorDrawable cd = new ColorDrawable(Color.WHITE);

        AXAnimation.create()
                .duration(4000)
                .background(gd1, gd2, cd)
                .scale(5f,0.5f,1f)
                .rotation(360f)
                .start(view.findViewById(R.id.button_custom));


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutorial, container, false);
    }
}