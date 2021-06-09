package br.financas.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_pessoa_fisica")
//@DiscriminatorValue("Pessoa Física")
public class PessoaFisica extends Cliente {
	private static final long serialVersionUID = 1L;
	
	@Column(name="cd_cpf", length = 14)
	private String cpf;
	@Column(name="nm_profissao", length = 30)
	private String profissao;
	
	public PessoaFisica() { }
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
}
