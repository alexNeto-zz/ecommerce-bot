package bot;

import java.util.Scanner;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import loja.comuns.AppMan;

public class Main {

	
	
	public static void main(String[] args) {

		System.out.println("1 - Gerenciar estoque\n" + "2 - Rodar bot\n");
		Scanner scanner = new Scanner(System.in);
		int escolha = scanner.nextInt();
		switch (escolha) {
		case 1:
			gerenciaEstoque(scanner);
			break;
		case 2:
			scanner.close();
			System.out.println("Servidor rodando...");
			rodaServer();
			break;
		default:
			break;
		}
	}
	
	public static void rodaServer() {
		ApiContextInitializer.init();

		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			botsApi.registerBot(new EcommerceBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	public static void gerenciaEstoque(Scanner scanner) {
		AppMan app = new AppMan();
		System.out.println("Qual a ação desejada:");
		System.out.println("1 - Adicionar Produto");
		System.out.println("2 - Adicionar Quantidade ao produto");
		System.out.println("3 - Editar produto");
		System.out.println("4 - Deletar produto");
		int escolha = scanner.nextInt();
		switch (escolha) {
		case 1:
			app.adicionarProduto();
			break;

		default:
			break;
		}
		
	}
}
