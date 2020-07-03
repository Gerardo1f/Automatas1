package Compilador;

public class Identificador{
	String Nombre;
	String Valor;
	String Tipo;

	public Identificador(String nombre, String valor, String tipo) {
		super();
		this.Nombre = nombre;
		this.Valor = valor;
		this.Tipo = tipo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		this.Valor = valor;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		this.Tipo = tipo;
	}

}
