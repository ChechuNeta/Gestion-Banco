package Banco;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu 
{
	
	public static void Menu()
	{
		ArrayList<Cuenta> cuenta;
		int numcuenta = 1;
		
		Cuenta 	unacuenta;
		String 	DNI;
		float   dinerocreacion;
		
		LocalDate	mifechafin;
		Scanner sc;
		
		/*******************/
		int seleccion;
		int seleccion2;
		int continuar = 1;
		/*******************/
		
		sc = new Scanner(System.in);
		cuenta = new ArrayList<Cuenta>();
		
		System.out.println("Bienvenido a Banco Chechu \n ¿Que Desea hacer?");
		
		
	
		do
		{
			System.out.println();
			System.out.println("1-Crear Cuenta");
			System.out.println("2-Entrar en cuenta");
			seleccion = sc.nextInt();
			sc.nextLine();
			
			switch(seleccion)
			{
			
			

				case 1:
					do
					{	
						System.out.println("Intruduzca su DNI");
						DNI = sc.nextLine();
					}
					while(ComprobarDNI.ComprobarDNI(DNI) == false);
					
					System.out.println("Dinero de creacion");
					dinerocreacion = sc.nextFloat();
					
					unacuenta = new Cuenta(123,1,DNI,numcuenta,dinerocreacion);
					numcuenta += 1;
					cuenta.add(unacuenta); 
					System.out.println("Cuenta creada");
					System.out.println();
					System.out.println(unacuenta.GetInfo());
					
					break;
					
				case 2:
					int 	sucuenta;
					int 	codhip;
					
					float 	cantidad;
					boolean checkcuenta;
					
					//Al seleccionar una cuenta para despues realizar ops dentro de ella se le restara uno, ya que la primera es 0
					//Asi la primera pasa a ser la 1
					
					do
					{
						System.out.println("introduzca su numero de cuenta");
						sucuenta = sc.nextInt();
						//comprobamos si esta cuenta esta creada
						if(sucuenta > cuenta.size())
						{
							System.out.println("No existe esta cuenta");
							checkcuenta = false;
						}
						else
						{
						System.out.println(cuenta.get(sucuenta-1).GetInfo());
						checkcuenta = true;
						}
					}
					while((checkcuenta != true) && (cuenta.size() != 0 ) );
					
					System.out.println();
					System.out.println("Que operacion desea realizar");
					

					while ((continuar == 1) && (cuenta.size() != 0 ))
					{
						System.out.println("1-Ingresar Dinero \n 2-Sacar Dinero \n 3-Solicitar Hipoteca \n "
								+ "4-Amortizar hipoteca \n 5-Ver Movimientos \n 6-Salir de esta cuenta");
						seleccion = sc.nextInt();
						switch(seleccion)
						{
							case 1:
								System.out.println("Ingrese una cantidad (Saldo: " + cuenta.get(sucuenta-1).getSaldo() + "€)");
								cantidad = sc.nextFloat();
								cuenta.get(sucuenta-1).IngresarDinero(cantidad);
								System.out.println();
								System.out.println("Saldo actual: " + cuenta.get(sucuenta-1).getSaldo() + "€");
								break;
							
							case 2:
								System.out.println("Saque una cantidad (Saldo: " + cuenta.get(sucuenta-1).getSaldo() + "€)");
								cantidad = sc.nextFloat();
								cuenta.get(sucuenta-1).SacarDinero(cantidad);
								System.out.println();
								System.out.println("Saldo actual: " + cuenta.get(sucuenta-1).getSaldo() + "€");
								break;
								
							case 3:
								System.out.println("Para conceder una hipoteca, diga cual sera su codigo de hipoteca (solo numeros)");
								codhip = sc.nextInt();
								System.out.println("Que cantidad que solicita");
								cantidad = sc.nextFloat();
								System.out.println("El interes sera del 5%"); //Se puede hacer para que dependa de la cantidad, pero de momento sera siempre del 5
								mifechafin = LocalDate.of(2026, 1, 31); //Lo mismo que el interes, se puede cambiar
								cuenta.get(sucuenta-1).ConcederHipoteca(codhip, 5, mifechafin, cantidad);
								System.out.println();
								System.out.println(cuenta.get(sucuenta-1).GetInfo());
								break;
								
							case 4:
								System.out.println("Cuanto desea amortizar (Saldo: " + cuenta.get(sucuenta-1).getSaldo() + "€)");
								cantidad = sc.nextFloat();
								cuenta.get(sucuenta-1).AmortizarHipoteca(cantidad);
								System.out.println();
								System.out.println(cuenta.get(sucuenta-1).GetInfo());
								break;
								
							case 5:
								
								if(cuenta.get(sucuenta-1).vermovimientos() == true)
								{
									System.out.println("1-Ver un movimioento \n2-Ver todos los movimientos");
									seleccion = sc.nextInt();
									if(seleccion == 1)
									{
										System.out.println("Que movimiento?");
										seleccion2 = sc.nextInt();	
										System.out.println();
										System.out.println(cuenta.get(sucuenta-1).GetInfoMovimietos(seleccion, seleccion2));
									}
									else
									{
										seleccion2 = 0;
										System.out.println();
										System.out.println(cuenta.get(sucuenta-1).GetInfoMovimietos(seleccion, seleccion2));
									}
								}
								else
								{
									System.out.println("No existen movimientos aun");
								}
								
								break;
								
							case 6:
								System.out.println("Saliste de la cuenta");
								
						}
						
						if(seleccion >= 6)
						{
							System.out.println("...");
							continuar = 0;
						}
						else
						{
							System.out.println();
							System.out.println("Desea Continuar haciendo operaciones ? \n 1-si \n 2-no");
							continuar = sc.nextInt();
						}
					
					}
					
					
			}
			
			System.out.println();
			System.out.println("Desea Continuar (Menu de cuentas) ? \n 1-si \n 2-no");
			continuar = sc.nextInt();
		}
		while(continuar == 1);
		
	}
	
	
	
	
}


