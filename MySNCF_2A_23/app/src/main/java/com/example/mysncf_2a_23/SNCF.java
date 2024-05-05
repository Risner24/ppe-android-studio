package com.example.mysncf_2a_23;

import java.util.HashMap;

public class SNCF {
    private static HashMap<String, Enquete> lesEnquetes = new HashMap<>();

    public static Enquete getUneEnquete (String rer)
    {
        return lesEnquetes.get(rer);
    }
    public static HashMap<String, Enquete> getLesEnquetes() {
        return lesEnquetes;
    }

    public static void setLesEnquetes(HashMap<String, Enquete> lesEnquetes) {
        SNCF.lesEnquetes = lesEnquetes;
    }

    public static void initialiser ()
    {
        if( ! lesEnquetes.containsKey("RerA"))
        {
            lesEnquetes.put("RerA", new Enquete());
        }
        if( ! lesEnquetes.containsKey("RerB"))
        {
            lesEnquetes.put("RerB", new Enquete());
        }
        if( ! lesEnquetes.containsKey("RerC"))
        {
            lesEnquetes.put("RerC", new Enquete());
        }
        if( ! lesEnquetes.containsKey("RerD"))
        {
            lesEnquetes.put("RerD", new Enquete());
        }
        if( ! lesEnquetes.containsKey("RerE"))
        {
            lesEnquetes.put("RerE", new Enquete());
        }

    }


}
