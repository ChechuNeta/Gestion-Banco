package Banco;


import java.time.LocalDate;
import java.time.LocalTime;

public class Movimiento 
{	// PROPIEDADES
	private int			id_movimiento;		// clave
	private LocalDate 	fecha_movimiento;
	private LocalTime 	hora_movimiento;
	private int			codigo_cuenta;
	private float		cantidad; // + --> ingresar, - --> sacar
	private String		origen_movimiento;	// Internet --> IP, cajero --> id de cajero
	
	// CONSTRUCTORES
	public Movimiento(int el_id_movimiento, int el_codigo_cuenta, float la_cantidad, String el_origen_movimiento)
	{	
		this.id_movimiento = el_id_movimiento;
		this.fecha_movimiento = LocalDate.now(); 
		this.hora_movimiento = LocalTime.now();
		this.codigo_cuenta = el_codigo_cuenta;
		this.cantidad = la_cantidad;
		this.origen_movimiento = el_origen_movimiento;
	}

	
	
	// GET/SET
	public int getId_movimiento() {
		return id_movimiento;
	}

	/*private void setId_movimiento(int id_movimiento) {
		this.id_movimiento = id_movimiento;
	}*/

	public LocalDate getFecha_movimiento() {
		return fecha_movimiento;
	}

	/*private void setFecha_movimiento(LocalDate fecha_movimiento) {
		this.fecha_movimiento = fecha_movimiento;
	}*/

	public LocalTime getHora_movimiento() {
		return hora_movimiento;
	}

	/*private void setHora_movimiento(LocalTime hora_movimiento) {
		this.hora_movimiento = hora_movimiento;
	}*/

	public int getCodigo_cuenta() {
		return codigo_cuenta;
	}

	/*private void setCodigo_cuenta(int codigo_cuenta) {
		this.codigo_cuenta = codigo_cuenta;
	}*/

	public float getCantidad() {
		return cantidad;
	}

	/*private void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}*/

	public String getOrigen_movimiento() {
		return origen_movimiento;
	}

	/*private void setOrigen_movimiento(String origen_movimiento) {
		this.origen_movimiento = origen_movimiento;
	}*/
	
	// OTROS MÉTODOS
	public String GetInfo()
	{	
		return  "Codigo de la cuenta: " + this.codigo_cuenta + "\n" +
				"Movimiento: " + this.id_movimiento + "\n" +
				"Fecha: " + this.fecha_movimiento + "\n" +
				"Hora: " + this.hora_movimiento + "\n" +
				"Cantidad: " + this.cantidad + "\n" +
				"Origen: " + this.origen_movimiento + "\n \n";
	}



}
/******************* fin de la clase Movimiento **********/


