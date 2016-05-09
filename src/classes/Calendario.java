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
    private String[][] calendario = new String[16][5];
    
    public Calendario(){
    }
    public boolean insertDisciplina(Disciplinas disc){   
        int dia;
        int hora;

        for(int i=0;i<disc.horarios.length;i++){
            dia = Integer.parseInt(disc.horarios[i].substring(0, 1))-2;
            hora = Integer.parseInt(disc.horarios[i].substring(1,3))-1;
            System.out.println(dia+","+hora);
            if(calendario[hora][dia] != null)return false;
        }
        for(int i=0;i<disc.horarios.length;i++){
            dia = Integer.parseInt(disc.horarios[i].substring(0, 1))-2;
            hora = Integer.parseInt(disc.horarios[i].substring(1,3))-1;
            calendario[hora][dia] = disc.disciplina+disc.turma;
        }

        return true;
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
}
