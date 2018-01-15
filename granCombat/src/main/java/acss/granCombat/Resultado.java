package acss.granCombat;

public class Resultado {
	private boolean exito;
	private int tirada;
	private float extra;

	public Resultado(boolean exito, int tirada, float extra)
	{
		this.exito = exito;
		this.tirada = tirada;
		this.extra = extra;
	}

	public boolean getExito()
	{
		return exito;
	}
	public int getTirada()
	{
		return tirada;
	}
	public float getExtra()
	{
		return extra;
	}
}
