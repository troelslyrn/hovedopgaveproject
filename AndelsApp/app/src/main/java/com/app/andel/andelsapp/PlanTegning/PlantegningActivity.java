package com.app.andel.andelsapp.PlanTegning;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//import com.app.andel.andelsapp.AgendaMappe.PunktMappe.Punkt1;
import com.app.andel.andelsapp.MainActivity;
import com.app.andel.andelsapp.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PlantegningActivity extends AppCompatActivity {
    ArrayList<String> ArrayInputList = new ArrayList<>();
    static final int CAPTURE_IMAGE_REQUEST = 1;
    File photoFile = null;

    String mCurrentPhotoPath;
    private static final String IMAGE_DIRECTORY_NAME = "VLEMONN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantegning);

        ImageButton home = (ImageButton) findViewById(R.id.imageButtonHomePlantegning);

home.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(PlantegningActivity.this, MainActivity.class));
    }
});

// Dialogboks her lavet vi dialogboksen.

        final TextView vinduedialog1 = findViewById(R.id.DialogTextV);
        Button Dialogklap1 = findViewById(R.id.Vindue1);
       // svare til 1 knap starter her
        Dialogklap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  final AlertDialog.Builder builder = new AlertDialog.Builder(PlantegningActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Angiv");
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
              builder.setPositiveButton("skimmelsvamp", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      builder.setMessage("din besked er");
                  }
              });
               // builder.setPositiveButton("Tag Billede", new DialogInterface.OnClickListener() {
                 //   @Override
                   // public void onClick(DialogInterface dialog, int which) {
                     //   Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                       // startActivityForResult(takePicture, 0);//zero can be replaced with any action code

                    //}
               // });
             builder.show();*/

                AlertDialog.Builder builder = new AlertDialog.Builder(PlantegningActivity.this);
                builder.setTitle("Title");
                builder.setItems(new CharSequence[]
                                {"Tag billede af skaden", "Skriv ", "vis tekst"},
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                                switch (which) {
                                  /*  case 0:
                                        //Toast.makeText(PlantegningActivity.this, "Tag et billede af skaden", Toast.LENGTH_SHORT).show();


                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                            captureImage();
                                        }
                                        else
                                        {
                                            captureImage2();
                                        }
                                        //Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                         //startActivityForResult(takePicture, 0);//zero can be replaced with any action code

                                      break;
                                    */case 1:

                                      final Dialog ThisDialog = new Dialog(PlantegningActivity.this);
                                        ThisDialog.setTitle("Skriv din almeldese her");
                                        ThisDialog.setContentView(R.layout.dialogtextlayout);
                                        final EditText Write = (EditText)ThisDialog.findViewById(R.id.write);
                                        Button SaveMessage = (Button)ThisDialog.findViewById(R.id.SaveNow);
                                        SaveMessage.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                String getInput = Write.getText().toString();

                                                if (ArrayInputList.contains(getInput)){

                                                    Toast.makeText(getBaseContext(),"Item ...... allreadey",Toast.LENGTH_LONG ).show();
                                                }else {
                                                    if (getInput == null || getInput.trim().equals("")){
                                                        Toast.makeText(getBaseContext(),"No Input in Textfield",Toast.LENGTH_LONG ).show();
                                                    }
                                                    // dette kode skal ændres når det skal sætte ned på databasen
                                                    else{
                                                        ArrayInputList.add(getInput);
                                                        ArrayAdapter<String> inputAdapter = new ArrayAdapter<String>(PlantegningActivity.this,android.R.layout.simple_list_item_1,ArrayInputList);
                                                        //Punkt1ConclusionList.setAdapter(inputAdapter);
                                                        //((EditText)findViewById(R.id.write)).setText("");

                                                    }

                                                }

                                                ThisDialog.cancel();
                                            }
                                        });
                                        Write.setEnabled(true);
                                        SaveMessage.setEnabled(true);

                                       /* SaveMyName.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                SharedPrefesSAVE(Write.getText().toString());
                                                ThisDialog.cancel();
                                            }
                                        });

                                        */

                                        ThisDialog.show();
                                        //ThisDialog.cancel();

                                        //Toast.makeText(PlantegningActivity.this, "Din skade er blevet modtaget", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 2:
                                       /* SharedPreferences SP = getApplicationContext().getSharedPreferences("NAME", 0);
                                        Myname.setText(SP.getString("Name", null)); */

                                        //Toast.makeText(PlantegningActivity.this, "Din skade er blevet modtaget", Toast.LENGTH_SHORT).show();
                                        break;

                                }
                            }
                        });
                builder.create().show();
               // builder.create().cancel();

            }
        });
        // første knap slutter her





        /*Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences SP = getApplicationContext().getSharedPreferences("NAME", 0);
                Myname.setText(SP.getString("Name", null));
            }
       });
        */

       /* public void SharedPrefesSAVE(String Name){
            SharedPreferences prefs = getApplicationContext().getSharedPreferences("NAME", 0);
            SharedPreferences.Editor prefEDIT = prefs.edit();
            prefEDIT.putString("Name", Name);
            prefEDIT.commit();
        } */
    }
}
