/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicifinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atenrev
 */
public class ExerciciFinal 
{
    static Caixer caixers[];
    static Mostrador mostradors[];
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public static String entrada,
            salida;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int numCaixers, numMostradors; 
        try
        {
            File principal = new File("principal");
            BufferedReader br = getInputStream (principal);
            
            entrada = br.readLine();
            salida = br.readLine();
            numCaixers = Integer.parseInt(br.readLine());
            numMostradors = Integer.parseInt(br.readLine());
            
            File in = new File(salida);
            BufferedWriter bw = getOutputStream(in);
            bw.write("");
            bw.close();
            
            caixers = new Caixer[numCaixers];
            for (int x = 0; x < numCaixers; x++)
                caixers[x] = new Caixer(x);
            
            mostradors = new Mostrador[numMostradors];
            for (int x = 0; x < numMostradors; x++)
            {
                String ops[] = br.readLine().split(" ");
                mostradors[x] = new Mostrador (Long.parseLong(ops[0]), Long.parseLong(ops[1]));
            }
            
            Repartidor repartidor = new Repartidor();
            
            repartidor.start();
            for (Caixer caixer : caixers)
                caixer.start();
            for (Mostrador mostrador : mostradors)
                mostrador.start();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
    /** UTILS **/
    public static BufferedReader getInputStream (File file)
    {
        try
        {
            return new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
            return null;
        }
    }
    public static BufferedWriter getOutputStream (File file)
    {
        try
        {
            return new BufferedWriter(new FileWriter(file,true));
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }   
}
