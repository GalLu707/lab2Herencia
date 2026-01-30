/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;

import java.util.Calendar;

/**
 *
 * @author USER
 */
public class EmpleadoTemporal extends ClaseBaseEmpleado{
 private Calendar FechaFinContrato;  

public EmpleadoTemporal(int codigo, String nombre, String fechaVencimiento) {
    
    super(codigo, nombre);
        super.tipo="Temporal";
        int year;
        String yearSt = "";
        int month;
        String monthSt = "";
        int day;
        String daySt = "";
        
        for (int i = 0; i < fechaVencimiento.length(); i++) {
            if (i >= 0 && i <= 3) {
                yearSt += fechaVencimiento.charAt(i);
            } else if (i >= 5 && i <= 6) {
                monthSt += fechaVencimiento.charAt(i);
            } else if (i >= 8 && i <= 9) {
                daySt += fechaVencimiento.charAt(i);
            }
        }
        
        year = Integer.valueOf(yearSt);
        month = Integer.valueOf(monthSt);
        day = Integer.valueOf(daySt);
        FechaFinContrato.set(year, month, day);
    }
    public double calcularPago() {
        if (super.fechaContratacion.before(FechaFinContrato) || super.fechaContratacion.equals(FechaFinContrato)) {
            return super.calcularPago();
        }
        return 0;
    }
    
} 

