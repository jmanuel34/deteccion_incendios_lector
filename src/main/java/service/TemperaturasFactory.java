/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Antonio
 */
public class TemperaturasFactory {
/*    
    public static TemperaturasService getTempleraturasService(){
        return new TempleraturasServiceImpl();
    }
*/
    public static TemperaturasFicheroService getTemperaturasFicheroService(){
        return new TemperaturasFicheroServiceImpl();
    }
    
    public static TemperaturasService getTemperaturasService(){
        return new TemperaturasServiceImpl();
    }
}
