package loja.comuns;

import java.io.Serializable;
import java.util.ArrayList;

public class Carrinho implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2945961068642949168L;
	private ArrayList<Produtos> comprados = new ArrayList<>();

	public ArrayList<Produtos> getComprados() {
		return comprados;
	}

	public void setComprados(Produtos comprados) {
		this.comprados.add(comprados);
	}
	
	
	
	

}
