package com.app.andel.andelsapp.AgendaMappe.PunktMappe;
/*
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.app.andel.andelsapp.appolloQueries.GetallpostsqueriesQuery;
import com.app.andel.andelsapp.MainActivity;
import com.app.andel.andelsapp.MyApolloClient;
import com.app.andel.andelsapp.R;
import com.app.andel.andelsapp.appolloQueries.MakecommentMutation;

import java.util.ArrayList;

import javax.annotation.Nonnull;
/*
public class Punkt2 extends AppCompatActivity {
    private static final String TAG = "punkt123";
    //private static final String TAG = "Punkt2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punkt2);
        // getPosts();
        //final ArrayList<String> ArrayInputList = new ArrayList<>();
       // Button savebutton;
        // savebutton = findViewById(R.id.SaveNow2);
        final EditText konklusionsskriver;
        konklusionsskriver = findViewById(R.id.Writer2);
        //final ListView konklusionsview = findViewById(R.id.Konklusion2);

        makecomment();

       /* Button tilbageknap = findViewById(R.id.BackButtonPunkt2);
        tilbageknap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Punkt2.this, Punkt1.class));
            }
        });
        ImageButton menuknap = findViewById(R.id.MenuButtonPunkt2);
        menuknap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Punkt2.this, MainActivity.class));
            }
        });

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getinput = konklusionsskriver.getText().toString();

                if (ArrayInputList.contains(getinput)) {

                    Toast.makeText(getBaseContext(), "Der er allerede nogen der har skrevet denne kommentar", Toast.LENGTH_LONG).show();
                } else {
                    if (getinput == null || getinput.trim().equals("")) {
                        Toast.makeText(getBaseContext(), "Der er ikke registeret noget", Toast.LENGTH_LONG).show();
                    } else {
                        ArrayInputList.add(getinput);
                        ArrayAdapter<String> inputAdapter = new ArrayAdapter<String>(Punkt2.this, android.R.layout.simple_list_item_1, ArrayInputList);
                        konklusionsview.setAdapter(inputAdapter);
                    }
                }

            }
        });
*/
/*
    }

        private void makecomment(){

            EditText konklussionsskriver = (EditText) findViewById(R.id.Writer2);
            MyApolloClient.getMyapolloClient().mutate(
                    MakecommentMutation.builder()
                            .data(konklussionsskriver.getText().toString()).build()).enqueue(new ApolloCall.Callback<MakecommentMutation.Data>(){

                @Override
                public void onResponse(@Nonnull Response<MakecommentMutation.Data> response) {
                Punkt2.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG,"WORKS???:");
                       //Toast.makeText(Punkt2.this, "Added success", Toast.LENGTH_SHORT).show();
                    }
                });
                }

                @Override
                public void onFailure(@Nonnull ApolloException e) {

                }
            });


    }
}
    //ListView konklusionsview = findViewById(R.id.Konklusion2);
//ArrayList<String> arrayListDatabaseoutput = new ArrayList<>();


    /*private void getPosts (){
        MyApolloClient.getMyapolloClient().query(
                GetallpostsqueriesQuery.builder().build()).enqueue(new ApolloCall.Callback<GetallpostsqueriesQuery.Data>() {
            @Override
            public void onResponse(@Nonnull final Response<GetallpostsqueriesQuery.Data> response) {
               // Log.d(TAG,"OnResponse:" + response.data().getEvents().get(0).title());

                Punkt2.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //konklusionsview.(response.data().getEvents().get(0).title());
                    }
                });
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {

            }
        });
    }*/

