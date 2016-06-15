package br.com.agricopias.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity
@Table(name="USUARIO")
@PrimaryKeyJoinColumn(name="id_pessoa_fisica")
@NamedQueries({
	@NamedQuery(name="Usuario.pesquisarTodos", 
				query="SELECT o FROM Usuario o " +
				      " WHERE (o.excluido = false OR o.excluido IS NULL)"),
				
	@NamedQuery(name="Usuario.pesquisarPorLogin",
				query="SELECT o FROM Usuario o" +
					  " WHERE o.login = :login " +
					  " AND (o.excluido = false OR o.excluido IS NULL)"),
					  
	@NamedQuery(name="Usuario.pesquisarPorLoginSenha",
				query="SELECT o FROM Usuario o" +
					  " WHERE o.login = :login " +
					  " AND o.senha = :senha " +
					  " AND (o.excluido = false OR o.excluido IS NULL)")
})
public class Usuario extends PessoaFisica 
	implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Informe o login")
	@NotNull(message="Informe o login")
	private String login;
	
	@NotEmpty(message="Informe a senha")
	@NotNull(message="Informe a senha")
	private String senha;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
}
