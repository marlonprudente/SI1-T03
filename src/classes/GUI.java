/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author chris
 */
public class GUI extends JPanel{
    private JLabel conteudo;
    private JFrame janela;
    public GUI(){
       janela = new JFrame("Arquitetura");
       janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       janela.setSize(600,600);
       janela.add(this);
       janela.setVisible(true);
       createGUI();
    }
    public void createGUI(){
        this.conteudo = new JLabel("<html>");
        JPanel PanelPrincipal = new JPanel() {
            public Dimension getPreferredSize() {
                return new Dimension(500, 500);
            }
        };
        PanelPrincipal.add(conteudo);
        conteudo.setText("<html><table><tr><td>zxvxzv</td><td>zxvzxvzxv</td></tr>");
        //PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal, BoxLayout.PAGE_AXIS));
        
        add(PanelPrincipal);
    }
}
