/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Tema4AA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        int n,m,k,i;
        ArrayList <Node> graf;
        String sat = "";
        
        BufferedWriter bw;
        
        try(Scanner scan = new Scanner(new File("test.in"))) {
            
            n = scan.nextInt();
            m = scan.nextInt(); 
            k = scan.nextInt();
            
            graf = new ArrayList<>(n);
            for(i = 0;i < n;i++){
                graf.add(new Node(i,k));
            }
            
            for(i = 0;i < m;i++){
                graf.get(scan.nextInt()).add(scan.nextInt());
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tema4AA.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        for(i = 0;i < n;i++){
            if(sat.equals("")){
                sat = sat + graf.get(i).gen_Sat();
            }
            else
                sat = sat + "^" + graf.get(i).gen_Sat();
        }
        
        try {
            
            bw = new BufferedWriter(new FileWriter(new File("test.out")));
            bw.write(sat);
            bw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Tema4AA.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
}
