
package lab2herencia;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Empresa extends JFrame {
    
    private static ArrayList<ClaseBaseEmpleado> listaEmpleados;

    public Empresa(ArrayList<ClaseBaseEmpleado> lista) {
        listaEmpleados = (lista != null) ? lista : new ArrayList<>();
        
        // Configuracion de la ventana
        this.setTitle("Sistema de Gestión de Empresa");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        initComponentes();
        
        this.setVisible(true);
    }

    private void initComponentes() {
        // menu
        JLabel lbTitulo = new JLabel("MENU PRINCIPAL DE EMPRESA", SwingConstants.CENTER);
        lbTitulo.setFont(new Font("Serif", Font.BOLD, 32));
        lbTitulo.setBounds(100, 50, 800, 80);
        add(lbTitulo);

        //definicion de botones
        JButton btnRegistro = new JButton("Registrar Empleados");
        btnRegistro.setBounds(200, 180, 250, 55);
        btnRegistro.addActionListener(e -> {
            this.dispose();
            new ventanaRegistrarEmp(listaEmpleados);
        });

        JButton btnBusqueda = new JButton("Buscar Empleado");
        btnBusqueda.setBounds(200, 280, 250, 55);
        btnBusqueda.addActionListener(e -> {
            this.dispose();
            new ventanaBuscarEmp(listaEmpleados);
        });

        JButton btnReporte = new JButton("Generar Reporte");
        btnReporte.setBounds(200, 380, 250, 55);
        btnReporte.addActionListener(e -> {
            this.dispose();
            new ventanaGenReporte(listaEmpleados);
        });

        JButton btnCerrar = new JButton("Salir del Sistema");
        btnCerrar.setBounds(200, 480, 250, 55);
        btnCerrar.addActionListener(e -> System.exit(0));

        // Agregar los componentes 
        add(btnRegistro);
        add(btnBusqueda);
        add(btnReporte);
        add(btnCerrar);
    }

    public static void main(String[] args) {
        
        //pa inizialisar 
        if (listaEmpleados == null) {
            listaEmpleados = new ArrayList<>();
        }
        new Empresa(listaEmpleados);
    }
}