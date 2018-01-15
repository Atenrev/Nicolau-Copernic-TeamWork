package sss;

public class LuchadorCorbGenial extends Luchador
{
	// Metodos

	// Constructor
	public LuchadorCorbGenial(String nombre, int fue, int con, int tam, int des, int per)
	{
		super(nombre, fue, con, tam, des, per);
		this.setEscuela("del Corb Genial");
	}
	
	// Redefine el metodo para calcular la caracteristica secundaria especializada
	public void calcularPA()
	{
		this.setPA(this.getDES() + this.getFUE() + this.getCON() + this.getPER());
	}
}