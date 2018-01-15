package acss.granCombat;

public class Luchador {
	
	private String nombre,
				escuela;

	private int fue;
	private int con;
	private int tam;
	private int des;
	private int per;

	private float pr;
	private float pd;
	private int pa;
	private int pe;

	public Luchador(String nombre, int fue, int con, int tam, int des, int per) {
		this.nombre = nombre;
		this.escuela = "Ninguna";
		this.fue = fue;
		this.con = con;
		this.tam = tam;
		this.des = des;
		this.per = per;
	}

	public String getNombre() {
		return nombre;
	}
	public String getEscuela() {
		return escuela;
	}
	public int getFue() {
		return fue;
	}
	public int getCon() {
		return con;
	}
	public int getTam() {
		return tam;
	}
	public int getDes() {
		return des;
	}
	public int getPer() {
		return per;
	}
	public float getPr() {
		return pr;
	}
	public float getPd() {
		return pd;
	}
	public int getPa() {
		return pa;
	}
	public int getPe() {
		return pe;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	public void setFue(int fue) {
		this.fue = fue;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public void setDes(int des) {
		this.des = des;
	}

	public void setPer(int per) {
		this.per = per;
	}

	public void setPr(float pr) {
		this.pr = pr;
	}

	public void setPd(float pd) {
		this.pd = pd;
	}

	public void setPa(int pa) {
		this.pa = pa;
	}

	public void setPe(int pe) {
		this.pe = pe;
	}

	public void calcularPR() {
		this.pr = (float) this.con + this.tam;
	}

	public void calcularPD() {
		this.pd = (float) (this.fue + this.tam) / 4;
	}

	public void calcularPA() {
		this.pa = this.des + this.fue + this.con;
	}

	public void calcularPE() {
		this.pe = this.des * 3;
	}

	public void calcularSecundarias() {
		this.calcularPR();
		this.calcularPD();
		this.calcularPA();
		this.calcularPE();
	}

	public Resultado atacar() {
		Resultado ataque;
		boolean exito = false;
		int tirada;
		float dano = 0;

		tirada = 1 + (int) (Math.random() * 99);
		if (tirada <= this.pa) {
			exito = true;
			dano = this.pd;
		}
		ataque = new Resultado(exito, tirada, dano);
		return ataque;
	}

	public Resultado esquivar(float dano) {
		Resultado esquiva;
		boolean exito = true;
		int tirada;
		float pr = this.pr;

		tirada = 1 + (int) (Math.random() * 99);
		if (tirada > this.pe) {
			exito = false;
			pr = pr - dano;
			this.pr = pr;
		}
		esquiva = new Resultado(exito, tirada, pr);
		return esquiva;
	}

	public void incrementarPER() {
		per++;
	}

	@Override
	public String toString() {
		String cadena = "Luchador " + getNombre();
		if (!this.getEscuela().equals("Ninguna")) {
			cadena = cadena + ", de la escuela " + this.getEscuela();
		}
		cadena = cadena + "\n";
		cadena = cadena + "FUE = " + getFue() + ", ";
		cadena = cadena + "CON = " + getCon() + ", ";
		cadena = cadena + "TAM = " + getTam() + ", ";
		cadena = cadena + "DES = " + getDes() + ", ";
		cadena = cadena + "PER = " + getPer();
		cadena = cadena + "\n";
		cadena = cadena + "PR = " + getPr() + ", ";
		cadena = cadena + "PD = " + getPd() + ", ";
		cadena = cadena + "PA(%) = " + getPa() + ", ";
		cadena = cadena + "PE(%) = " + getPe();
		cadena = cadena + "\n";
		return cadena;
	}
}
