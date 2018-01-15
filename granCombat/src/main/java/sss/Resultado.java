package sss;

/**
 *
 * @author Iciar
 */

public class Resultado
{
	// Atributos
	private boolean exito;
	private int tirada;
	private float extra;

	// Metodos
	// Constructor
	public Resultado(boolean exito, int tirada, float extra)
	{
		this.exito = exito;
		this.tirada = tirada;
		this.extra = extra;
	}
	// Métodos de acceso
	public boolean getExito()
	{
		return this.exito;
	}
	public int getTirada()
	{
		return this.tirada;
	}
	public float getExtra()
	{
		return this.extra;
	}
}
