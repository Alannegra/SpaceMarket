package com.example.navegation;

import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.aghajari.axanimation.AXAnimation;
import com.example.navegation.databinding.ActivityMainBinding;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        /*setSupportActionBar(binding.toolbar);*/

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                // Top-level destinations:
                R.id.bottom1Fragment, R.id.bottom2Fragment, R.id.bottom3Fragment, R.id.options1Fragment, R.id.options2Fragment
        ).build();

        navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();

        //NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(binding.bottomNavView, navController);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }


    public void lanzaShowCaseView(View view){




        View botonBasico      = findViewById(R.id.button_default);
        View botonActionCall  = findViewById(R.id.button_actionCall);
        View botonActionCall2  = findViewById(R.id.button_actionCall2);
        View botonActionCall3  = findViewById(R.id.button_actionCall3);
        View botonCustom      = findViewById(R.id.button_custom);
        View botonShowCase    = findViewById(R.id.button_showcase);


        Animation animation = new AlphaAnimation(0.0f,1.0f);
        animation.setDuration(250);

        final FancyShowCaseView fancyShowCaseWelcome = new FancyShowCaseView.Builder(this)
                .title("Bienvenido a Spacemarket")
                .titleStyle(R.style.showcaseText, Gravity.CENTER )
                .backgroundColor(R.color.black)
                .focusBorderColor(Color.BLACK)
                .focusBorderSize(5)
                .build();

        final FancyShowCaseView fancyShowCaseView1 = new FancyShowCaseView.Builder(this)
                .title("Mapa")
                .titleStyle(R.style.showcaseText, Gravity.CENTER )
                .backgroundColor(R.color.black)
                .focusBorderColor(Color.BLACK)
                .focusBorderSize(5)
                .focusOn(botonBasico)
                .build();

        final FancyShowCaseView fancyShowCaseView6 = new FancyShowCaseView.Builder(this)
                .title("Exclamacion")
                .titleStyle(R.style.showcaseText, Gravity.CENTER )
                .backgroundColor(R.color.black)
                .focusBorderColor(Color.BLACK)
                .focusBorderSize(5)
                .focusOn(botonActionCall)
                .build();


        final FancyShowCaseView fancyShowCaseView2 = new FancyShowCaseView.Builder(this)
                .title("Spacecart")
                .titleStyle(R.style.showcaseText, Gravity.CENTER )
                .backgroundColor(R.color.black)
                .focusBorderColor(Color.BLACK)
                .focusBorderSize(5)
                .focusOn(botonActionCall2)
                .build();

        final FancyShowCaseView fancyShowCaseView7 = new FancyShowCaseView.Builder(this)
                .title("Earth")
                .titleStyle(R.style.showcaseText, Gravity.CENTER )
                .backgroundColor(R.color.black)
                .focusBorderColor(Color.BLACK)
                .focusBorderSize(5)
                .focusOn(botonActionCall3)
                .build();

        final FancyShowCaseView fancyShowCaseView3 = new FancyShowCaseView.Builder(this)
                .title("borrar")
                .titleStyle(R.style.showcaseText, Gravity.CENTER )
                .backgroundColor(R.color.black)
                .focusBorderColor(Color.BLACK)
                .focusBorderSize(5)
                .focusOn(botonCustom)
                .build();

        final FancyShowCaseView fancyShowCaseExit = new FancyShowCaseView.Builder(this)
                .title("Profile")
                .titleStyle(R.style.showcaseText, Gravity.CENTER )
                .backgroundColor(R.color.black)
                .focusBorderColor(Color.BLACK)
                .focusBorderSize(5)
                .focusOn(botonShowCase)
                .build();

        FancyShowCaseQueue mQueue = new FancyShowCaseQueue()
                .add(fancyShowCaseWelcome)
                .add(fancyShowCaseView1)
                .add(fancyShowCaseView2)
                .add(fancyShowCaseView7)
                .add(fancyShowCaseView6)
                .add(fancyShowCaseExit);
        mQueue.show();

    }
}
