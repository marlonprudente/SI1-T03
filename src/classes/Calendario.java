/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */
public class Calendario {
    private Integer[][] calendario = new Integer[16][5];
    
    public Calendario(){
        
    }
    
    
    public void ShouIt(){
        for(int i = 0;i<5;i++){
            for(int j = 0;j<16;j++){
                System.out.println("Hora: " + (j + 7) + " Dia: " + (i + 2) + " -> " + calendario[j][i]);
            }
        }
    }
}
