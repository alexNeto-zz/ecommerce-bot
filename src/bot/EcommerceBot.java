package bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import loja.comuns.Menu;

public class EcommerceBot extends TelegramLongPollingBot implements Token {

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
			String answer = null;

			if (call_data.equals("ver_produtos")) {
				answer = "vendo produtos lalalala";
			}
			if (call_data.equals("ver_carrinho")) {
				answer = "vendo carrinho lalalala";
			}

			EditMessageText new_message = new EditMessageText().setChatId(chat_id).setMessageId((int) (message_id))
					.setText(answer);
			try {
				editMessageText(new_message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String getBotToken() {
		return Token;
	}

}
