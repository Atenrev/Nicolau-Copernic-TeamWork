package sss;


public class LuchadorFolletTortuga extends Luchador
{
	// Metodos

	// Constructor
	public LuchadorFolletTortuga(String nombre, int fue, int con, int tam, int des, int per)
	{
		super(nombre, fue, con, tam, des, per);
		this.setEscuela("del Follet Tortuga");
	}
	
	// Redefine el metodo para calcular la caracteristica secundaria especializada
	public void calcularPD()
	{
		this.setPD((float) (this.getFUE() + this.getTAM() + this.getPER()) / 4);
	}
}