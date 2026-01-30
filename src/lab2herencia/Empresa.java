
package lab2herencia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;

public class Empresa {

    private ArrayList<ClaseBaseEmpleado> empleados;

    public Empresa(ArrayList<ClaseBaseEmpleado> ListaEmpleado) {
        empleados = new ArrayList<>();
    }

    Empresa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void agregarEmpleado(ClaseBaseEmpleado emp) {
        empleados.add(emp);
    }

    public ClaseBaseEmpleado buscarEmpleado(int codigo) {
        for (ClaseBaseEmpleado e : empleados) {
            if (e.codigo == codigo) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<ClaseBaseEmpleado> getEmpleados() {
        return empleados;
    }

    public String generarReporte() {
        if (empleados.isEmpty()) {
            return "No hay empleados registrados.";
        }

        StringBuilder sb = new StringBuilder();
        for (ClaseBaseEmpleado e : empleados) {
            sb.append(e).append("\n-----------------\n");
        }
        return sb.toString();
    }
}