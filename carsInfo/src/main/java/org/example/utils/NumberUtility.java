package org.example.utils;

public class NumberUtility {

    public static double sanitize(String text){return Double.parseDouble(text);}

    public static double sanitizePrice(String text){
        String newText =text;

        newText = text.replaceAll("\"" , "");
        newText = newText.replaceAll("","");
        newText = newText.replaceAll("£","");
        newText = newText.replaceAll(",","");

        return Double.valueOf(newText);
    }

}
