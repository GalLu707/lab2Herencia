/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;

/**
 *
 * @author USER
 */
public class EmpleadoVentas extends ClaseBaseEmpleado {

private  double[]VentasAlMes;
private  double TarifaComision;
 
    public EmpleadoVentas(int codigo, String nombre, double TarifaComision) {
        super(codigo, nombre);
        
        super.tipo="Ventas";
     this.TarifaComision=TarifaComision;
     VentasAlMes=new double[12];
    }
    
     public void IngresarVentas(double CantidadVentas, int Mes){
     VentasAlMes[Mes]+=CantidadVentas;
     System.out.println("Registro de ventas exitosamente");
     
 }
 
 public double EvaluarComision(int Mes){
     double comision=VentasAlMes[Mes]*TarifaComision;
     return comision;
     
 }
 
 public double EvaluarSuledoMensual(int Mes){
    double SueldoMensual= super.calcularPago()+EvaluarComision(Mes);
    return SueldoMensual;
    
 }
 
 public double EvaluarVentasAnuales(){
     double TotalidadVentas=0;
     for(int i=0; i<VentasAlMes.length; i++){
      TotalidadVentas+=VentasAlMes[i];
     }
     return TotalidadVentas;
 }
 public String toStrin(){
    String  Reporte= super.toString() +"\n Totalidad de ventaas en el año:"+EvaluarVentasAnuales();
    return Reporte;
 }
}
