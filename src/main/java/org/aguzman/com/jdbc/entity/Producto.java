package org.aguzman.com.jdbc.entity;

import java.util.Date;

public class Producto {
	private Long id;
	private String nome;
	private Integer preco;
	private Date ficha_registro;

	@Override
	public String toString() {
		return  id + " | " + nome + " | " + preco + " | " + ficha_registro
				;
	}

	public Producto() {

	}

	public Producto(Long id, String nome, Integer preco, Date ficha_registro) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.ficha_registro = ficha_registro;
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

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	public Date getFicha_registro() {
		return ficha_registro;
	}

	public void setFicha_registro(Date ficha_registro) {
		this.ficha_registro = ficha_registro;
	}

}
