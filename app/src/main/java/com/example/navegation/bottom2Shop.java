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
import android.widget.TextView;

import com.aghajari.axanimation.AXAnimation;

import pl.droidsonroids.gif.GifImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link bottom2Shop#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bottom2Shop extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public bottom2Shop() {
        // Required empty public constructor
    }


    ImageView imageView,imageView2;
    NavController navController;
    TextView textView,textView2;

    ImageView profile,exclamacion;
    ImageView map,carmarket,earth;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        map = view.findViewById(R.id.mapbutton);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_bottom2Shop_to_bottom1Fragment);
            }
        });
        earth = view.findViewById(R.id.earthbutton);
        earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_bottom2Shop_to_bottom3Fragment);
            }
        });
        exclamacion = view.findViewById(R.id.exclamacion);
        exclamacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_bottom2Shop_to_options1Fragment);
            }
        });
        profile = view.findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_bottom2Shop_to_options2Fragment);
            }
        });




        imageView = view.findViewById(R.id.tarjetabutton);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_bottom2Shop_to_creditcard);
            }
        });

        textView = view.findViewById(R.id.tarjetabutton2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_bottom2Shop_to_creditcard);
            }
        });

        imageView2 = view.findViewById(R.id.imageView31);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AXAnimation.create()
                        .duration(750)
                        .alpha(1f)
                        .nextSection()
                        .scale(1.5f, 1f)
                        .rotation(60f,-60f,60f,-60f,0f)
                        .start(view.findViewById(R.id.imageView31));


            }
        });

        textView2 = view.findViewById(R.id.ASD);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AXAnimation.create()
                        .duration(750)
                        .alpha(1f)
                        .nextSection()
                        .scale(1.5f, 1f)
                        .rotation(60f,-60f,60f,-60f,0f)
                        .start(view.findViewById(R.id.ASD));

            }
        });

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bottom2Shop.
     */
    // TODO: Rename and change types and number of parameters
    public static bottom2Shop newInstance(String param1, String param2) {
        bottom2Shop fragment = new bottom2Shop();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom2_shop, container, false);
    }


}