/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ALISSONRAQUELMARTINE
 */
public class ReporteGUI extends JFrame {

    public ReporteGUI(Empresa empresa) {

        setTitle("Reporte de Empleados");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setText(empresa.generarReporte());

        add(new JScrollPane(area));
        setVisible(true);
    }
}
