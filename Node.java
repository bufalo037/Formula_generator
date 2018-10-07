
import java.util.HashSet;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class Node {
    
    
    private final HashSet<Integer> vecini;
    private final int nr_nod, k;

    public Node(int nr_nod, int k) {
        this.vecini = new HashSet<>();
        this.k = k;
        this.nr_nod = nr_nod;
    }

    boolean add(Integer x){
        return vecini.add(x);
    }
    
    String gen_Sat(){
        
        int x,i,j;
        String sat = "";
        String temp = "";
        Iterator<Integer> iterator = vecini.iterator();
        
        //O(k)
        // are cel putin o culoare nodul
        for(i = 0; i < k;i++){
            if(!"".equals(sat))
                sat = sat + "Vx" + (nr_nod * k + i);  
            else
                sat = sat + "(x" + (nr_nod * k + i);
        }
        sat = sat + ")";
        //O(n * k)
        //vecinii nu au aceasi culoare cu nodul
        while(iterator.hasNext()){
            x = iterator.next();
            for(i = 0;i < k;i++){
                    sat = sat + "^~(x" + (nr_nod * k + i) + "^x" + (x * k + i) + ")";
            }
        }
        //O(k^2)
        // are cel mult o culoare nodul
        for(i = 0;i < k-1; i++){
            for(j = i + 1;j < k;j++)
                sat = sat + "^~(x" + (nr_nod * k + i) + "^x" +(nr_nod * k + j) + ")";                            
        }        
        
        
        return sat;
    }
        
}
