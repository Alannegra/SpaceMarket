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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aghajari.axanimation.AXAnimation;

public class fragment_login extends Fragment {
    ImageView imageView;
    NavController navController;
    Button button;
    TextView textView,textView2;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AXAnimation.create()
                .duration(1000)
                .alpha(1f)
                .nextSection()
                .scale(1.25f, 1f, 1.5f,1.25f, 1f)
                .start(view.findViewById(R.id.cohete2));

        AXAnimation.create()
                .duration(1000)
                .alpha(1f)
                .nextSection()
                .scale(1.25f, 1f, 1.5f,1.25f, 1f)
                .start(view.findViewById(R.id.imageView16));

        navController = Navigation.findNavController(view);

        textView = view.findViewById(R.id.cohetesignin);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_fragment_login_to_signIn);
            }
        });

        textView2 = view.findViewById(R.id.cohetesignout);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_fragment_login_to_signOut);
            }
        });


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
}