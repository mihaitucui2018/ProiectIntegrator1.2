package com.example.mihai.proiectintegrator.clase;

/**
 * Created by Mihai on 2/11/2018.
 */

public class GeneratorCodBare {

    public static String codOK(String stringCod) {
        if (stringCod == null || stringCod.isEmpty()) return "NU_EXISTA_STRING";
        int length = stringCod.length();
        if (length > 9) return "STRING_PREA_LUNG";
        for (int i = length; i < 9; i++) {
            stringCod = 7 + stringCod;
        }

        stringCod = 594 + stringCod;

        stringCod = stringCod + obtineCifraControl(stringCod);


        return stringCod;
    }


    private static int obtineCifraControl(String string12Cifre) {
        string12Cifre = 594 + string12Cifre;
        int [] arrayCod = new int[12];

        for(int i=0; i<12; i++)
        {
            arrayCod[i] = Character.getNumericValue(string12Cifre.charAt(i));
        }



        int s1 = 0;
        int s2 = 0;
        for(int i=0; i<12; i=i+2)
        {
            s1 = s1 + arrayCod[i];
            s2 = s2 + arrayCod[i+1];
        }

        s1 = s1 - 3;
        s2 = s2-3;
        int s = s1 + 3*s2;
        int cifraControl = 10 - (s % 10);
        return cifraControl;
    }
}
