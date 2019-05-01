package com.app.andel.andelsapp.AgendaMappe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.app.andel.andelsapp.R;

public class AfholdelseAfAgenda extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afholdelse_af_agenda);
   //Denne Spinner er til Klager

    //skaber forbindelse til spinner dropdown
    Spinner klageSpinner = (Spinner) findViewById(R.id.KlagerSpinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.klagerArray,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        klageSpinner.setAdapter(adapter);
        klageSpinner.setOnItemSelectedListener(this);

        // her Afsluttes Spinneren til  klager


        //Denne Spinner er til Renovering

        //skaber forbindelse til spinner dropdown
        Spinner renoveringSpinner = (Spinner) findViewById(R.id.RenoveringSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.renoveringArray,R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        renoveringSpinner.setAdapter(adapter1);
        renoveringSpinner.setOnItemSelectedListener(this);

        // her afslutter spinneren til Renovering


        //skaber forbindelse til spinner dropdown
        Spinner referatspinner = (Spinner) findViewById(R.id.ReferatSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.refaretArray,R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        referatspinner.setAdapter(adapter2);
        referatspinner.setOnItemSelectedListener(this);

}




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
