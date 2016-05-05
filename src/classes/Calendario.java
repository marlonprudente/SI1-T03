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
    
    
    public void ShowIt(){
        for(int i = 0;i<5;i++){
            for(int j = 0;j<16;j++){
                System.out.println("Dia: " + (i + 2) + " Hora: " + (j + 7) + " -> " + calendario[j][i]);
            }
        }
    }
}
