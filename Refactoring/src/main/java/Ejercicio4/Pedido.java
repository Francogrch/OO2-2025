package Ejercicio4;

import java.util.List;

public class Pedido {
  private Cliente cliente;
  private List<Producto> productos;
//  private String formaPago;
  private FormaDePago formaPago;

  
  public Pedido(Cliente cliente, List<Producto> productos, FormaDePago formaPago) {
//     if (!"efectivo".equals(formaPago)
//        && !"6 cuotas".equals(formaPago)
//       && !"12 cuotas".equals(formaPago)) {
//          throw new Error("Forma de pago incorrecta");
//    }
    this.cliente = cliente;
    this.productos = productos;
    this.formaPago = formaPago;
   }
  
  
   public double getCostoTotalViejo() {
//     double costoProductos = 0;
//     for (Producto producto : this.productos) {
//       costoProductos += producto.getPrecio();
//     }
     double costoProductos = productos.stream().mapToDouble(p -> p.getPrecio()).sum();
     
//     double extraFormaPago = 0;
//     if ("efectivo".equals(this.formaPago)) {
//       extraFormaPago = 0;
//     } else if ("6 cuotas".equals(this.formaPago)) {
//       extraFormaPago = costoProductos * 0.2;
//     } else if ("12 cuotas".equals(this.formaPago)) {
//    extraFormaPago = costoProductos * 0.5;
//     }
     double extraFormaPago = formaPago.extra(costoProductos);
     
     
     //int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
     int añosDesdeFechaAlta = cliente.aniosDesdeAlta();
    		 
    //Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
     if (añosDesdeFechaAlta > 5) {
       return (costoProductos + extraFormaPago) * 0.9;
     }
     return costoProductos + extraFormaPago;
   }
 
   private double costoProductos() {
     return productos.stream().mapToDouble(p -> p.getPrecio()).sum();
   }
   
   private double extraFormaPago() {
     return formaPago.extra(costoProductos());
   }
   
   public double getCostoTotal() {
	 if (cliente.mayorA5()) {
       return (costoProductos() + extraFormaPago()) * 0.9;
     }
     return costoProductos() + extraFormaPago();
	
   }
 }	
