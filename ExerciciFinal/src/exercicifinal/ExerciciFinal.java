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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atenrev
 */
public class ExerciciFinal 
{
    static Caixer caixers[] = {
        new Caixer(0),
        new Caixer(1)
    };
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try
        {
            File file = new File("/home/atenrev/productoCajero.out");
            BufferedWriter bw=new BufferedWriter(new FileWriter(file));
            bw.write("");
            bw.close();
        }
        catch(Exception e)
        {
            
        }
        
        Repartidor H1 = new Repartidor(); 
        Mostrador M1 = new Mostrador();
        Mostrador M2 = new Mostrador();
        
        H1.start();
        caixers[0].start();
        caixers[1].start();
        M1.start();
        M2.start();
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
            return new BufferedWriter(new FileWriter(file));
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
