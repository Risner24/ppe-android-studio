package com.example.mysncf_2a_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Inscription extends AppCompatActivity implements View.OnClickListener
{
    private EditText txtNom, txtPrenom, txtEmail;
    private Button btParticiper ;
    private Spinner spAge, spFrequence ;
    private String rer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.btParticiper=(Button) findViewById(R.id.idParticiper);
        this.txtEmail =(EditText) findViewById(R.id.idEmail);
        this.txtNom = (EditText) findViewById(R.id.idNom);
        this.txtPrenom = (EditText) findViewById(R.id.idPrenom);
        this.spAge =(Spinner) findViewById(R.id.idAge);
        this.spFrequence =(Spinner) findViewById(R.id.idFrequence);

        this.btParticiper.setOnClickListener(this);
        //remplir les spinners
        ArrayList<String> lesAges = new ArrayList<String>();
        lesAges.add("0 - 18 ans");
        lesAges.add("19 - 35 ans");
        lesAges.add("36 - 60 ans");
        lesAges.add("61 - 100 ans");
        //adaptateur d'affichage
        ArrayAdapter unAdapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_item,
                lesAges );
        this.spAge.setAdapter(unAdapter);
        ArrayList<String> lesFrequences = new ArrayList<String>();
        lesFrequences.add("Quotidienne");
        lesFrequences.add("Hebdomadaire");
        lesFrequences.add("Mensuelle");
        lesFrequences.add("Annuelle");
        //adaptateur d'affichage
        ArrayAdapter unAdapter2 = new ArrayAdapter(
                this, android.R.layout.simple_spinner_item,
                lesFrequences );
        this.spFrequence.setAdapter(unAdapter2);
        //récupérer la variable rer de la page MainActivity
        this.rer = this.getIntent().getStringExtra("rer");
    }

    @Override
    public void onClick(View v) {
    if (v.getId() == R.id.idParticiper)
    {
        //instanciation de la classe Candidat
        String nom = this.txtNom.getText().toString();
        String prenom = this.txtPrenom.getText().toString();
        String email = this.txtEmail.getText().toString();
        String trancheAge = this.spAge.getSelectedItem().toString();
        String frequence = this.spFrequence.getSelectedItem().toString();

        Candidat unCandidat = new Candidat(nom, prenom, email, trancheAge,frequence);
        SNCF.getUneEnquete(this.rer).ajouterCandidat(unCandidat);
        Toast.makeText(this, "Bienvenue M./MM" + nom,
                Toast.LENGTH_LONG).show();

        Intent unIntent = new Intent (this, Page1.class);
        unIntent.putExtra("rer",this.rer);
        unIntent.putExtra("email",email);
        this.startActivity(unIntent);
    }
    }
}