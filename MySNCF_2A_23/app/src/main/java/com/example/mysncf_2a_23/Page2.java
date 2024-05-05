package com.example.mysncf_2a_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class Page2 extends AppCompatActivity implements View.OnClickListener {
    private Button btSuivant2 ;
    private RatingBar rbProprete ;
    private EditText txtComment ;
    private String rer,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        this.btSuivant2 = (Button) findViewById(R.id.idSuivant2);
        this.rbProprete=(RatingBar) findViewById(R.id.idProprete);
        this.txtComment= (EditText) findViewById(R.id.idCommentaire);
        this.btSuivant2.setOnClickListener(this);
        this.rer = this.getIntent().getStringExtra("rer");
        this.email = this.getIntent().getStringExtra("email");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSuivant2)
        {
            String comment = this.txtComment.getText().toString();
            //stocker le commentaire dans le candidat
            SNCF.getUneEnquete(this.rer).getLesCandidats().get(this.email).setComment(comment);
            int nbStars = this.rbProprete.getNumStars() * 3;

            SNCF.getUneEnquete(this.rer).ajouterReponse(this.email, "Proprete",nbStars);


            Intent unIntent = new Intent (this, Fin.class);
            unIntent.putExtra("rer",this.rer);
            unIntent.putExtra("email",this.email);
            this.startActivity(unIntent);
        }
    }
}