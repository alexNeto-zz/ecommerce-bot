package bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import loja.comuns.AppMan;
import loja.comuns.Carrinho;
import loja.comuns.Menu;
import loja.comuns.Produtos;

public class EcommerceBot extends TelegramLongPollingBot implements Token {

	private AppMan app = new AppMan();
	private Carrinho carrinho = new Carrinho();
	Produtos compra = null;

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "trabalho1ecommerceBot";
	}

	@SuppressWarnings({ "deprecation" })
	@Override
	public void onUpdateReceived(Update update) {

		if (update.hasMessage() && update.getMessage().hasText()) {
			// String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();
			if (update.getMessage().getText().equals("/start")) {
				SendMessage message = new SendMessage().setChatId(chat_id).setText("Você enviou /start");
				message.setReplyMarkup(new Menu().principal());
				try {
					sendMessage(message); // Sending our message object to user
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else if (update.getMessage().getText().equals("")) {
			} else {

			}

		} else if (update.hasCallbackQuery()) {
			
			String call_data = update.getCallbackQuery().getData();
			long message_id = update.getCallbackQuery().getMessage().getMessageId();
			long chat_id = update.getCallbackQuery().getMessage().getChatId();
			String answer = "algo";
			
			if (call_data.equals("ver_produtos")) {
				answer = "opa! agora escolha uma categoria";
				SendMessage message = new SendMessage().setChatId(chat_id).setText("Você enviou /start");
				message.setReplyMarkup(new Menu().produtos());
				try {
					sendMessage(message); // Sending our message object to user
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			if (call_data.equals("ver_carrinho")) {
				answer = "vendo carrinho lalalala";
				StringBuilder display = new StringBuilder();
				display.append("Lista de produtos no carrinho:\n");
				for (Produtos produto : carrinho.getComprados()) {
					display.append(produto.getNome()).append("\tR$: ").append(produto.getPreco()).append("\n");
				}
						
				SendMessage message = new SendMessage().setChatId(chat_id).setText(display.toString());
				try {
					sendMessage(message); // Sending our message object to user
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}

			}
			if (call_data.equals("arduino")) {
				answer = "você está vendo arduinos";
				showCallBack(call_data, chat_id);
			}
			if (call_data.equals("raspberry")) {
				answer = "você está vendo raspberies";
				showCallBack(call_data, chat_id);
			}
			if (call_data.equals("comp_at")) {
				answer = "você está vendo componentes ativos";
				showCallBack(call_data, chat_id);
			}
			if (call_data.equals("comp_pa")) {
				answer = "você está vendo componentes passivos";
				showCallBack(call_data, chat_id);
			}
			for (Produtos produto : app.getEstoque()) {
				if (call_data.equals(produto.getNome())) {
					StringBuilder display = new StringBuilder();
					display.append(produto.getNome()).append("\nR$: ").append(produto.getPreco()).append("\t")
							.append(produto.getQuantidade()).append(" unidades\n").append(produto.getDescrição())
							.append("\n\n");
					compra = produto;
					if (produto.getComentarios() == null) {
						display.append("ainda não tem comentários para esse produto, seja o primeiro!");
					} else {
						display.append(produto.getComentarios());
					}
					answer = display.toString();
					SendMessage message = new SendMessage().setChatId(chat_id)
							.setText("Todos produtos para essa seleção");
					message.setReplyMarkup(new Menu().comprar());
					try {
						sendMessage(message); // Sending our message object to user
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
			}

			if (call_data.equals("comprar")) {
				answer = "Compra realizada com sucesso";
				if (compra != null) {
					carrinho.setComprados(compra);
					app.compra(compra);
					SendMessage message = new SendMessage().setChatId(chat_id).setText("Você enviou /start");
					message.setReplyMarkup(new Menu().produtos());
					try {
						sendMessage(message); // Sending our message object to user
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void showCallBack(String call_data, long chat_id) {
		SendMessage message = new SendMessage().setChatId(chat_id).setText("Todos produtos para essa seleção");
		message.setReplyMarkup(new Menu().itens(call_data));
		try {
			sendMessage(message); // Sending our message object to user
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBotToken() {
		return Token;
	}

}
