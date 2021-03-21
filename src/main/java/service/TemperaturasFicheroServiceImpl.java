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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import model.Ficha;
import util.Utilidades;

/**
 *
 * @author josemanuelmendez
 */
public class TemperaturasFicheroServiceImpl implements TemperaturasFicheroService{

    String ruta = "/Users/josemanuelmendez/Documents/temp/temperaturas.txt";
    Path path;
  
    public TemperaturasFicheroServiceImpl() {
        path = Paths.get(ruta);
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }


    @Override
    public List<Ficha> recogerTemperaturas() {
         try {
            return Files.lines(path)
                    .map(s -> Utilidades.convertirTextoAFicha(s))
                    .collect(Collectors.toList());

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    }
