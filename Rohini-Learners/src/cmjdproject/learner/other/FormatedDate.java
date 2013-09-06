/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.other;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author oshanz
 */
public class FormatedDate {

    public String getDate(String format) {
        //     Calendar instance = Calendar.getInstance();
///"dd-MM-yyyy"


        //   SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return new SimpleDateFormat(format).format(Calendar.getInstance().getTime());


    }

    public String getDate(Date date) {

        return new SimpleDateFormat("dd-MM-yyyy").format(date.getTime());

    }

    public String getDate() {

        return new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());

    }
}
