/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import model.Ficha;

/**
 *
 * @author Antonio
 */
public class Utilidades {

    public static Ficha convertirTextoAFicha(String texto) {
        String[] datos = texto.split(",");
 
        Ficha ficha = new Ficha();
 //*       
        ficha.setIdFicha(Integer.parseInt(datos[0]));
        ficha.setSensor(Integer.parseInt(datos[1]));
        ficha.setTemperatura(Double.parseDouble(datos[2]));

        ficha.setFechaHora(LocalDateTime.parse(datos[3], DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss")));
        return ficha;
//*/
 //       return new Ficha(0, Integer.parseInt(datos[1]), Double.parseDouble(datos[2]), LocalDateTime.parse(datos[3], DateTimeFormatter.ofPattern("dd/MM/yyyy-hh:mm:ss")));
//            return new Ficha(Integer.parseInt("0"), Integer.parseInt(datos[1]));

    }
    

    public static String convertirFichadATexto(Ficha ficha) {
        return ficha.getSensor() + "," + ficha.getTemperatura() + "," + ficha.getFechaHora();
    }

    public static LocalDate convertirDateALocalDate(java.util.Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

   public static String convertirFichaAJson(Ficha ficha) {
        Gson gson = new Gson()
                .newBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTimeSerializer())
                .create();

        return gson.toJson(ficha);

    }

}
