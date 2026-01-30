/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ALISSONRAQUELMARTINE
 */
public class BuscarEmpGUI extends JFrame {

    private Empresa empresa;
    private ClaseBaseEmpleado empleado;

    public BuscarEmpGUI(Empresa empresa) {
        this.empresa = empresa;

        setTitle("Buscar Empleado");
        setSize(500, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lbl = new JLabel("Código:");
        lbl.setBounds(50, 50, 100, 25);

        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 50, 150, 25);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(300, 50, 100, 25);

        btnBuscar.addActionListener(e -> {
            int codigo = Integer.parseInt(txtCodigo.getText());
            empleado = empresa.buscarEmpleado(codigo);

            if (empleado == null) {
                JOptionPane.showMessageDialog(this, "Empleado no encontrado");
            } else {
                JOptionPane.showMessageDialog(this, "Empleado: " + empleado.nombre);
            }
        });

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(180, 150, 120, 30);
        btnRegresar.addActionListener(e -> {
            dispose();
            new MenuPrincipalGUI(empresa);
        });

        add(lbl);
        add(txtCodigo);
        add(btnBuscar);
        add(btnRegresar);

        setVisible(true);
    }
}
