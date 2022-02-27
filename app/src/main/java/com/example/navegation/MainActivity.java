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
        View botonCustom      = findViewById(R.id.button_custom);
        View botonShowCase    = findViewById(R.id.button_showcase);

        Animation animation = new AlphaAnimation(0.0f,1.0f);
        animation.setDuration(250);

        final FancyShowCaseView fancyShowCaseWelcome = new FancyShowCaseView.Builder(this)
                .title("Con esta guía tendrás una explicación rápida de los diferentes botones de la aplicación.")
                .titleStyle(R.style.showcaseText, Gravity.CENTER)
                .backgroundColor(R.color.showCaseBackground)
                .build();

        final FancyShowCaseView fancyShowCaseView1 = new FancyShowCaseView.Builder(this)
                .title("Con este tipo de SnackBar podrás mostrar un mensaje básico y sin personalización.")
                .titleStyle(R.style.showcaseText, Gravity.CENTER | Gravity.BOTTOM)
                .backgroundColor(R.color.showCaseBackground)
                .focusBorderColor(Color.BLUE)
                .focusBorderSize(5)
                .focusOn(botonBasico)
                .build();

        final FancyShowCaseView fancyShowCaseView2 = new FancyShowCaseView.Builder(this)
                .title("Con este SnackBar se añade un TextButton con el que el usuario podrá interaccionar.")
                .titleStyle(R.style.showcaseText, Gravity.CENTER | Gravity.BOTTOM)
                .backgroundColor(R.color.showCaseBackground)
                .focusCircleRadiusFactor(1.5)
                .focusOn(botonActionCall)
                .build();

        final FancyShowCaseView fancyShowCaseView3 = new FancyShowCaseView.Builder(this)
                .title("Con este SnackBar podrás personalizar el mensaje mostrado.")
                .titleStyle(R.style.showcaseText, Gravity.CENTER | Gravity.TOP)
                .backgroundColor(R.color.showCaseBackground)
                .focusOn(botonCustom)
                .build();

        final FancyShowCaseView fancyShowCaseExit = new FancyShowCaseView.Builder(this)
                .title("Con este ejercicio has aprendido a utilizar la librería FancyShowCaseView!")
                .titleStyle(R.style.showcaseText, Gravity.CENTER)
                .backgroundColor(R.color.showCaseBackground)
                .focusOn(botonShowCase)
                .build();

        FancyShowCaseQueue mQueue = new FancyShowCaseQueue()
                .add(fancyShowCaseWelcome)
                .add(fancyShowCaseView1)
                .add(fancyShowCaseView2)
                .add(fancyShowCaseView3)
                .add(fancyShowCaseExit);
        mQueue.show();

    }
}
