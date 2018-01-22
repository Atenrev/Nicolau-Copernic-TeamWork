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

/**
 *
 * @author atenrev
 */
public class ExerciciFinal 
{
    static Caixer caixers[] = {
        new Caixer(1),
        new Caixer(2)
    };
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
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
            return null;
        }
    }    
}
