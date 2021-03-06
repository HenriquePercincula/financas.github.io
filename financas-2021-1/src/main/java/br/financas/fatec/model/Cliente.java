package br.financas.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="tb_cliente")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "nm_pertence a classe", length = 28)
public abstract class Cliente extends AbstractEntity {
	 private static final long serialVersionUID = 1L;
	 @Column(name="nm_nome", length=60)
	 private String nome;
	 @Column(name="ds_endereco", length=120)
	 private String endereco;
	 
	 public Cliente() {}
	 	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	 
	 
}
