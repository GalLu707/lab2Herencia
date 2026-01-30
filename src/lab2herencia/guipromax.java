/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;

import java.awt.Font;
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

 class ventasGUI {
    
    private static ClaseBaseEmpleado empleado;
    private static ArrayList<ClaseBaseEmpleado> lista;
    
    public ventasGUI(ClaseBaseEmpleado empleado, ArrayList<ClaseBaseEmpleado> lista){
        this.lista=lista;
        this.empleado= empleado;
        JFrame screen = new JFrame();
        screen.setSize(800, 600);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        
        
        JLabel titulo = new JLabel("Agregar Horas Trabajadas");
        titulo.setBounds(150, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 50));
        
        
        JLabel horasActualesLabel= new JLabel("Horas Actuales del Empleado: ");
        horasActualesLabel.setBounds(150, 180, 300, 25);
        
        JTextField actualHrstxt = new JTextField();
        actualHrstxt.setBounds(150, 200, 200, 25);
        actualHrstxt.setEnabled(false);
        if(empleado!=null){
            actualHrstxt.setText(String.valueOf(empleado.horasTrabajadas));
        }
        
        
        
        JLabel newHoursLabel= new JLabel("Ingrese horas a sumar: ");
        newHoursLabel.setBounds(150, 280, 300, 25);
        
        JTextField newHourstxt = new JTextField();
        newHourstxt.setBounds(150, 300, 200, 25);
        
        
        
        //Botones de acciones
        JButton btAddHoras = new JButton("Agregar Horas");
        btAddHoras.setBounds(500, 180, 200, 50);
        
        btAddHoras.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              int horas = Integer.valueOf(newHourstxt.getText());
              if(horas!=0 && horas>0){
                empleado.registrarHoras(horas);
                JOptionPane.showMessageDialog(screen, "Horas Agregadas Exitosamente");  
              }else{
                  JOptionPane.showMessageDialog(screen, "AVISO: Porfavor introducir valores validos");
              }
              
          }
                    
        });
        
        
        JButton btRegresar = new JButton("Regresar");
        btRegresar.setBounds(500, 280, 200, 50);
        
        btRegresar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
              ventanaBuscarEmp ventana = new ventanaBuscarEmp(lista);
          }
                    
        });
        
        
        
        screen.add(btRegresar);
        screen.add(btAddHoras);
        screen.add(newHoursLabel);
        screen.add(newHourstxt);
        screen.add(actualHrstxt);
        screen.add(horasActualesLabel);
        screen.add(titulo);
        screen.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        subVentHorasTrabajadas ventana = new subVentHorasTrabajadas(empleado, lista);
    }
    
    
}