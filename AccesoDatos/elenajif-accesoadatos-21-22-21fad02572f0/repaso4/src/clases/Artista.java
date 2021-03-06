package clases;

public class Artista extends Personal {

	private static final long serialVersionUID = 1L;
	private String estiloMusica;
	private Float cache;

	public Artista(String dni, String nombre, String estiloMusica, Float cache) {
		super(dni, nombre);
		this.estiloMusica = estiloMusica;
		this.cache = cache;
	}

	public String getEstiloMusica() {
		return estiloMusica;
	}

	public void setEstiloMusica(String estiloMusica) {
		this.estiloMusica = estiloMusica;
	}

	public Float getCache() {
		return cache;
	}

	public void setCache(Float cache) {
		this.cache = cache;
	}

	@Override
	public int compareTo(Personal o) {
		return getDni().compareTo(o.getDni());
	}

	@Override
	public String toString() {
		return super.toString() + "Artista [estiloMusica=" + estiloMusica + ", cache=" + cache + "]";
	}
}
