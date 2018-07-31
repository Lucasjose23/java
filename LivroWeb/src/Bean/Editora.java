package Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="editora")
public class Editora {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEditora;
	
	

	@Column(length = 60, nullable=false)
	private String nome;
	
	@Column(length = 60, nullable=false)
	private String campo2;
	
	public Editora(Integer idEditora, String nome, String campo2) {
		super();
		this.idEditora = idEditora;
		this.nome = nome;
		this.campo2 = campo2;
	}

	public Editora() {
		super();
	}

	public Integer getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(Integer idEditora) {
		this.idEditora = idEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCampo2() {
		return campo2;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}
	
	

}
