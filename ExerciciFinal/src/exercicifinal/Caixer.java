/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicifinal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atenrev
 */
public class Caixer extends Thread 
{
    private int numeroCajero;
    public Vector<Producto> productos = new Vector<>();
    private boolean isRunning = true;
    
    private BufferedWriter output;
    
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    
    public Caixer (int numeroCajero) 
    {
        this.numeroCajero = numeroCajero;
    }
    
    public void run()
    {
        Producto producto = null;
        File file = new File("/home/atenrev/productoCajero.out");
        
        while (isRunning)
        {
            synchronized (productos) 
            {
                if (productos.isEmpty())
                {
                    try {
                        productos.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Caixer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    producto = productos.get(0);
                    productos.remove(producto);
                    rwl.writeLock().lock();
                    output = ExerciciFinal.getOutputStream(file);
                    try 
                    {
                        output.append(numeroCajero+" "+producto.toString()+"\n");
                        output.close();
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(Caixer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    finally
                    {
                        rwl.writeLock().unlock();
                        espera((long) producto.getTiempo());
                    }
                }
            }
        }        
    }
    
    public void putProducto (Producto producto)
    {
        productos.add(producto);
    }
    public void setIsRunning (boolean is)
    {
        isRunning = is;
    }
    private void espera(long time)
    {
        try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mostrador.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
