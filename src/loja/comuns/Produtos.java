package loja.comuns;

import java.io.Serializable;
import java.util.ArrayList;

public class Produtos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7133873416477191881L;
	private double preco;
	private int quantidade;
	private int quantidadeVendas = 0;
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

	public void menosUm() {
		this.quantidade--;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void maisUm() {
		this.setQuantidadeVendas(this.getQuantidadeVendas() + 1);
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

	public int getQuantidadeVendas() {
		return quantidadeVendas;
	}

	public void setQuantidadeVendas(int quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}

}
