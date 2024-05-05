package com.example.mysncf_2a_23;

import java.util.HashMap;

public class Candidat
{
    private String nom, prenom, email, trancheAge,frequence, comment;
    private HashMap<String, Integer> lesReponses ;

    public Candidat(String nom, String prenom, String email, String trancheAge, String frequence) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.trancheAge = trancheAge;
        this.frequence = frequence;
        this.comment="";
        this.lesReponses = new HashMap<String, Integer>();
    }
    public void ajouterReponse (String question, int score)
    {
        this.lesReponses.put(question, score);
    }
    public float moyenne ()
    {
        float moy = 0;
        for (Integer score : this.lesReponses.values())
        {
            moy = moy + score ;
        }
        moy = moy / this.lesReponses.size();
        return moy;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrancheAge() {
        return trancheAge;
    }

    public void setTrancheAge(String trancheAge) {
        this.trancheAge = trancheAge;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;
    }
}










