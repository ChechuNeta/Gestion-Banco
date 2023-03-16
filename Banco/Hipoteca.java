package Banco;


import java.time.LocalDate;
import java.time.LocalTime;

public class Hipoteca 
{	// PROPIEDADES
	private int			codigo_hipoteca;	
	private LocalDate	fecha_concesion;
	private LocalTime	hora_concesion;
	private String		DNI;
	private int 		codigo_banco;
	private int			codigo_sucursal;
	private float		interes;			
	private LocalDate	fecha_fin;			
	private float		dinero_inicial;
	private float		resta;		
	
	
	// CONSTRUCTOR
	public Hipoteca(int el_codigo_hipoteca, String el_DNI, int el_codigo_banco, int el_codigo_sucursal, float el_interes, LocalDate la_fecha_fin, float el_dinero_prestado)
	{	this.codigo_hipoteca = el_codigo_hipoteca;
		// setCodigo_hipoteca(el_codigo_hipoteca)
		this.codigo_banco = el_codigo_banco;
		this.codigo_sucursal = el_codigo_sucursal;
		this.DNI = el_DNI;
		//this.codigo_cuenta = el_codigo_cuenta;
		this.dinero_inicial = el_dinero_prestado;
		this.resta = el_dinero_prestado;
		// se pone la fecha y hora actuales
		this.fecha_concesion = LocalDate.now();
		this.hora_concesion = LocalTime.now();
		this.interes = el_interes;
		this.fecha_fin = la_fecha_fin;
	}


	// get set
	public int getCodigo_hipoteca() {
		return codigo_hipoteca;
	}


	private void setCodigo_hipoteca(int codigo_hipoteca) {
		this.codigo_hipoteca = codigo_hipoteca;
	}


	public LocalDate getFecha_concesion() {
		return fecha_concesion;
	}


	private void setFecha_concesion(LocalDate fecha_concesion) {
		this.fecha_concesion = fecha_concesion;
	}


	public LocalTime getHora_concesion() {
		return hora_concesion;
	}


	private void setHora_concesion(LocalTime hora_concesion) {
		this.hora_concesion = hora_concesion;
	}


	public String getDNI() {
		return DNI;
	}


	private void setDNI(String dNI) {
		DNI = dNI;
	}


	public int getCodigo_banco() {
		return codigo_banco;
	}


	private void setCodigo_banco(int codigo_banco) {
		this.codigo_banco = codigo_banco;
	}


	public int getCodigo_sucursal() {
		return codigo_sucursal;
	}


	private void setCodigo_sucursal(int codigo_sucursal) {
		this.codigo_sucursal = codigo_sucursal;
	}


	public float getInteres() {
		return interes;
	}


	private void setInteres(float interes) {
		this.interes = interes;
	}


	public LocalDate getFecha_fin() {
		return fecha_fin;
	}


	private void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	public float getDinero_inicial() {
		return dinero_inicial;
	}


	private void setDinero_inicial(float dinero_inicial) {
		this.dinero_inicial = dinero_inicial;
	}


	public float getResta() 
	{	return resta;
	}


	private void setResta(float resta)
	{	this.resta = resta;
	}
	
		
	// OTROS MÉTODOS
	public float PorPagarHipoteca()
	{	
		return resta; 
		// return this.getResta();
	}
	
	
	public boolean AmortizarHipoteca(float cuanto)
	{	boolean b_resultado;
		
		if (this.resta >= cuanto)
		{	
			this.resta -= cuanto;
			b_resultado = true;
		}
		else
		{	
			return false;
		}
		// resta = resta - cuanto;
	
		return b_resultado;
	}
	
	
	/********************************************/
	public String GetInfo()
	{	
		return  "Banco: " + this.getCodigo_banco() + "\n" +
				" Sucursal: " + this.codigo_sucursal + "\n" +
				" DNI: " + this.getDNI() + "\n" +
				" Hipoteca: " + this.codigo_hipoteca + "\n" +
				" Fecha Concesión: " + this.fecha_concesion + "\n" +
				" Hora Concesión: " + this.hora_concesion + "\n" +
				" Fecha Fin Hipoteca: " + this.fecha_fin + "\n" +
				" Interés: " + this.interes + "\n" +
				" Hipoteca Inicial: " + this.dinero_inicial + "\n" +
				" Resta por Pagar: " + this.resta + "\n";
	}
	/********************************************/

}
/********* fn clase hipoteca ****************/



