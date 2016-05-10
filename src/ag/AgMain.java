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
    ArrayList<Cromossomo> cromossomosFilhos;
    private int maxRandRoleta = 0;
    private String discObri;
    
    public AgMain(ArrayList<Disciplinas> disciplinas){
        this.disciplinas = disciplinas;
        setCromossomos(50);
        
        setObrigatorias("ABCDEF");
        showCromossomos();
        for(int i=0;i<50;i++){
            System.out.println("Tentativa "+i);
            setRoleta();
            selecaoRoleta();
            crossover();
            selecaoMelhor();
            //System.out.println("Range: "+maxRandRoleta);
            showCromossomos();
        }
        //showCromossomos();
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
            crom = new Cromossomo(calen);
            cromossomos.add(crom);
        }
    }
    public void setRoleta(){
        maxRandRoleta = 0;
        for(int i=0;i<cromossomos.size();i++){
            maxRandRoleta += getFitness(cromossomos.get(i));
        } 
    }
    public int getItemRoleta(int rand){
        int range = 0;
        for(int i=0;i<cromossomos.size();i++){
            range += getFitness(cromossomos.get(i));
            if(rand <= range)return i;
        }
        return -1;
    }
    public void selecaoRoleta(){
        cromossomosFilhos = new ArrayList<Cromossomo>();
        Random rand = new Random();
        for(int i=0;i<cromossomos.size();i++){
              rand = new Random();
              int newCrom = getItemRoleta(rand.nextInt(maxRandRoleta));
              
              cromossomosFilhos.add(new Cromossomo(cromossomos.get(newCrom).getCalendario()));
        }
    }
    public void crossover(){
        int chanceCrossover = 15;
        Random rand = new Random();
        Calendario crom1;
        Calendario crom2;
        Disciplinas id1;
        Disciplinas id2;
        int tent1,tent2,tent3;
        for(int i=0;i<cromossomosFilhos.size();i+=2){
             //Chance de crossover
             if(!equalsGenes(cromossomosFilhos.get(i).genes,cromossomosFilhos.get(i+1).genes)){
             if(rand.nextInt(100) < chanceCrossover){
                 //Pega pares de cromossomo
                 crom1 = cromossomosFilhos.get(i).getCalendario();
                 crom2 = cromossomosFilhos.get(i+1).getCalendario();
                 
                    //Pega materias para crossover
                    tent1 = 0;
                    tent2 = 0;
                    tent3 = 0;
                    do{
                       //Pega materia que nao tem cromossomo 2
                       do{
                       id1 = crom1.disciplinas.get(rand.nextInt(crom1.disciplinas.size()));
                       tent1++;
                       }while(crom2.existsDisciplina(id1.id) && tent1<10);
                       //Pega materia que nao tem cromossomo 1
                       do{
                       id2 = crom2.disciplinas.get(rand.nextInt(crom2.disciplinas.size()));
                       tent2++;
                       }while(crom1.existsDisciplina(id2.id) && tent2<10);
                       tent3++;
                    }while(id1.equals(id2) && tent3<10);
                    //###################
                    //Faz a troca e reconfigura genes;
                    if(tent1<10 && tent2<10 && tent3<10){
                        crom1.removeDisciplina(id1);
                        crom1.insertDisciplina(id2);
                        //cromossomosFilhos.get(i).calendario = crom1;
                        cromossomosFilhos.get(i).setGenes();
                        crom2.removeDisciplina(id2);
                        crom2.insertDisciplina(id1);
                        //cromossomosFilhos.get(i+1).calendario = crom2;
                        cromossomosFilhos.get(i+1).setGenes();
                        //######################
                        //System.out.println(i + " Crossover: "+id1.id+" "+id2.id);
                    }
                 }
             }
             else{
                      System.out.println("teste mutação"+i);
                     cromossomosFilhos.get(i).mutacao(disciplinas);
             }
        }
    }
    public void selecaoMelhor(){
        int fit1,fit2;
        for(int i=0;i<cromossomos.size();i++){
            fit1 = getFitness(cromossomos.get(i));
            fit2 = getFitness(cromossomosFilhos.get(i));
            
            if(fit2>fit1){
                cromossomos.get(i).setCalendario(new Calendario(cromossomosFilhos.get(i).getCalendario()));
                //System.out.println(i+"filho melhor "+fit1+" "+fit2+" "+getFitness(cromossomos.get(i)));
            }
        }       
    }
    public int getFitness(Cromossomo crom){
        String disciplinas = "";
        int discSeguidas = 0;
        int diaUltimaAulaVerificada = 0;
        int janela = 0;
        int Score = 1;
        int error = 0;
        for(int i=0;i<crom.genes.length;i++){
            //Verifica se existe duas disciplinas iguais, mas com turmas diferentes
            if(disciplinas.indexOf(crom.genes[i].substring(0,1)) >= 0){
                
                if(disciplinas.indexOf(crom.genes[i]) == -1){
                    error++;
                    
                    //System.out.println("disicplina repetida:"+crom.genes[i]);
                    disciplinas = disciplinas+crom.genes[i]+",";
                }
            }
            else {
                disciplinas = disciplinas+crom.genes[i]+",";
            }
            //################
            //Contagens de aulas seguidas e janelas
            if(!crom.genes[i].equals("00")){
                //Verifica se existe mais de 5 aulas seguidas
                if(discSeguidas>5){
                    //System.out.println("mais de 5 aulas seguidas "+i);
                    error++;
                }
                //Verifica se existe 12 hora de intervalo entre a ultima aula do dia com a primeira do dia seguinte
                if(diaUltimaAulaVerificada != i/16){
                    //System.out.println("12 horas errado "+i);
                    if(janela<12){
                        //error++;
                    }
                }
                //######
                diaUltimaAulaVerificada = i/16;
                discSeguidas++;
                janela = 0;
            }
            else{
                janela++;
                discSeguidas=0;
            }
            
        }
        int faltantes = crom.getCalendario().obrigatoriasFaltante(discObri);
        int obrigatorias = discObri.length();
        if(crom.getCreditos()>25)error++;
        if(faltantes>0)error++;
        Score+= (obrigatorias-faltantes)*1000;
        Score+= 100*crom.getCreditos();
        if(Score<=0 || error>0)Score = 1;
  
        //if(!crom.calendario.temTodasObrigatorias("ABCDEF"))Score = 1;
        //System.out.println("Creditos: "+creditos);
        return Score;
    }
    public int getCreditos(String id){
        for(int i=0;i<disciplinas.size();i++){
            if(disciplinas.get(i).id.indexOf(id)>=0)return disciplinas.get(i).creditos;
        }
        return 0;
    }
    public boolean equalsGenes(String[] genes1, String[] genes2){
        for(int i=0;i<genes1.length;i++){
            if(!genes1[i].equals(genes2[i]))return false;
        }
        return true;
    }
    public void showCromossomos(){
        for(int i=0;i<cromossomos.size();i++){
              System.out.print(i+"::"+cromossomos.get(i).id+":: ");
              System.out.print(getFitness(cromossomos.get(i))+" ");
              cromossomos.get(i).getCalendario().ShowDisciplinas();
              
        }
    }
    public Cromossomo getMelhorCromossomo(){
        int melhor = 0;
        int fit;
        int id=-1;
        for(int i=0;i<cromossomos.size();i++){
              fit = getFitness(cromossomos.get(i));
              if(fit > melhor){
                  id = i;
                  melhor = fit;
              }
        }
        return cromossomos.get(id);
    }
    public void setObrigatorias(String discObrigatorias){
        String obri = "";
        for(int i=0;i<disciplinas.size();i++){      
            if(discObrigatorias.indexOf(disciplinas.get(i).disciplina.substring(0,1))>=0){
                discObrigatorias = discObrigatorias.replaceAll(disciplinas.get(i).disciplina.substring(0,1), "");
                obri = obri+disciplinas.get(i).disciplina.substring(0,1);
            }
        }
        discObri = obri;
    }
 }
