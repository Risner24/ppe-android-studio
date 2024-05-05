package com.example.mysncf_2a_23;

import java.util.HashMap;

public class Enquete {
    private HashMap<String, Candidat> lesCandidats ;
    public Enquete()
    {
        this.lesCandidats = new HashMap<>();
    }
    public void ajouterCandidat(Candidat unCandidat)
    {
        this.lesCandidats.put (unCandidat.getEmail(), unCandidat);
    }
    public float getMoyenne (String email)
    {
        return this.lesCandidats.get(email).moyenne();
    }
    public void ajouterReponse (String email, String question, int score)
    {
        this.lesCandidats.get(email).ajouterReponse(question, score);
    }

    public HashMap<String, Candidat> getLesCandidats() {
        return lesCandidats;
    }

    public void setLesCandidats(HashMap<String, Candidat> lesCandidats) {
        this.lesCandidats = lesCandidats;
    }
}
