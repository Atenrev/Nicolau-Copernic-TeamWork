package sss;

public class Luchador
{
	// Atributos

	// Nombre artistico
	private String nombre;
	
	// Escuela
	private String escuela;
	
	// Caracteristicas primarias
	private int fue;
	private int con;
	private int tam;
	private int des;
	private int per;
	
	// Caracteristicas secundarias
	private float pr;
	private float pd;
	private int pa;
	private int pe;
	
	// Metodos

	// Constructor
	public Luchador(String nombre, int fue, int con, int tam, int des, int per)
	{
		this.nombre = nombre;
		this.escuela = "Ninguna";
		this.fue = fue;
		this.con = con;
		this.tam = tam;
		this.des = des;
		this.per = per;
	}

	// Metodos de acceso
	public String getNombre()
	{
		return this.nombre;
	}
	public String getEscuela()
	{
		return this.escuela;
	}
	public int getFUE()
	{
		return this.fue;
	}
	public int getCON()
	{
		return this.con;
	}
	public int getTAM()
	{
		return this.tam;
	}
	public int getDES()
	{
		return this.des;
	}
	public int getPER()
	{
		return this.per;
	}
	public float getPR()
	{
		return this.pr;
	}
	public float getPD()
	{
		return this.pd;
	}
	public int getPA()
	{
		return this.pa;
	}
	public int getPE()
	{
		return this.pe;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public void setEscuela(String escuela)
	{
		this.escuela = escuela;
	}
	public void setFUE(int fue)
	{
		this.fue = fue;
	}
	public void setCON(int con)
	{
		this.con = con;
	}
	public void setTAM(int tam)
	{
		this.tam = tam;
	}
	public void setDES(int des)
	{
		this.des = des;
	}
	public void setPER(int per)
	{
		this.per = per;
	}
	public void setPR(float pr)
	{
		this.pr = pr;
	}
	public void setPD(float pd)
	{
		this.pd = pd;
	}
	public void setPA(int pa)
	{
		this.pa = pa;
	}
	public void setPE(int pe)
	{
		this.pe = pe;
	}
	
	// Metodos para calcular las caracteristicas secundarias a partir de las primarias
	public void calcularPR()
	{
		this.pr = (float) this.con + this.tam;
	}
	public void calcularPD()
	{
		this.pd = (float) (this.fue + this.tam) / 4;
	}
	public void calcularPA()
	{
		this.pa = this.des + this.fue + this.con;
	}
	public void calcularPE()
	{
		this.pe = this.des * 3;
	}
	public void calcularSecundarias()
	{
		this.calcularPR();
		this.calcularPD();
		this.calcularPA();
		this.calcularPE();
	}

	// Metodo para atacar, que devuelve el resultado del ataque,
	// con un booleano que indica el exito o fracaso, el % del intento, y el daño producido
	public Resultado atacar()
	{
		Resultado ataque;
		boolean exito = false;
		int tirada;
		float dano = 0;
		
		tirada = 1 + (int) (Math.random() * 99);
		if (tirada <= this.pa)
		{
			exito = true;
			dano = this.pd;
		}
		ataque = new Resultado(exito, tirada, dano);
		return ataque;
	}

	// Metodo para esquivar, que devuelve el resultado de la esquiva,
	// con un booleano que indica el exito o fracaso, el % del intento, y la resistencia sobrante
	public Resultado esquivar(float dano)
	{
		Resultado esquiva;
		boolean exito = true;
		int tirada;
		float pr = this.pr;
		
		tirada = 1 + (int) (Math.random() * 99);
		if (tirada > this.pe)
		{
			exito = false;
			pr = pr - dano;
			this.pr = pr;
		}
		esquiva = new Resultado(exito, tirada, pr);
		return esquiva;
	}
	
	// Metodo para incrementar PER por experiencia
	public void incrementarPER()
	{
		this.per = this.per + 1;
	}
        
        // Metodo para generar un String con todos los atributos
	@Override
        public String toString()
        {
                String cadena;
                cadena = "";
		cadena = cadena + "Luchador " + this.getNombre();
		if (!this.getEscuela().equals("Ninguna"))
		{
			cadena = cadena + ", de la escuela " + this.getEscuela();
		}
		cadena = cadena + "\n";
		cadena = cadena + "FUE = " + this.getFUE() + ", ";
		cadena = cadena + "CON = " + this.getCON() + ", ";
		cadena = cadena + "TAM = " + this.getTAM() + ", ";
		cadena = cadena + "DES = " + this.getDES() + ", ";
		cadena = cadena + "PER = " + this.getPER();
		cadena = cadena + "\n";
		cadena = cadena + "PR = " + this.getPR() + ", ";
		cadena = cadena + "PD = " + this.getPD() + ", ";
		cadena = cadena + "PA(%) = " + this.getPA() + ", ";
		cadena = cadena + "PE(%) = " + this.getPE();
                cadena = cadena + "\n";
                return cadena;
        }
}