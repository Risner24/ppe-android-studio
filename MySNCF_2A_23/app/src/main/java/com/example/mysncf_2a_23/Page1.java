package com.example.mysncf_2a_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Page1 extends AppCompatActivity implements View.OnClickListener
{
    private RadioGroup rgService , rgPonctualite ;
    private Button btSuivant1;
    private String rer, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        this.btSuivant1 = (Button) findViewById(R.id.idSuivant1);
        this.rgPonctualite=(RadioGroup) findViewById(R.id.idPonctualite);
        this.rgService = (RadioGroup) findViewById(R.id.idService);
        this.btSuivant1.setOnClickListener(this);
        this.rer = this.getIntent().getStringExtra("rer");
        this.email = this.getIntent().getStringExtra("email");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSuivant1)
        {
            //stocker la reponse RG Service
            int score = 0;
            switch(this.rgService.getCheckedRadioButtonId())
            {
                case R.id.idService1 : score =16 ; break;
                case R.id.idService2 : score =12 ; break;
                case R.id.idService3 : score =8 ; break;
            }
            SNCF.getUneEnquete(this.rer).ajouterReponse(this.email,"Service",score);

            score = 0;
            switch(this.rgPonctualite.getCheckedRadioButtonId())
            {
                case R.id.idPonctualite1 : score =16 ; break;
                case R.id.idPonctualite2: score =12 ; break;
                case R.id.idPonctualite3 : score =8 ; break;
            }
            SNCF.getUneEnquete(this.rer).ajouterReponse(this.email,"Ponctualite",score);

            Intent unIntent = new Intent (this, Page2.class);
            unIntent.putExtra("rer",this.rer);
            unIntent.putExtra("email",this.email);
            this.startActivity(unIntent);
        }
    }
}