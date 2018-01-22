/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicifinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atenrev
 */
public class Mostrador extends Thread 
{
    private int numero_mostrador;
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private boolean isRunning = true;
    private BufferedReader input; 
    File file = new File("/home/atenrev/productoCajero.out");
    final long tinicio = 2000, tlinea = 10;

    public void run() 
    {
        input = ExerciciFinal.getInputStream(file);
        String line, producto, total_vendido;
        String args[];
        Vector<String> total = new Vector<>();
        
        while (isRunning) 
        {
            try 
            {
                rwl.readLock().lock();
                while ((line = input.readLine()) != null) {
                    args = line.split(" ");
                    producto = args[1];
                    total_vendido = args[2];
                    total.add(numero_mostrador + " " + producto + " " + total_vendido);
                    espera(tlinea);
                }
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Repartidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally 
            {
                rwl.readLock().unlock();
            }
            total.forEach((_item) -> { System.out.println(_item);});
            espera(tinicio);
        }
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
