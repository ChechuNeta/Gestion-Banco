package Banco;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Cuenta 
{	// PROPIEDADES
	private	int			codigo_banco;
	private int			codigo_sucursal;
	private String		DNI;
	private int			codigo_cuenta;
	private LocalDate	fecha_creacion;
	private LocalTime	hora_creacion;
	private float		saldo;
	// private float		saldo_inicial;
	Hipoteca			una_hipoteca;
	//Movimento			lista_movimientos[];	// estructura con dimensión fija
	// lista de movimientos que crece y decrece de forma automática
	private ArrayList<Movimiento>			lista_movimientos;
	private int			numero_mov;
	
	// CONSTRUCTORES
	public Cuenta(int el_codigo_banco, int el_codigo_sucursal, String el_DNI, int el_codigo_cuenta, float el_dinero)
	{	this.codigo_banco = el_codigo_banco;
		this.codigo_sucursal = el_codigo_sucursal;
		this.DNI = el_DNI;
		this.codigo_cuenta = el_codigo_cuenta;	// se podría haber generado de forma automática aquí
		this.saldo = el_dinero;
		// se pone la fecha y hora actuales
		this.fecha_creacion = LocalDate.now();
		this.hora_creacion = LocalTime.now();
		// la hipoteca ES null, no está creada
		// INICIALIZA EL ARRAY LIT D MOVIMEINTOS Y EL NÚMERO DE MOVIMIENTO A 0
		this.lista_movimientos = new ArrayList<Movimiento>();
		this.numero_mov = 0;
	}
	
	// GET, SET
	public int getCodigo_banco() {
		return codigo_banco;
	}

	public void setCodigo_banco(int codigo_banco) {
		this.codigo_banco = codigo_banco;
	}

	public int getCodigo_sucursal() {
		return codigo_sucursal;
	}

	public void setCodigo_sucursal(int codigo_sucursal) {
		this.codigo_sucursal = codigo_sucursal;
	}

	protected String getDNI()
	{	return DNI;
	}

	private void setDNI(String dNI) 
	{	DNI = dNI;
	}

	protected int getCodigo_cuenta() {
		return codigo_cuenta;
	}

	private void setCodigo_cuenta(int codigo_cuenta)
	{	this.codigo_cuenta = codigo_cuenta;
	}

	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public LocalTime getHora_creacion() {
		return hora_creacion;
	}

	public void setHora_creacion(LocalTime hora_creacion) {
		this.hora_creacion = hora_creacion;
	}

	public float getSaldo() {
		return saldo;
	}

	private void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	
	// OTROS
	/**********************************************/
	public boolean SacarDinero(float sacar)
	{	// declarar variables
		boolean b_resultado;
		
		// comprobaciones previas
		if (sacar < 0) 	// no se permiten cantidades negativas
		{	b_resultado = false;
		}
		else
		{	if (sacar > this.getSaldo())	// no se puede sacar más dinero que el que hay actualmente en la cuenta (saldo)
			{	b_resultado = false;
			}
			else	// la cantidad a sacar es positiva y hay saldo en la cuenta
			{	//this.saldo -= sacar;
				this.saldo = this.saldo - sacar;
				//this.setSaldo(this.getSaldo() - sacar);
				// hay que generar el movimiento
				GenerarMovimiento(sacar, "3344");	// revisar 1122
				
				b_resultado = true;
			}
		}
		
		return b_resultado;
	}
	/**********************************************/
	
	
	/**********************************************/
	public boolean IngresarDinero(float ingresar)
	{	// declarar variables
		boolean b_resultado;
		
		// comprobaciones previas
		if (ingresar < 0) 	// no se permiten cantidades negativas
		{	b_resultado = false;
		}
		else
		{	//this.saldo += ingresar;
			this.saldo = this.saldo + ingresar;
			//this.setSaldo(this.getSaldo() + ingresar);
			// se debería guardar un registro de esta operación
			// poniendo la identificación de la cuenta, banco, dinero ingresado, etc.
			// más ña fecha y hora actuales
			GenerarMovimiento(ingresar, "3344");	// revisar 3344
			
			b_resultado = true;
		}
		
		return b_resultado;
	}
	/*******************************************/
	
	
	/*******************************************/
	private void GenerarMovimiento(float cuanto_dinero, String origen_mov)
	{	Movimiento unmovimiento;
	
		this.numero_mov += 1;
		// crea el movimiento
		unmovimiento = new Movimiento(this.numero_mov, this.getCodigo_cuenta(), cuanto_dinero, origen_mov); // el origen siempre es un cajero 1122. Hay que corregirlo
		// lo añade a la lista de moviimentos
		lista_movimientos.add(unmovimiento);	
	}
	/*******************************************/
	
	
	public float SaldoActual()
	{	return this.getSaldo();
	}
	
	
	/********************************************/
	public String GetInfo()
	{	String st_resultado;
	
		st_resultado = "***** CUENTA *****\n";
		st_resultado = st_resultado + "Banco: " + this.getCodigo_banco() + "\n";
		st_resultado = st_resultado + " Sucursal: " + this.codigo_sucursal + "\n";
		st_resultado = st_resultado + " DNI: " + this.getDNI() + "\n";
		st_resultado = st_resultado + " Num Cuenta: " + this.codigo_cuenta + "\n";
		st_resultado = st_resultado + " Fecha Creación: " + this.fecha_creacion + "\n";
		st_resultado = st_resultado + " Hora Creación: " + this.getHora_creacion() + "\n";
		st_resultado = st_resultado + " Saldo: " + this.saldo + "\n";
		
		st_resultado = st_resultado + "***** HIPOTECA *****\n";
		if (this.una_hipoteca != null)
		{	st_resultado = st_resultado + this.una_hipoteca.GetInfo();
		}
		else // hipoteca es null --> no se ha concedido
		{	st_resultado = st_resultado + "No tiene hipoteca";
		}
		
		return st_resultado;
	}
	
	public String Saldodisponible()
	{
		return "Ahora dispone de " + getSaldo() + "€";
	}
	
	/********************************************/
	

	public boolean ConcederHipoteca(int el_codigo_hipoteca, float el_interes, LocalDate la_fecha_fin, float el_dinero_prestado)
	{	boolean b_resultado;
		
		if (this.una_hipoteca == null)
		{	
			this.una_hipoteca = new Hipoteca(el_codigo_hipoteca, this.getDNI(), this.getCodigo_banco(), this.getCodigo_sucursal(), el_interes, la_fecha_fin, el_dinero_prestado);
			b_resultado = true;
		}
		else
		{	b_resultado = false;
		}
		
		return b_resultado;
	}
	
	
	public boolean AmortizarHipoteca(float cuanto_amortizar)
	{	boolean b_resultado;
		
		if ((this.una_hipoteca != null) && (this.getSaldo() >= cuanto_amortizar))
		{	// amortizar la hipoteca
			if (this.una_hipoteca.AmortizarHipoteca(cuanto_amortizar) == true)
			{	// restar dinero de la cuenta
				this.SacarDinero(cuanto_amortizar);
				b_resultado = true;
			}
			else
			{	
				b_resultado = false;
			}
		}
		else
		{	
			b_resultado = false;
		}
		
		return b_resultado;
	}
	
	public String GetInfoMovimietos(int seleccion, int seleccion2)
	{	
		String resultado ="";
		
		if(seleccion == 1)
		{
			if(seleccion2 > lista_movimientos.size())
			{
				resultado = "No existe ese movimiento";
			}
			else
			{
				resultado = lista_movimientos.get(seleccion2-1).GetInfo();
			}
		}
		else
		{
			for(int i = 0; i < lista_movimientos.size(); i++)
			{
				resultado += lista_movimientos.get(i).GetInfo() + "\n";
			}
		}
		
		
		return resultado;
	}
	
	public boolean vermovimientos()
	{
		boolean haymovs;
		
		if(lista_movimientos.size() == 0)
		{
			haymovs = false;
			
		}
		else
		{
			haymovs = true;
		}
		
		return haymovs;
	}
}
	
	/*****************************************/
	
	/****************************************/

