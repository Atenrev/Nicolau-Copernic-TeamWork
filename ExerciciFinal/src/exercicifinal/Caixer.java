/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicifinal;

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
    public Vector<Producto> productos;
    private boolean isRunning = true;
    
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    
    public Caixer (int numeroCajero) 
    {
        this.numeroCajero = numeroCajero;
    }
    
    public void run()
    {
        Producto producto;
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
}
