package loja.comuns;

import java.util.ArrayList;

public class Produtos {
	
	private double preco;
	private int quantidade;
	private String nome;
	private String descrição;
	private String categoria;
	private ArrayList<Comentarios> comentarios;
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public ArrayList<Comentarios> getComentarios() {
		return comentarios;
	}
	public void setComentarios(ArrayList<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
