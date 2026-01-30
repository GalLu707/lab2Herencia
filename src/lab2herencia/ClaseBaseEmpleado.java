/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;
import java.util.Calendar;
        
        
        
public class ClaseBaseEmpleado {
    
    protected int codigo;
    protected String nombre;
    protected Calendar fechaContratacion;
    protected double salarioBase;
    protected int HorasTrabajadas;
    protected String tipo;
    
    public ClaseBaseEmpleado(int codigo, String nombre){
        this.codigo= codigo;
        this.nombre = nombre;
        fechaContratacion= Calendar.getInstance();
        salarioBase = 8500;
        HorasTrabajadas =0;

        
    }
    
    public void registrarhoras(int horas){
        HorasTrabajadas = horas;
    }
    
    public double calcularPago(){
        if(HorasTrabajadas < 160){
            return((salarioBase*HorasTrabajadas)-(salarioBase* 0.035));
        }
        return((salarioBase*160)-(salarioBase*0.035));
    }

    @Override
    public String toString() {
        return"codigo= " + codigo + "\n nombre= " + nombre + "\n fechaContratacion= " + fechaContratacion + '}';
    }
    
    
}
