package bot;

import java.util.Scanner;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import loja.comuns.AppMan;

public class Main {

	/**
	 * TODO- list Comentar o código deixar mais fácio de usar organizar o código
	 * 
	 */

	public static void main(String[] args) {

		int escolha = 0;
		while (escolha != -1) {
			System.out.println("1 - Gerenciar estoque\n" + "2 - Rodar bot\n");
			Scanner scanner = new Scanner(System.in);
			escolha = scanner.nextInt();

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

		while (true) {
			System.out.println("Qual a ação desejada:");
			System.out.println("1 - Adicionar Produto");
			System.out.println("2 - Adicionar Quantidade ao produto [em breve]");
			System.out.println("3 - Editar produto [em breve]");
			System.out.println("4 - Deletar produto [em breve]");
			System.out.println("5 - Exibir relatório");
			System.out.println("6 - Sair");
			int escolha = scanner.nextInt();
			switch (escolha) {
			case 1:
				app.adicionarProduto();
				break;
			case 5:
				app.relatorio();
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Ainda não temos essa opção");
				break;
			}
		}
	}
}
