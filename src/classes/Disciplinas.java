/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */
public class Disciplinas  {
    private String id;
    private String creditos;
    private String[] horarios; 
    private String disciplina;
    private String turma;      
    
    public Disciplinas(String linha){
       String[] array = linha.split(", ");       
       id = array[0];
       creditos = array[1];
       String[] array2 = array[2].split(",");
       //horarios[0] = array[2];
       horarios = new String[array2.length];
       for(int i = 0 ; i < array2.length;i++){
           horarios[i] = array2[i];
       }

       
    }
    
    public void ShowIt(){
        System.out.println(id);
        System.out.println(creditos);
        System.out.println(horarios[1]);
    }
    
}
