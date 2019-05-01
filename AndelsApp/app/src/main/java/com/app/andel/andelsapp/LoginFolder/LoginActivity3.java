package com.app.andel.andelsapp.LoginFolder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.app.andel.andelsapp.ActivityFolder.MainPage;
import com.app.andel.andelsapp.ActivityFolder.testactivity;
import com.app.andel.andelsapp.AgendaMappe.AfholdelseAfAgenda1;
import com.app.andel.andelsapp.MainActivity;
import com.app.andel.andelsapp.MyApolloClient;
import com.app.andel.andelsapp.appolloQueries.SignInMutation;

import com.app.andel.andelsapp.R;

import java.io.IOException;

import javax.annotation.Nonnull;

public class LoginActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);
        Button button = findViewById(R.id.signInButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getLoginAccess();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //startActivity(new Intent(LoginActivity3.this, AfholdelseAfAgenda1.class));
                //Intent accessTokenIntent1;
                //accessTokenIntent1 = new Intent(view.getContext(),testactivity.class);
                //accessTokenIntent1.putExtra("aa", accessToken);
            }
        });
    }
    //private String accessToken = "";
    //Intent accessTokenIntent;
   private void getLoginAccess() throws IOException {
       MyApolloClient.getMyapolloClient().mutate(
               SignInMutation.builder().build()).enqueue(new ApolloCall.Callback<SignInMutation.Data>() {
           @Override
           public void onResponse(@Nonnull Response<SignInMutation.Data> response) {
            if(response.data().SignIn().access_token() != null){
                String accessToken = response.data().SignIn().access_token();
                Log.d("hey", accessToken);


            }
            LoginActivity3.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(LoginActivity3.this, MainPage.class));
                }
            });
           }


           @Override
           public void onFailure(@Nonnull ApolloException e) {

           }
       });

       /* MyApolloClient.getMyapolloClient().mutate(
                SignInMutation.builder().build()).enqueue(new ApolloCall.Callback<SignInMutation.Data>() {

            @Override
            public void onResponse(@Nonnull Response<SignInMutation.Data> response) {
                if(response.data().SignIn().access_token() != null){
                    accessToken = response.data().SignIn().access_token();

                }
                LoginActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                     startActivity(new Intent(LoginActivity.this, MainPage.class));
                        //Intent signInIntent = new Intent(vie, MainPage.class);
                        //Bundle Pointbundle = new Bundle();
                        //Pointbundle.putInt("PointKey",OverPunkterAgenda.get(i).getPoint_id());
                        //punktIntent.putExtra("pointkey",Pointbundle);
                        //signInIntent.putExtra("AccessToken", accessToken);
                        //startActivityForResult(signInIntent,0);
                    }
                });
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {

            }
        });
        */
    }
}
