package loja.comuns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3918306593880100848L;
	private Estoque estoque;
	private String arquivo = "estoque.ser";

	public AppMan() {
		if (!ler()) {
			estoque = new Estoque();
		}
	}

	public boolean ler() {

		FileInputStream lerAquivos;
		try {
			lerAquivos = new FileInputStream(arquivo);
		} catch (FileNotFoundException e) {
			return false;
		}
		try (ObjectInputStream importarEstoque = new ObjectInputStream(lerAquivos)) {
			Object objeto = importarEstoque.readObject();
			estoque =  (Estoque) objeto;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public ArrayList<String> categorias() {
		ArrayList<String> categorias = new ArrayList<>();

		for (Produtos produto : estoque.getEstoque()) {
			if (categorias.contains(produto.getCategoria())) {
				continue;
			}
			categorias.add(produto.getCategoria());
		}
		return categorias;
	}

	public String categorias(Scanner scanner) {

		System.out.println("1 - Arduino");
		System.out.println("2 - Raspberry");
		System.out.println("3 - Componentes Ativos");
		System.out.println("4 - Componentes Passivos");
		String cat = scanner.nextLine();
		int categoria = 0;
		try {
			categoria = Integer.parseInt(cat);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		switch (categoria) {
		case 1:
			return "arduino";
		case 2:
			return "raspberry";
		case 3:
			return "comp_at";
		case 4:
			return "comp_pa";
		default:
			return null;
		}
	}

	public void adicionarProduto() {
		Scanner scanner = new Scanner(System.in);
		Produtos produto = new Produtos();

		System.out.println("Digite o preço:");
		String preco = scanner.nextLine();
		try {
			produto.setPreco(Double.parseDouble(preco));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		System.out.println("Digite a quantidade:");
		String quantidade = scanner.nextLine();
		try {
			produto.setQuantidade(Integer.parseInt(quantidade));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		System.out.println("Escolha uma categoria: ");
		String categoria = categorias(scanner);
		produto.setCategoria(categoria);

		System.out.println("Digite o nome do produto:");
		produto.setNome(scanner.nextLine());

		System.out.println("Digite uma breve descrição do produto:");
		produto.setDescrição(scanner.nextLine());

		estoque.setEstoque(produto);
		salvar();
		scanner.close();

	}
	
	public void salvar() {
		try (FileOutputStream salvaEstoque = new FileOutputStream(arquivo);
				ObjectOutputStream salvaConteudo = new ObjectOutputStream(salvaEstoque)) {
			salvaConteudo.writeObject(estoque);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}