/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import model.Ficha;
import service.TemperaturasFactory;
import service.TemperaturasService;
import tareas.TareaDetector;

/**
 *
 * @author josemanuelmendez
 */
public class Lector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ScheduledExecutorService executor=Executors.newScheduledThreadPool(3);
       executor.scheduleAtFixedRate(new TareaDetector(),0,30, TimeUnit.SECONDS);
 //      executor.shutdown();
       System.out.println("Proceso completado");

         
 /*
         Usado para comprobar la fecha
         

        TemperaturasService serviceTF = TemperaturasFactory.getTemperaturasFicheroService();
        List<Ficha> fichas = serviceTF.recogerTemperaturas();


        for (Ficha f : fichas) {
            System.out.println("Ficha: " + f.getIdFicha());
            System.out.println("Sensor: " + f.getSensor());
            System.out.println("Tempoeratura " + f.getTemperatura());
            System.out.println("Fecha y Hora: " + f.getFechaHora());
*/

        }
    }
/*
for(int i=1;i<=3;i++){
            executor.scheduleAtFixedRate(new TareaTienda("tienda"+i, vPedidos),0,15,TimeUnit.SECONDS);
 */
