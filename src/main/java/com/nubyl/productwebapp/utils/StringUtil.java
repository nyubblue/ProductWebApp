/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyl.productwebapp.utils;

/**
 *
 * @author buynl
 */
public class StringUtil {
    public String toCommaSeparatedString(Object[]  items){
        StringBuilder sb = new StringBuilder();
        for(Object index : items){
            sb.append(index).append(".");
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
