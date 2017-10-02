package loja.acesso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import loja.comuns.Usuarios;


public class Autenticacao {

	private ArrayList<Usuarios> usuarios;
	private String arquivo = "usuarios.ser";
	private Scanner scanner = new Scanner(System.in);
	

	public Autenticacao() {
		if (!ler()) {
			usuarios = new ArrayList<Usuarios>();
		}
	}

	@SuppressWarnings("unchecked")
	public boolean ler() {

		FileInputStream lerAquivos;
		try {
			lerAquivos = new FileInputStream(arquivo);
		} catch (FileNotFoundException e) {
			return false;
		}
		try (ObjectInputStream importarEstoque = new ObjectInputStream(lerAquivos)) {
			Object objeto = importarEstoque.readObject();
			usuarios = (ArrayList<Usuarios>) objeto;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean Login(String nomeUsuario, String senha) {
		for(Usuarios usuario:usuarios) {
			if(usuario.getNomeUsuario() == nomeUsuario) {
				if(usuario.getSenha() == senha)
					return true;
			}
		}
		System.out.println("Tem certeza que você existe?");
		return false;

	}

	public boolean SingUp(boolean gerente) {
		
		Usuarios usuario = new Usuarios();
		
		System.out.println("Digite o primeiro nome:");
		usuario.setPrimeiroNome(scanner.nextLine());
		
		System.out.println("Digite o ultimo nome:");
		usuario.setUltimoNome(scanner.nextLine());
		
		System.out.println("Digite o nome de usuário:");
		usuario.setNomeUsuario(scanner.nextLine());
		
		System.out.println("Digite o email:");
		usuario.setEmail(scanner.nextLine());
		
		System.out.println("Digite a senha:");
		usuario.setSenha(scanner.nextLine());
		
		usuario.setGerente(gerente);
		
		usuarios.add(usuario);
		
		return true;
	}

	public void salvar() {

		try (FileOutputStream salvaEstoque = new FileOutputStream(arquivo);
				ObjectOutputStream salvaConteudo = new ObjectOutputStream(salvaEstoque)) {
			salvaConteudo.writeObject(usuarios);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
