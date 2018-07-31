package Bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="capitulo")
public class Capitulo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCap;
	

	private String titulo;
	
	private int inicioPagina;
	
	private int fimPagina;
	
	

	public Capitulo() {
		
	}

	public Capitulo(String titulo, int inicioPagina, int fimPagina) {
		super();
		this.titulo = titulo;
		this.inicioPagina = inicioPagina;
		this.fimPagina = fimPagina;
	}

	public Integer getIdCap() {
		return idCap;
	}

	public void setIdCap(Integer idCap) {
		this.idCap = idCap;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getInicioPagina() {
		return inicioPagina;
	}

	public void setInicioPagina(int inicioPagina) {
		this.inicioPagina = inicioPagina;
	}

	public int getFimPagina() {
		return fimPagina;
	}

	public void setFimPagina(int fimPagina) {
		this.fimPagina = fimPagina;
	}
	
	
	

}
