/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicifinal;

import java.util.Vector;

/**
 *
 * @author atenrev
 */
public class Caixer extends Thread 
{
    public Vector<Producto> productos;
    private boolean isRunning = true;
    
    public void run()
    {
        while (isRunning)
        {
            if (productos.isEmpty())
            {
                
            }
            else
            {
                
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
