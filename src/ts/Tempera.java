/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

import classes.Calendario;
import classes.Disciplinas;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */
public class Tempera {

    private final ArrayList<Disciplinas> disciplinas;
    private Calendario calen;
    
    public Tempera(ArrayList<Disciplinas> disciplinas){
        this.disciplinas = disciplinas;
        setTempera();
    }
    
    public void setTempera(){
        String discObrigatorias = "A,B,C,D,E,F";
                Disciplinas disc;
                Random rand1, rand2;
        calen = new Calendario();
            for(int i=0;i<disciplinas.size();i++){
                disc = disciplinas.get(i);
                //Insere disciplinas obrigatórias
                if(discObrigatorias.indexOf(disc.disciplina) >= 0){                    
                    calen.insertDisciplina(disc);
                }
                else{
                    //Insere disciplinas não obrigatórias bem aleatoriamente
                    rand1 = new Random();
                    rand2 = new Random();
                    if(rand2.nextInt(100) >= rand2.nextInt(100)){
                    calen.insertDisciplina(disc);
                    }
                }
            }
    }
    
    
    
    public void showCalend(){
        calen.ShowDisciplinas();
        calen.ShowIt();
    }
}
