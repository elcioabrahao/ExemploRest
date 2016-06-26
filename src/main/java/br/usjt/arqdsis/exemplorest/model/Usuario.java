package br.usjt.arqdsis.exemplorest.model;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	
	private long id;
	private String nome;
	private int idade;
	private String email;
	private String senha;
	
	
	public Usuario(){
		
	}
	
	public Usuario(long id, String nome, int idade, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.senha = senha;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
