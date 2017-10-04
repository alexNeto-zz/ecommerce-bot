package loja.comuns;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class Menu {

	public InlineKeyboardMarkup principal() {
		InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

		List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
		List<InlineKeyboardButton> rowInline = new ArrayList<>();
		rowInline.add(new InlineKeyboardButton().setText("Ver Produtos").setCallbackData("ver_produtos"));
		rowInline.add(new InlineKeyboardButton().setText("Ver Carrinho").setCallbackData("ver_carrino"));

		rowsInline.add(rowInline);

		markupInline.setKeyboard(rowsInline);
		return markupInline;
	}
	
	public InlineKeyboardMarkup produtos() {
		InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

		List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
		List<InlineKeyboardButton> rowInline = new ArrayList<>();
		rowInline.add(new InlineKeyboardButton().setText("Arduinos").setCallbackData("ver_produtos"));
		rowInline.add(new InlineKeyboardButton().setText("Raspberries").setCallbackData("ver_carrino"));

		rowsInline.add(rowInline);

		markupInline.setKeyboard(rowsInline);
		return markupInline;
	}

	static void itens() {
		System.out.println("1 - Ver produtos");
		System.out.println("2 - Login");
		System.out.println("3 - Registrar");
		System.out.println("4 - Sair");
	}

}
