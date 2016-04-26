/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */
public class Disciplinas {
    private String id;
    private String disciplina;
    private Integer turma;
    private Integer creditos;
    private Integer[] horarios;    
    
    public Disciplinas(String linha){
       String[] array = linha.split(",");
       id = array[0];
       creditos = parseInt(array[1]);
       for(int i = 2; i< array.length;i++){
           
       }
    }
    
}
