/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;
import java.util.Calendar;
import java.util.ArrayList;
        
        
public class ClaseBaseEmpleado {
  
    public static ArrayList<ClaseBaseEmpleado> ListaEmpleado = new ArrayList<ClaseBaseEmpleado>();
    Empresa ventana = new Empresa(ListaEmpleado);
    
    
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
    // when haces tus momazos en comentarios
    //ayudenme a no cometer un crimen de odio en contra de jocsan 
    
    
}
