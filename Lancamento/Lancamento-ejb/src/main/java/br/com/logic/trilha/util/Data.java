/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.logic.trilha.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author douglas
 */
public final class Data {

    public static SimpleDateFormat FORMAT_DATADB = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat FORMAT_DATA = new SimpleDateFormat("dd/MM/yyyy");

    ;
    
    public static Date converterData(String data) throws Exception {
        return FORMAT_DATADB.parse(data);
    }
}
