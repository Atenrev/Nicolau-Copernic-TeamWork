package granCombatE0;

import java.io.*;

public class GranCombat
{
	// M�todos
	
	// Principal
	public static void main(String[] args)
	{
		final int MAXIMOPRIMARIAS = 60;
		boolean seguir = true;
		Luchador luchadorA;
		Luchador luchadorB;
		
		String entrada;
		BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));
		
		System.out.println("BIENVENIDOS AL GRAN COMBATE DE LAS ARTES MARCIALES!!!");
		System.out.println("-----------------------------------------------------");
		System.out.println();
		
		System.out.println("Define a tus luchadores:");
		System.out.println();
		luchadorA = GranCombat.definirLuchador(MAXIMOPRIMARIAS);
		luchadorA.calcularSecundarias();
		
		while (seguir == true)
		{
			luchadorB = GranCombat.definirLuchador(MAXIMOPRIMARIAS);
			luchadorB.calcularSecundarias();
		
			System.out.println("Los candidatos son:");
			System.out.println();
			GranCombat.mostrarLuchador(luchadorA);
			GranCombat.mostrarLuchador(luchadorB);
		
			System.out.println("Que empiece el combate!!!");
			System.out.println();
			while ((luchadorA.obtenerPR() > 0) && (luchadorB.obtenerPR() > 0))
			{
				GranCombat.combatir(luchadorA, luchadorB);
				if (luchadorB.obtenerPR() <= 0)
				{
					System.out.println("EL LUCHADOR " + luchadorA.obtenerNombre() + " GANA EL COMBATE!!!");
				}
				else
				{
					GranCombat.combatir(luchadorB, luchadorA);
					if (luchadorA.obtenerPR() <= 0)
					{
						System.out.println("EL LUCHADOR " + luchadorB.obtenerNombre() + " GANA EL COMBATE!!!");
					}
				}
			}
			
			if (luchadorA.obtenerPR() <= 0)
			{
				luchadorA = luchadorB;
			}
			System.out.println();
			System.out.print("Deseas que el ganador se enfrente a un nuevo contrincante (S/N)?");
			
			try
			{
				entrada = stdin.readLine();
				if (entrada.equals("N") || entrada.equals("n"))
				{
					seguir = false;
				}
				else
				{
					luchadorA.incrementarPER();
					luchadorA.calcularSecundarias();
					System.out.println();					
					System.out.println("Define un nuevo luchador para enfrentarse al ganador del anterior combate:");
					System.out.println();
				}
			}
			
			catch(Exception exc)
			{
				// Mostramos el mensaje de error
				System.err.println("\nError: " + exc.getMessage());
				System.err.println();
			}
			
		}
	}

	// M�todo para definir un luchador, con una suma de caracter�sticas primarias
	// limitada por el valor maxCaract
	public static Luchador definirLuchador(int maxCaract)
	{
		String nombre = "Sin Nombre";
		int fue = 1;
		int con = 1;
		int tam = 1;
		int des = 1;
		int per = 1;
		Luchador unLuchador = new Luchador(nombre, fue, con, tam, des, per);
		boolean valoresOK = false;
		int escuela;
		
		String entrada;
		BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));
		
		try
		{
			System.out.print("Nombre del luchador: ");		
			nombre = stdin.readLine();
			
			while (valoresOK == false)
			{
				valoresOK = true;
				
				System.out.print("FUE: ");		
				entrada = stdin.readLine();
				fue = Integer.parseInt(entrada);
				System.out.print("CON: ");		
				entrada = stdin.readLine();
				con = Integer.parseInt(entrada);
				System.out.print("TAM: ");		
				entrada = stdin.readLine();
				tam = Integer.parseInt(entrada);
				System.out.print("DES: ");		
				entrada = stdin.readLine();
				des = Integer.parseInt(entrada);
				System.out.print("PER: ");		
				entrada = stdin.readLine();
				per = Integer.parseInt(entrada);				
				
				if ((fue<3) || (fue>18) || (con<3) || (con>18) || (tam<3) ||
				    (tam>18) ||	(des<3) || (des>18) || (per<3) || (per>18))
				{
				   	valoresOK = false;
				   	System.out.println("Las caracteristicas deben estar en el rango de 3 a 18");
				}
				if (fue+con+tam+des+per > maxCaract)
				{
					valoresOK = false;
					System.out.println("La suma de caracteristicas ha de ser menor o igual a " + maxCaract);
				}
				System.out.println();
			}
			
			System.out.println("Escuela: ");
			System.out.println("		  0) Follet Tortuga");
			System.out.println("		  1) Corb Genial");
			System.out.println("		  2) Hoi-Poi");
			System.out.println("		  3) Namac");
			System.out.println("		  4) Ninguna");
			entrada = stdin.readLine();
			escuela = Integer.parseInt(entrada);
			System.out.println();
			
			switch (escuela)
			{
				case 0:
				{
					unLuchador = new LuchadorFolletTortuga(nombre, fue, con, tam, des, per);
				} break;
				case 1:
				{
					unLuchador = new LuchadorCorbGenial(nombre, fue, con, tam, des, per);
				} break;
				case 2:
				{
					unLuchador = new LuchadorHoiPoi(nombre, fue, con, tam, des, per);
				} break;
				case 3:
				{
					unLuchador = new LuchadorNamac(nombre, fue, con, tam, des, per);
				} break;
				default:
				{
					unLuchador = new Luchador(nombre, fue, con, tam, des, per);
				}
			}
		}
		
		catch(Exception exc)
		{
			// Mostramos el mensaje de error
			System.err.println("\nError: " + exc.getMessage());
			System.err.println();
		}

		return unLuchador;
	}

	// COMENTARIO SERGI: ESTE MÉTODO YA ESTÁ EN LA CLASE LUCHADOR ASÍ QUE NO PASAR
	public static void mostrarLuchador(Luchador unluchador)
	{
		System.out.print("Luchador " + unluchador.obtenerNombre());
		if (unluchador.obtenerEscuela() != "Ninguna")
		{
			System.out.print(", de la escuela " + unluchador.obtenerEscuela());
		}
		System.out.println();
		System.out.print("FUE = " + unluchador.obtenerFUE() + ", ");
		System.out.print("CON = " + unluchador.obtenerCON() + ", ");
		System.out.print("TAM = " + unluchador.obtenerTAM() + ", ");
		System.out.print("DES = " + unluchador.obtenerDES() + ", ");
		System.out.println("PER = " + unluchador.obtenerPER());
		System.out.print("PR = " + unluchador.obtenerPR() + ", ");
		System.out.print("PD = " + unluchador.obtenerPD() + ", ");
		System.out.print("PA(%) = " + unluchador.obtenerPA() + ", ");
		System.out.println("PE(%) = " + unluchador.obtenerPE());
		System.out.println();
	}
	
	// M�todo para representar un asalto de combate
	public static void combatir(Luchador luchadorAtaca, Luchador luchadorEsquiva)
	{
		Resultado ataque;
		Resultado esquiva;
		
		ataque = luchadorAtaca.atacar();
		if (ataque.obtenerExito() == false)
		{
			System.out.println(luchadorAtaca.obtenerNombre() + " ataca con un " + ataque.obtenerTirada() + "% y falla el golpe");
		}
		else
		{
			System.out.println(luchadorAtaca.obtenerNombre() + " ataca con un " + ataque.obtenerTirada() + "% y acierta el golpe");
			esquiva = luchadorEsquiva.esquivar(ataque.obtenerExtra());
			if (esquiva.obtenerExito() == true)
			{
				System.out.println(luchadorEsquiva.obtenerNombre() + " esquiva con un " + esquiva.obtenerTirada() + "% y acierta la esquiva");
			}
			else
			{
				System.out.println(luchadorEsquiva.obtenerNombre() + " esquiva con un " + esquiva.obtenerTirada() + "% y falla la esquiva");
				if (esquiva.obtenerExtra() > 0)
				{
					System.out.println(luchadorEsquiva.obtenerNombre() + " recibe un golpe que le baja la resistencia a " + esquiva.obtenerExtra());
				}
				else
				{
					System.out.println(luchadorEsquiva.obtenerNombre() + " cae vencido del golpe!");
				}
			}
		}
		System.out.println();
	}
}