package Banco;

public class ComprobarDNI 
{
	public static boolean ComprobarDNI(String DNI)
	{
		boolean correcto;
		String cadenanumeros = "1234567890";
		String cadenaletras = "ABCDEFGHJKLMNPQRSTVWXYZ";
		String numero;
		String letra;
		
		if(DNI.length() == 9)
		{
			correcto = true;
			/******************COMPROBAR NUMEROS********************/
			for(int i=0; i >=8; i++)
			{
				numero = DNI.charAt(i)+"";
				if(cadenanumeros.contains(numero))
				{
					correcto = true;
				}
				else
				{
					correcto = false;
					System.out.println("Formato (00000000X) incorrecto");
				}
			}
			/*******************************************************/
				
			/*****************COMPROBAR LETRA***********************/
				letra = DNI.charAt(8)+"";
				if(cadenaletras.contains(letra))
				{
					correcto = true;
				}
				else
				{
					correcto = false;
					System.out.println("Formato (00000000X) incorrecto");
				}
			/**********************************************************/
			
			
		}
		else
		{
			correcto = false;
			System.out.println("Formato (00000000X) incorrecto");
		}
		
		
		return correcto;
	}
	
	
}
