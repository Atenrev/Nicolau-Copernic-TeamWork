/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicifinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atenrev
 */
public class Mostrador extends Thread 
{
    private int numero_mostrador;
    private boolean isRunning = true;
    private BufferedReader input; 
    File file = new File(ExerciciFinal.salida);
    private long tinicio = 2000, tlinea = 10;
    
    public Mostrador (long tinicio, long tlinea)
    {
        this.tinicio = tinicio;
        this.tlinea = tlinea;
    }

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
                ExerciciFinal.rwl.readLock().lock();
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
                ExerciciFinal.rwl.readLock().unlock();
            }
            total.forEach(System.out::println);
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
