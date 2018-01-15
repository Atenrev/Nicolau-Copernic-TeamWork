package sss;


public class LuchadorHoiPoi extends Luchador
{
	// Metodos

	// Constructor
	public LuchadorHoiPoi(String nombre, int fue, int con, int tam, int des, int per)
	{
		super(nombre, fue, con, tam, des, per);
		this.setEscuela("de Hoi-Poi");
	}
	
	// Redefine el metodo para calcular la caracteristica secundaria especializada
	public void calcularPE()
	{
		this.setPE(this.getDES() * 3 + this.getPER());
	}
}