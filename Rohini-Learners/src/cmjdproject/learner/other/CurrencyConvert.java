/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.other;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author oshanz
 */
public class CurrencyConvert {

    public String convert(double amount) {

        Locale locale = new Locale("si", "LK");

        // Currency instance = Currency.getInstance(locale);
        // String defaultFractionDigits = instance.getCurrencyCode();
        //  System.out.println(defaultFractionDigits);
        // String country = instance.getCurrencyCode();
        // String country1 = instance.getSymbol();
        // System.out.println(country+"  "+country1);


        String prefix = "\u0DBB" + "" + "\u0DD4" + "" + " ";
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        String format = currencyInstance.format(amount);
        String substring = format.substring(4);
        String returnAmount = prefix.concat(substring);
        return returnAmount;
    }
//    public static void main(String[] args) {
//        System.out.println(new CurrencyConvert().convert(4547583461.132547863588));
//    }
}
