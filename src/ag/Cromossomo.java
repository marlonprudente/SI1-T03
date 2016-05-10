/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ag;
import classes.Calendario;
import classes.Disciplinas;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author chris
 */
public class Cromossomo {
    public int id;
    private Calendario calendario;
    public String[] genes = new String[5*16];
    
    public Cromossomo(Calendario calendario){
        Random rand = new Random();
        this.calendario = calendario;
        this.id = rand.nextInt(100000);
        setGenes();
    }
    public void setGenes(){
        int alelo = 0;
        for(int dia=0;dia<5;dia++){
            for(int hora=0;hora<16;hora++){
                if(calendario.getDiciplina(dia,hora) != null)genes[alelo] = calendario.getDiciplina(dia,hora);
                else genes[alelo] = "00";
                alelo++;
            }
        }
    }
    public void mutacao(ArrayList<Disciplinas> disciplinas){
        Random rand = new Random();
        int tent = 0;
        if(rand.nextInt(1000) < 5){
            Disciplinas disc1 = calendario.disciplinas.get(rand.nextInt(calendario.disciplinas.size()));
            calendario.removeDisciplina(disc1);
            
            Disciplinas disc2;     
            do{
                do{disc2 = disciplinas.get(rand.nextInt(disciplinas.size()));}while(disc2.id.equals(disc1.id));
                tent++;
            }while(!calendario.insertDisciplina(disc2) && tent<20);
            
            if(tent>=20)System.out.println("Mutação sem inserçao");
            else System.out.println("Mutação: "+disc1.id+" "+disc2.id);
            setGenes();
        }
    }
    public int getCreditos(){
        return calendario.creditos;
    }
    public void showGenes(){
        String StringGenes = "";
        for(int i=0;i<genes.length;i++){
            StringGenes = StringGenes+genes[i]+",";
        }
        System.out.println(StringGenes);
    }
    public void setCalendario(Calendario calen){
        calendario = calen;
        setGenes();
    }
    public Calendario getCalendario(){
        return calendario;
    }
}
