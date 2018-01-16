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
    
    public Repartidor (Caixer caixer) 
    {
        this.caixer = caixer;
    }
    
    public void run()
    {
        File file = new File("compraCajero.in");
        input = getInputStream(file);
        
        String line;
        String args[];
        Producto producto;
        int cantidad, codigo; float tiempo;
        
        try 
        {
            while ((line = input.readLine()) != null)
            {
                args = line.split(" ");
                cantidad = Integer.parseInt(args[2]);
                codigo = Integer.parseInt(args[1]);
                tiempo = Float.parseFloat(args[3]);
                
                producto = new Producto (cantidad, codigo, tiempo);
                
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
    
    
    
    /** UTILS **/
    private BufferedReader getInputStream (File file)
    {
        try
        {
            return new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException e)
        {
            return null;
        }
    }
}
