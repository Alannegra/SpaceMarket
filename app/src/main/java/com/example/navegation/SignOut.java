package com.example.navegation;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.aghajari.axanimation.AXAnimation;
import com.royrodriguez.transitionbutton.TransitionButton;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignOut#} factory method to
 * create an instance of this fragment.
 */
public class SignOut extends Fragment {

    private TransitionButton transitionButton;
    private NavController navController;
    public SignOut() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        AXAnimation.create()
                .duration(1000)
                .alpha(1f)
                .nextSection()
                .scale(1.5f, 1.25f, 1.8f, 1f)
                .start(view.findViewById(R.id.transition_button));

        navController = Navigation.findNavController(view);
        transitionButton = view.findViewById(R.id.transition_button);
        transitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the loading animation when the user tap the button
                transitionButton.startAnimation();

                // Do your networking task or background work here.
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        boolean isSuccessful = true;

                        // Choose a stop animation if your call was succesful or not
                        if (isSuccessful) {
                            transitionButton.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                                @Override
                                public void onAnimationStopEnd() {
                                    navController.navigate(R.id.action_signOut_to_tutorial);
                                }
                            });
                        } else {
                            transitionButton.stopAnimation(TransitionButton.StopAnimationStyle.SHAKE, null);
                        }
                    }
                }, 2000);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_out, container, false);
    }
}