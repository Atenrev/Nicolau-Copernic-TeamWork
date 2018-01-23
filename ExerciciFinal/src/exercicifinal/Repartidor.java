/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicifinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atenrev
 */
public class Repartidor extends Thread 
{
    private BufferedReader input;
    Caixer caixer;
    
    public void run()
    {
        File file = new File(ExerciciFinal.entrada);
        input = ExerciciFinal.getInputStream(file);
        
        String line;
        String args[];
        Producto producto;
        int numCaixer, cantidad, codigo; float tiempo;
        
        try 
        {
            while ((line = input.readLine()) != null)
            {
                args = line.split(" ");
                numCaixer = Integer.parseInt(args[0]);
                cantidad = Integer.parseInt(args[2]);
                codigo = Integer.parseInt(args[1]);
                tiempo = Float.parseFloat(args[3]);
                
                producto = new Producto (cantidad, codigo, tiempo);
                
                caixer = ExerciciFinal.caixers[numCaixer];
                
                synchronized (caixer.productos) 
                {
                    caixer.putProducto(producto);
                    caixer.productos.notify();
                }
                Thread.sleep(100);
            }
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Repartidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(Repartidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
