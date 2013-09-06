/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.other;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author oshanz
 */
public class Validation {

    public static boolean validateInt(String txt) {

        String regx = "^[(0-9),;]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        boolean b = matcher.find();
        return b;

    }

    public static String validateInt(String text, char key, int charLimit) {
        if (!Character.isDigit(key)) {
            text = text.replace(key + "", "");
        }
        if (text.length() > charLimit) {
            text = text.substring(0, charLimit);
        }
        return text;
    }

    public static String validateInt(String txt, KeyEvent evt) {

        int code = evt.getKeyCode();

        if (code != KeyEvent.VK_LEFT && code != KeyEvent.VK_RIGHT) {

            char c = evt.getKeyChar();

            boolean b = Character.isDigit(c);

            if (!b) {

                String s = txt.replaceAll(c + "", "");
                txt = s;

            }



        }
        return txt;
    }

    public static boolean validateDouble(String txt) {

        String regx = "^([0-9]){5}+([.])?([0-9]){2}$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();

    }

    public static String validateLetters(String txt, KeyEvent evt) {

        char c = evt.getKeyChar();
        boolean b = false;

        if (Character.isLetter(c) | Character.isSpaceChar(c)) {
            b = true;
        }

        if (evt.getKeyCode() == 110) {
            b = false;
        }
        if (!b) {
            String s = txt.replaceAll(String.valueOf(c), "");
            txt = s;
        }
        return txt;
    }

    public static boolean validatePhone(String phone) {
        return phone.matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}");
        // String phoneNumberPattern = "(\\d-)?(\\d{3}-)?\\d{3}-\\d{4}";



    }

    //  JFormattedTextField tf = new JFormattedTextField(NumberFormat.getIntegerInstance());
    static boolean validateNID(String text) {
        if (text.equals("")) {
            return true;
        } else if (text.length() == 9) {
            final String NIC_PATTERN = "^[0-9]{9}$";
            Pattern pattern = Pattern.compile(NIC_PATTERN, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            return matcher.find();
        } else {
            return false;
        }
    }

    public static String validateAddress(String address, KeyEvent evt) {

        char c = evt.getKeyChar();
        //  boolean b = address.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
        boolean b = false;

        if (Character.isLetter(c) | Character.isSpaceChar(c) | Character.isDigit(c)) {
            b = true;
        }

        if (!b) {
            String s = address.replaceAll(String.valueOf(c), "");
            address = s;
        }
        return address;

    }
}
//   IsPunctuation

