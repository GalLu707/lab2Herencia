
package lab2herencia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            new BuscarEmpGUI(listaEmpleados);
        });

        JButton btnReporte = new JButton("Generar Reporte");
        btnReporte.setBounds(200, 380, 250, 55);
        btnReporte.addActionListener(e -> {
            this.dispose();
            new GenerarReporGUI(listaEmpleados);
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

class BuscarEmpGUI extends JFrame {

    private ArrayList<ClaseBaseEmpleado> listaEmpleados;
    private ClaseBaseEmpleado empBuscado;

    public BuscarEmpGUI(ArrayList<ClaseBaseEmpleado> listaEmpleados) {

        this.listaEmpleados = listaEmpleados;
        this.empBuscado = null;

        setTitle("Buscador de Empleado");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // ===== TÍTULO =====
        JLabel titulo = new JLabel("Buscador de Empleado", SwingConstants.CENTER);
        titulo.setBounds(50, 30, 700, 60);
        titulo.setFont(new Font("Serif", Font.BOLD, 36));
        add(titulo);

        // ===== CÓDIGO =====
        JLabel codigoLabel = new JLabel("Ingrese el código del empleado:");
        codigoLabel.setBounds(100, 130, 300, 25);
        add(codigoLabel);

        JTextField codigotxt = new JTextField();
        codigotxt.setBounds(100, 160, 200, 25);
        add(codigotxt);

        // ===== NOMBRE =====
        JLabel nameLabel = new JLabel("Nombre del empleado:");
        nameLabel.setBounds(100, 220, 300, 25);
        add(nameLabel);

        JTextField nametxt = new JTextField();
        nametxt.setBounds(100, 250, 300, 25);
        nametxt.setEditable(false);
        add(nametxt);

        // ===== BOTÓN BUSCAR =====
        JButton btBuscar = new JButton("Buscar Empleado");
        btBuscar.setBounds(100, 300, 200, 45);
        add(btBuscar);

        btBuscar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(codigotxt.getText());
                ClaseBaseEmpleado temp = buscarEmpleado(codigo);

                if (temp == null) {
                    JOptionPane.showMessageDialog(this, "El empleado no existe");
                    nametxt.setText("");
                    empBuscado = null;
                } else {
                    empBuscado = temp;
                    nametxt.setText(empBuscado.nombre);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un código válido");
            }
        });

        // ===== BOTONES DE ACCIÓN =====
        JButton btRegHoras = new JButton("Registrar Horas");
        btRegHoras.setBounds(450, 150, 250, 45);
        add(btRegHoras);

        btRegHoras.addActionListener(e -> {
            if (empBuscado == null) {
                JOptionPane.showMessageDialog(this, "Primero busque un empleado");
                return;
            }
            dispose();
            new subVentHorasTrabajadas(empBuscado, listaEmpleados);
        });

        JButton btActFecha = new JButton("Actualizar Fecha Contrato");
        btActFecha.setBounds(450, 220, 250, 45);
        add(btActFecha);

        btActFecha.addActionListener(e -> {
            if (empBuscado == null) {
                JOptionPane.showMessageDialog(this, "Primero busque un empleado");
                return;
            }

            if (empBuscado.tipo.equals("Temporal")) {
                new FechaGUI(empBuscado, listaEmpleados);
            } else {
                JOptionPane.showMessageDialog(this, "Opción solo para empleados temporales");
            }
        });

        JButton btRegVentas = new JButton("Registrar Ventas");
        btRegVentas.setBounds(450, 290, 250, 45);
        add(btRegVentas);

        btRegVentas.addActionListener(e -> {
            if (empBuscado == null) {
                JOptionPane.showMessageDialog(this, "Primero busque un empleado");
                return;
            }

            if (empBuscado.tipo.equals("Ventas")) {
                new ventasGUI(empBuscado, listaEmpleados);
            } else {
                JOptionPane.showMessageDialog(this, "Opción solo para empleados de ventas");
            }
        });

        JButton btCalPago = new JButton("Calcular Pago Mensual");
        btCalPago.setBounds(450, 360, 250, 45);
        add(btCalPago);

        btCalPago.addActionListener(e -> {
            if (empBuscado == null) {
                JOptionPane.showMessageDialog(this, "Primero busque un empleado");
                return;
            }
            dispose();
            new subPago(empBuscado, listaEmpleados);
        });

        // ===== REGRESAR =====
        JButton btRegresar = new JButton("Regresar al Menú");
        btRegresar.setBounds(100, 420, 200, 45);
        add(btRegresar);

        btRegresar.addActionListener(e -> {
            dispose();
            new Empresa(listaEmpleados);
        });

        setVisible(true);
    }

    // ===== MÉTODO BUSCAR =====
    private ClaseBaseEmpleado buscarEmpleado(int codigo) {
        for (ClaseBaseEmpleado emp : listaEmpleados) {
            if (emp.getCodigo() == codigo) {
                return emp;
            }
        }
        return null;
    }
}