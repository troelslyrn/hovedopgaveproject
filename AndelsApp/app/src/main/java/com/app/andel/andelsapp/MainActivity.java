package com.app.andel.andelsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//import com.app.andel.andelsapp.AgendaMappe.AfholdelseAfAgenda;
//import com.app.andel.andelsapp.AgendaMappe.AfholdelseAfAgenda1;
//import com.app.andel.andelsapp.AgendaMappe.AfholdseAfAgenda2;
//import com.app.andel.andelsapp.AgendaMappe.Agenda;
//import com.app.andel.andelsapp.AgendaMappe.PunktMappe.Punkt2;
//import com.app.andel.andelsapp.AgendaMappe.PunktMappe.konklussionskriver;
//import com.app.andel.andelsapp.CustomizeActivity.CustomFieldsActivity;
//import com.app.andel.andelsapp.AgendaMappe.AfholdelseAfAgenda1;
//import com.app.andel.andelsapp.LoginFolder.LoginActivity2;
import com.app.andel.andelsapp.LoginFolder.LoginActivity3;
//import com.app.andel.andelsapp.PlanTegning.PlantegningActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button AgendaKnap =findViewById(R.id.AgendaButtonNavigator);
        AgendaKnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity3.class));
            }
        });


       // Button CustomFieldButton = findViewById(R.id.CustomFieldNavigator);
        /*CustomFieldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CustomFieldsActivity.class));
            }
        });
        */
        /*
       Button nab = findViewById(R.id.PlantegningNavigatorKnap);
       nab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,konklussionskriver.class));
           }
       });
       */


     //   Button AgendaAfholderknap = findViewById(R.id.AgandaAfholderButton);
    /*      AgendaAfholderknap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AfholdelseAfAgenda.class));
            }
        });
        */
       /* Button AgendaAfholderKnap1 = findViewById(R.id.AgendaAfHolderButton1);
        AgendaAfholderKnap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AfholdelseAfAgenda1.class));
            }
        });
        */
/*
        Button AgendaAfholderKnap2 = findViewById(R.id.AgandaAfholderButton2);
        AgendaAfholderKnap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AfholdseAfAgenda2.class));
            }
        });
        Button testknap = findViewById(R.id.buttonTest);
        testknap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Punkt2.class));
            }
        });
        */
    }
}
