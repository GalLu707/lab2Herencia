/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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

       pantalla.setTitle("parte visual");
       JLabel label = new JLabel("");
       
        JLabel MesLabel= new JLabel("Ingrese el Mes en donde desea registrar la venta (1-12): ");
        MesLabel.setBounds(120, 180, 500, 25);
        
        JTextField Mestxt = new JTextField();
        Mestxt.setBounds(150, 200, 200, 25);
        
        JLabel VentasLabel= new JLabel("Ingrese la cantidad de ventas a registrar: ");
        VentasLabel.setBounds(150, 280, 300, 25);
        
        JTextField Ventastxt = new JTextField();
        Ventastxt.setBounds(150, 300, 200, 25);
        
        
        
        //Botones de acciones
        JButton bntRegistrar = new JButton("Registrar Ventas");
        bntRegistrar.setBounds(500, 180, 200, 50);
        
        bntRegistrar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
             try{
                 if(empleado!=null){
                    EmpleadoVentas temp = (EmpleadoVentas) empleado;
                    double amount = Double.valueOf(Ventastxt.getText());
                    int mes = Integer.valueOf(Mestxt.getText());
                    temp.IngresarVentas(amount, mes);
                }
             }catch(NullPointerException k){
                 JOptionPane.showMessageDialog(pantalla, "Aviso: Porfavor introducir valores validos");
             }
            
          }
                    
        });
        
        
        JButton btRegresar = new JButton("Regresar");
        btRegresar.setBounds(500, 280, 200, 50);
        
        btRegresar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              pantalla.dispose();
              ventanaBuscarEmp ventana = new ventanaBuscarEmp(list);
          }
                    
        });
        
        
        
        pantalla.add(btRegresar);
        pantalla.add(bntRegistrar);
        pantalla.add(VentasLabel);
        pantalla.add(Ventastxt);
        pantalla.add(Mestxt);
        pantalla.add(MesLabel);
        pantalla.setVisible(true);
    }
    
    }
 ////////yo trabaje lo de arribaa 
    
    
    
    

