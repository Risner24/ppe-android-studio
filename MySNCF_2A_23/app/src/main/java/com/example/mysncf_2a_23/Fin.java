package com.example.mysncf_2a_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Fin extends AppCompatActivity implements View.OnClickListener {
    private Button btRetour;
    private TextView txtMoyenne;
    private ImageView imgSmiley ;
    private ListView lvListe ;
    private String rer, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        this.btRetour=(Button) findViewById(R.id.idRetour);
        this.txtMoyenne=(TextView) findViewById(R.id.idMoyenne);
        this.lvListe = (ListView) findViewById(R.id.idListe);
        this.imgSmiley = (ImageView) findViewById(R.id.idSmiley);
        this.btRetour.setOnClickListener(this);
        this.rer = this.getIntent().getStringExtra("rer");
        this.email = this.getIntent().getStringExtra("email");

        //affichage de la moyenne :
        float moy = SNCF.getUneEnquete(this.rer).getMoyenne(this.email);
        this.txtMoyenne.setText("Votre moyenne est de :"+ moy);

        //actualisation du smiley par rapport à la moyenne
        if (moy > 14){
            this.imgSmiley.setImageResource(R.drawable.smiley_1);
        } else if (moy > 12)
        {
            this.imgSmiley.setImageResource(R.drawable.smiley_2);
        }else {
            this.imgSmiley.setImageResource(R.drawable.smiley_3);
        }
        //Actualisation des liste des candidats

        ArrayList<String> lesParticipants = new ArrayList<>();
        for (Candidat unCandidat : SNCF.getUneEnquete(this.rer).getLesCandidats().values()) {
            lesParticipants.add(unCandidat.getNom()+ "  " +
                    unCandidat.getPrenom() + "  " +
                    unCandidat.getEmail() +"  " +
                    unCandidat.moyenne());
        }
        ArrayAdapter unAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, lesParticipants);
        this.lvListe.setAdapter(unAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idRetour)
        {
            Intent unIntent = new Intent (this, MainActivity.class);
             this.startActivity(unIntent);
        }
    }
}