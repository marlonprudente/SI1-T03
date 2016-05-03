package principal;

import classes.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
        FileInputStream stream = new FileInputStream("tar03-tst1.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String linha;
       ArrayList<String> disciplinas = new ArrayList<String>();
       linha = reader.readLine();
       Disciplinas disc = new Disciplinas(linha);
       Calendario calend = new Calendario();
       calend.ShouIt();
       //disc.ShowIt();    
       
       
       
       
    }    
}
