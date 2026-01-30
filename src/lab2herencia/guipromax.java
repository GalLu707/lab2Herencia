/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class guipromax {
    // gui todavia no funcional
    private static ClaseBaseEmpleado empleado;
    private static ArrayList<ClaseBaseEmpleado> list;
    
    
    
    
    
    public guipromax(ArrayList<ClaseBaseEmpleado> lista){
       list= lista;
       JFrame pantalla = new JFrame();
       pantalla.setSize(500,500);
       pantalla.setResizable(false);
       pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       pantalla.setLocationRelativeTo(null);
       pantalla.setLayout(new GridLayout(0, 1, 1, 0));

       JLabel label = new JLabel("");
       
       
    }
 
    
    
    
    
}
