/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 18297
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int [][] numb = new int [2][2];
        
        for ( int i = 0; i<2; i++) {
            for(int j = 0; j<2; j++) {
            System.out.println("coloque posicion: " + i + "" + j);
            numb[i][j] = sc.nextInt();
            
            
                    }
        }
        System.out.println(Arrays.deepToString(numb));
    }
    
}
