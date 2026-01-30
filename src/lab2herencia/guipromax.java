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
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
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
              BuscarEmpGUI ventana = new BuscarEmpGUI(list);
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
    
<<<<<<< HEAD

=======
>>>>>>> 50c7419f86ae08d6fcaa7742fcb5f1a797adb23d
    }
 ////////yo trabaje lo de arribaa 
    

class FechaGUI{
    private static ClaseBaseEmpleado empleado;
    private static ArrayList<ClaseBaseEmpleado> lista;
    
    public FechaGUI(ClaseBaseEmpleado empleado, ArrayList<ClaseBaseEmpleado> lista){
        
        this.lista=lista;
        this.empleado= empleado;
        JFrame screen = new JFrame();
        screen.setSize(800, 600);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        
        
        JLabel titulo = new JLabel("Actualizar Fecha de Fin de Contrato");
        titulo.setBounds(150, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 40));
        
        
        JLabel NewFechaLabel= new JLabel("Ingrese la Nueva Fecha Final de Contrato Formato(yyyy/MM/dd): ");
        NewFechaLabel.setBounds(150, 180, 300, 25);
        
        JTextField NewFechatxt = new JTextField();
        NewFechatxt.setBounds(150, 200, 200, 25);
        NewFechatxt.setEnabled(false);
       
        
        
        
        JLabel newHoursLabel= new JLabel("Ingrese horas a sumar: ");
        newHoursLabel.setBounds(150, 280, 300, 25);
        
        JTextField newHourstxt = new JTextField();
        newHourstxt.setBounds(150, 300, 200, 25);
        
        
        
        //Botones de acciones
        JButton btAddHoras = new JButton("Actualizar Fecha");
        btAddHoras.setBounds(500, 180, 200, 50);
        
        
        btAddHoras.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
            if(empleado!=null){
                if(NewFechatxt.getText()!=null){
                    EmpleadoTemporal temp =(EmpleadoTemporal) empleado;
                    String fecha = NewFechatxt.getText();
                    Calendar fechaContratacion = temp.fechaContratacion;
                    JOptionPane.showMessageDialog(screen, "Fecha actualizada correctamente");
                }else{
                    JOptionPane.showMessageDialog(screen, "Aviso: No deje casillas en blanco");
                }
                
            }
            
          }
                    
        });
        
        
        JButton btRegresar = new JButton("Regresar");
        btRegresar.setBounds(500, 280, 200, 50);
        
        btRegresar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
              BuscarEmpGUI ventana = new BuscarEmpGUI(lista);
          }
                    
        });
        
        
        
        screen.add(btRegresar);
        screen.add(btAddHoras);
        screen.add(newHoursLabel);
        screen.add(newHourstxt);
        screen.add(NewFechatxt);
        screen.add(NewFechaLabel);
        screen.add(titulo);
        screen.setVisible(true);
    }
<<<<<<< HEAD
    }
    
    
    
    

=======
}
    
    
>>>>>>> 50c7419f86ae08d6fcaa7742fcb5f1a797adb23d

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
            actualHrstxt.setText(String.valueOf(empleado.HorasTrabajadas));
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
                empleado.registrarhoras(horas);
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
              BuscarEmpGUI ventana = new BuscarEmpGUI(lista);
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
    
    
<<<<<<< HEAD
}

=======
    public static void main(String[] args) {
        subVentHorasTrabajadas ventana = new subVentHorasTrabajadas(empleado, lista);
    }
    
    
}

class GenerarRepor extends JFrame {

    private final JTextArea txtReporte;
    private final ArrayList<ClaseBaseEmpleado> dataEmpleados;

    public GenerarRepor(ArrayList<ClaseBaseEmpleado> lista) {
        // inizializar las variables
        this.dataEmpleados = (lista != null) ? lista : new ArrayList<>();
        
        // Configuracion de la ventana
        this.setTitle("Visor de Reportes");
        this.setSize(800, 600);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // --- Componentes Visuales ---
        
        // Etiqueta de encabezado
        JLabel lblTitulo = new JLabel("Lista de Reportes Empleados", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Monospaced", Font.BOLD, 28));
        lblTitulo.setBounds(0, 20, 800, 50);
        this.add(lblTitulo);

        // area de texto
        txtReporte = new JTextArea();
        txtReporte.setEditable(false);
        txtReporte.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        JScrollPane panelScroll = new JScrollPane(txtReporte);
        panelScroll.setBounds(50, 80, 700, 350);
        this.add(panelScroll);

        // accion de botones
        JButton btnCargar = new JButton("Generar Listado");
        btnCargar.setBounds(300, 460, 200, 45);
        btnCargar.setFocusable(false);
        
        // lamba para el evento
        btnCargar.addActionListener(evt -> actualizarAreaReporte());
        
        this.add(btnCargar);
        
        // que se muestre la ventana
        this.setVisible(true);
    }

    
    private void actualizarAreaReporte() {
        if (dataEmpleados.isEmpty()) {
            txtReporte.setText(">>> ALERTA: No existen registros actualmente.");
            return;
        }

        StringBuilder constructorTexto = new StringBuilder();
        constructorTexto.append("====================================\n");
        constructorTexto.append("      REPORTE DE EMPLEADOS   \n");
        constructorTexto.append("====================================\n\n");

        for (ClaseBaseEmpleado trabajador : dataEmpleados) {
            constructorTexto.append(trabajador.toString()).append("\n");
            constructorTexto.append("------------------------------------\n");
        }

        txtReporte.setText(constructorTexto.toString());
    }
}
>>>>>>> 50c7419f86ae08d6fcaa7742fcb5f1a797adb23d
