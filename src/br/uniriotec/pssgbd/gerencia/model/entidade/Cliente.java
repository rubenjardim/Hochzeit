package br.uniriotec.pssgbd.gerencia.model.entidade;

public class Cliente extends BaseEntity{
	
	private Long id;
	private String nome;
	private Cidade cidade;
	private String sexo;
	
	public String getSexo() {
		return sexo;
	}
	public String getSexoFormatado() {
		return sexo.equals("M") ? "Masculino" : "Feminino";
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Cliente))
			return false;
		
		//TODO descomentar qdo conectar o BD
		//return ((Cliente)obj).getId() != null && ((Cliente)obj).getId().equals(this.id) ? true : false;
		
		return true;
	}
}
