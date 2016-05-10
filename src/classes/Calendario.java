/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */
public class Calendario {
    public String[][] calendario = new String[16][5];
    public int creditos = 0;
    public ArrayList<Disciplinas> disciplinas = new ArrayList<Disciplinas>();
    public Calendario(){
    }
    public Calendario(Calendario calen){
        this.calendario = calen.calendario;
        this.creditos = calen.creditos;
        this.disciplinas = calen.disciplinas;  
    }
    public boolean insertDisciplina(Disciplinas disc){   
        int dia;
        int hora;

        for(int i=0;i<disc.horarios.length;i++){
            dia = Integer.parseInt(disc.horarios[i].substring(0, 1))-2;
            hora = Integer.parseInt(disc.horarios[i].substring(1,3))-1;
            if(calendario[hora][dia] != null){
                return false;
            }
        }
        for(int i=0;i<disc.horarios.length;i++){
            dia = Integer.parseInt(disc.horarios[i].substring(0, 1))-2;
            hora = Integer.parseInt(disc.horarios[i].substring(1,3))-1;
            calendario[hora][dia] = disc.disciplina+disc.turma;
        }
        creditos += disc.creditos;
        this.disciplinas.add(disc);
        return true;
    }
    public void removeDisciplina(Disciplinas disc){
        for(int i=0;i<disciplinas.size();i++){
            if(disciplinas.get(i).id.equals(disc.id)){
               disciplinas.remove(i);
               break;
            }
        }
        for(int i = 0;i<5;i++){
            for(int j = 0;j<16;j++){
                if(calendario[j][i] != null){
                   if(calendario[j][i].equals(disc.id))calendario[j][i] = null; 
                }
            }
        }
        creditos-=disc.creditos;
    }
    public String getDiciplina(int dia,int hora){
        return calendario[hora][dia];
    }
    public void ShowIt(){
        for(int i = 0;i<5;i++){
            for(int j = 0;j<16;j++){
                System.out.println("Dia: " + (i + 2) + " Hora: " + (j + 7) + " -> " + calendario[j][i]);
            }
        }
    }
    public void ShowDisciplinas(){
        String showDisc = "";
        for(int i=0;i<disciplinas.size();i++){
            showDisc += disciplinas.get(i).id+",";
        }
        System.out.println(showDisc);
    }
    public boolean existsDisciplina(String id){
        for(int i=0;i<disciplinas.size();i++){
            if(id.equals(disciplinas.get(i).id)){
                return true;
            }
        }
        return false;
    }
    public int obrigatoriasFaltante(String discObrigatorias){
        for(int i=0;i<disciplinas.size();i++){      
            if(discObrigatorias.indexOf(disciplinas.get(i).disciplina.substring(0,1))>=0){
                discObrigatorias = discObrigatorias.replaceAll(disciplinas.get(i).disciplina.substring(0,1), "");
            }
        }
        return discObrigatorias.length();
    }
}
