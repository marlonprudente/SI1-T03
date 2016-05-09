/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ag;

import classes.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author chris
 */
public class AgMain {
    ArrayList<Disciplinas> disciplinas;
    ArrayList<Cromossomo> cromossomos;
    
    public AgMain(ArrayList<Disciplinas> disciplinas){
        this.disciplinas = disciplinas;
        setCromossomos(1);
    }
    public void setCromossomos(int numeroCromossomos){
        cromossomos = new ArrayList<Cromossomo>();
        String discObrigatorias = "A,B,C,D,E,F";
        Disciplinas disc;
        Calendario calen;
        Cromossomo crom;
        Random rand1,rand2;
        for(int cont=0;cont<numeroCromossomos;cont++){
            calen = new Calendario();
            for(int i=0;i<disciplinas.size();i++){
                disc = disciplinas.get(i);
                if(discObrigatorias.indexOf(disc.disciplina) >= 0){
                    calen.insertDisciplina(disc);
                }
                else{
                    rand1 = new Random();
                    rand2 = new Random();
                    if(rand2.nextInt(100) >= rand2.nextInt(100)){
                    calen.insertDisciplina(disc);
                    }
                }
            }
            crom = new Cromossomo(calen);
            cromossomos.add(crom);
            crom.showGenes();
        }
    }
}
