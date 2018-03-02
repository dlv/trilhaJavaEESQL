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

    public static Date converterStringToDate(String data) throws Exception {
        return FORMAT_DATADB.parse(data);
    }

    public static Date converterIntegerToDate(Integer dia, Integer mes, Integer ano) throws Exception {
        String dataFormatada = String.valueOf(ano.intValue()) + "-" + String.valueOf(mes.intValue()) + "-" + String.valueOf(dia.intValue());

        return converterStringToDate(dataFormatada);
    }
}
