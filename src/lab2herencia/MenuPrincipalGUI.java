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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MenuPrincipalGUI extends JFrame {

    private Empresa empresa;

    public MenuPrincipalGUI(Empresa empresa) {
        this.empresa = empresa;

        setTitle("Sistema de Empresa");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel titulo = new JLabel("MENÚ PRINCIPAL", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 28));
        titulo.setBounds(100, 30, 400, 50);
        add(titulo);

        JButton btnBuscar = new JButton("Buscar Empleado");
        btnBuscar.setBounds(200, 120, 200, 40);
        btnBuscar.addActionListener(e -> {
            dispose();
            new BuscarEmpGUI(empresa);
        });

        JButton btnReporte = new JButton("Reporte");
        btnReporte.setBounds(200, 180, 200, 40);
        btnReporte.addActionListener(e -> {
            dispose();
            new ReporteGUI(empresa);
        });

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(200, 240, 200, 40);
        btnSalir.addActionListener(e -> System.exit(0));

        add(btnBuscar);
        add(btnReporte);
        add(btnSalir);

        setVisible(true);
    }
}

