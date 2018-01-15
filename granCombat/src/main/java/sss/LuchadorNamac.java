package sss;

public class LuchadorNamac extends Luchador
{
	// Metodos

	// Constructor
	public LuchadorNamac(String nombre, int fue, int con, int tam, int des, int per)
	{
		super(nombre, fue, con, tam, des, per);
		this.setEscuela("de Namac");
	}
	
	// Redefine el metodo para calcular la caracteristica secundaria especializada
	public void calcularPR()
	{
		this.setPR(this.getCON() + this.getTAM() + this.getPER());
	}
}