package com.nubyl.productwebapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author buynl
 */
public class Formatter {
    public static String pattern = "yyyy-MM-dd";
    public String formatDateNow(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return  simpleDateFormat.format(new Date());
    }
}
