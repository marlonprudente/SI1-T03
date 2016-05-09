/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ag;
import classes.Calendario;
/**
 *
 * @author chris
 */
public class Cromossomo {
    private Calendario calendario;
    private String[] genes = new String[5*16];
    
    public Cromossomo(Calendario calendario){
        this.calendario = calendario;
        int alelo = 0;
        for(int dia=0;dia<5;dia++){
            for(int hora=0;hora<16;hora++){
                if(calendario.getDiciplina(dia,hora) != null)genes[alelo] = calendario.getDiciplina(dia,hora);
                else genes[alelo] = "00";
                alelo++;
            }
        }
    }
    public String[] getGenes(){
        return genes;
    }
    public void Mutacao(){
        
    }
    public void showGenes(){
        String StringGenes = "";
        for(int i=0;i<genes.length;i++){
            StringGenes = StringGenes+genes[i]+",";
        }
        System.out.println(StringGenes);
    }
}
