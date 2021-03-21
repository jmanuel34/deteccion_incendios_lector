/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import model.Ficha;
import util.Utilidades;

/**
 *
 * @author josemanuelmendez
 */
public class TemperaturasServiceImpl implements TemperaturasService {
    private final String DIRECCION="localhost";
    private final int PUERTO=9000;


    @Override
    public String enviarFicha(Ficha ficha) {

        try(Socket socket=new Socket(DIRECCION,PUERTO);){
            InputStream entrada=socket.getInputStream();
            OutputStream salida=socket.getOutputStream();
            PrintStream ps=new PrintStream(salida);
            //enviamos el pedido al servidor, previa conversión a texto JSON
            ps.println(Utilidades.convertirFichaAJson(ficha));
            BufferedReader bf=new BufferedReader(new InputStreamReader(entrada));
            //devolvemos la respuesta del servidor
            return bf.readLine();
        }
        catch(IOException ex){
            ex.printStackTrace();
            return "";
        }
        
    }
    public String enviarFichas(List<Ficha> fichas) {
        try(Socket socket=new Socket(DIRECCION,PUERTO);){
            InputStream entrada=socket.getInputStream();
            OutputStream salida=socket.getOutputStream();
            PrintStream ps=new PrintStream(salida);
            //enviamos el pedido al servidor, previa conversión a texto JSON
            for (Ficha f:fichas) {
                ps.println(Utilidades.convertirFichaAJson(f));
            }
            BufferedReader bf=new BufferedReader(new InputStreamReader(entrada));
            //devolvemos la respuesta del servidor
            return bf.readLine();
        }
        catch(IOException ex){
            ex.printStackTrace();
            return "";
        }
        
    }

    
}
