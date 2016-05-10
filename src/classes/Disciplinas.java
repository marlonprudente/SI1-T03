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
    public String id;
    public int creditos;
    public String[] horarios; 
    public String disciplina;
    public String turma;      
    
    public Disciplinas(String linha){
       String[] array = linha.split(", ");       
       id = array[0];
       creditos = Integer.parseInt(array[1]);
       String[] array2 = array[2].split(",");
       horarios = new String[array2.length];
       for(int i = 0 ; i < array2.length;i++){
           horarios[i] = array2[i];
       }
       setDisciplina(id);
       setTurma(id);
    }
    public void setDisciplina(String id){
           this.disciplina = id.substring(0,1);
       }
    public void setTurma(String id){
       this.turma = id.substring(1, 2);
    }
    public void ShowIt(){
        setDisciplina(id);
        setTurma(id);
        System.out.println("Disciplina: " + disciplina);
        System.out.println("Turma: " + turma);
        System.out.println("Créditos: " + creditos);
        for (int i = 0; i < horarios.length; i++){
            System.out.println("Horarios: " + horarios[i]);
        }
        
    }
    
}
