package com.example.mysncf_2a_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private ImageButton imgRerA, imgRerB, imgRerC, imgRerD, imgRerE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //correspondance entre objets prog et graphiques
        this.imgRerA=(ImageButton)findViewById(R.id.idRerA);
        this.imgRerB=(ImageButton)findViewById(R.id.idRerB);
        this.imgRerC=(ImageButton)findViewById(R.id.idRerC);
        this.imgRerD=(ImageButton)findViewById(R.id.idRerD);
        this.imgRerE=(ImageButton)findViewById(R.id.idRerE);
        //rendre les boutons images cliquables
        this.imgRerA.setOnClickListener(this);
        this.imgRerB.setOnClickListener(this);
        this.imgRerC.setOnClickListener(this);
        this.imgRerD.setOnClickListener(this);
        this.imgRerE.setOnClickListener(this);
        //on initialise les enquetes
        SNCF.initialiser();
    }

    @Override
    public void onClick(View v) {
        String rer ="";
        switch (v.getId())
        {
            case R.id.idRerA: rer="RerA"; break;
            case R.id.idRerB: rer="RerB"; break;
            case R.id.idRerC: rer="RerC"; break;
            case R.id.idRerD: rer="RerD"; break;
            case R.id.idRerE: rer="RerE"; break;
        }
        Intent unIntent = new Intent(this, Inscription.class);
        unIntent.putExtra("rer", rer);
        this.startActivity(unIntent);
    }
}