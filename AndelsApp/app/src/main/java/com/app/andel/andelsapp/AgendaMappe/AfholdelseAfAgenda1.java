package com.app.andel.andelsapp.AgendaMappe;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.andel.andelsapp.PlanTegning.PlantegningActivity;
import com.app.andel.andelsapp.R;

public class AfholdelseAfAgenda1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afholdelse_af_agenda1);
          //her sættes AlertDialog til knappen til AfholdelseAfAgenda1 layout knappen KlageDialogAgendaAfholder
        Button KlagerDialogKnap = findViewById(R.id.KlageDialogAgendaAfholder);

        KlagerDialogKnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builderklage = new AlertDialog.Builder(AfholdelseAfAgenda1.this);
                //her sættes titlen
                builderklage.setTitle("Klager");
                builderklage.setMessage("1.1 Ole lugeter gange til med sin røv ");

              /*  builderklage.setItems(new CharSequence[]
                                {"Tag billede af skaden", "Skimmel Svamp", "Punkteret vindue", "Vinduet skal males"},
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                                switch (which) {
                                    case 0:
                                        //Toast.makeText(PlantegningActivity.this, "Tag et billede af skaden", Toast.LENGTH_SHORT).show();
                                        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                        startActivityForResult(takePicture, 0);//zero can be replaced with any action code

                                        break;
                                    case 1:
                                        Toast.makeText(PlantegningActivity.this, "Din skade er blevet modtaget", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 2:
                                        Toast.makeText(PlantegningActivity.this, "Din skade er blevet modtaget", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 3:
                                        Toast.makeText(PlantegningActivity.this, "Din skade er blevet modtaget", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                */

                builderklage.create().show();
            }
        });


        //////////////////////////////////////////////////////////////////////////


        Button RenoveringDialogKnap = findViewById(R.id.RenoveringAfholdeseAfAgenda1);
        RenoveringDialogKnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builderRenovering = new AlertDialog.Builder(AfholdelseAfAgenda1.this);
                //her sættes titlen
                builderRenovering.setTitle("Renovering");
                builderRenovering.setMessage("1.1 Ole lugeter gange til med sin røv ");

              /*  builderklage.setItems(new CharSequence[]
                                {"Tag billede af skaden", "Skimmel Svamp", "Punkteret vindue", "Vinduet skal males"},
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                                switch (which) {
                                    case 0:
                                        //Toast.makeText(PlantegningActivity.this, "Tag et billede af skaden", Toast.LENGTH_SHORT).show();
                                        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                        startActivityForResult(takePicture, 0);//zero can be replaced with any action code

                                        break;
                                    case 1:
                                        Toast.makeText(PlantegningActivity.this, "Din skade er blevet modtaget", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 2:
                                        Toast.makeText(PlantegningActivity.this, "Din skade er blevet modtaget", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 3:
                                        Toast.makeText(PlantegningActivity.this, "Din skade er blevet modtaget", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                */
                builderRenovering.create().show();
            }
        });
//////////////////////////////////////////////////////////////////////////////7


        Button ReferatDialogKnap = findViewById(R.id.RefaretAfholdeseAfAgenda1);
        KlagerDialogKnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builderReferat = new AlertDialog.Builder(AfholdelseAfAgenda1.this);
                //her sættes titlen
                builderReferat.setTitle("Referat");
                builderReferat.setMessage("1.1 Ole lugeter gange til med sin røv ");

              /*  builderklage.setItems(new CharSequence[]
                                {"Tag billede af skaden", "Skimmel Svamp", "Punkteret vindue", "Vinduet skal males"},
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                                switch (which) {
                                    case 0:
                                        //Toast.makeText(PlantegningActivity.this, "Tag et billede af skaden", Toast.LENGTH_SHORT).show();
                                        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                        startActivityForResult(takePicture, 0);//zero can be replaced with any action code

                                        break;
                                    case 1:
                                        Toast.makeText(PlantegningActivity.this, "Din skade er blevet modtaget", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 2:
                                        Toast.makeText(PlantegningActivity.this, "Din skade er blevet modtaget", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 3:
                                        Toast.makeText(PlantegningActivity.this, "Din skade er blevet modtaget", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                */
                builderReferat.create().show();
            }
        });







    }
}
