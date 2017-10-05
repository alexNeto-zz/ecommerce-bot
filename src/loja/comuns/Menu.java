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
		rowInline.add(new InlineKeyboardButton().setText("Ver Carrinho").setCallbackData("ver_carrinho"));

		rowsInline.add(rowInline);

		markupInline.setKeyboard(rowsInline);
		return markupInline;
	}

	public InlineKeyboardMarkup produtos() {
		InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

		List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
		List<InlineKeyboardButton> rowInline;

		for (String categoria : new AppMan().categorias()) {
			rowInline = new ArrayList<>();
			rowInline.add(new InlineKeyboardButton().setText(categoria).setCallbackData(categoria));
			rowsInline.add(rowInline);
		}

		markupInline.setKeyboard(rowsInline);
		return markupInline;
	}

	public InlineKeyboardMarkup itens(String categoria) {
		InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

		List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
		List<InlineKeyboardButton> rowInline = new ArrayList<>();

		int i = 0;
		for (Produtos produto : new AppMan().getEstoque()) {
			if (produto.getCategoria().equals(categoria)) {
				StringBuilder display = new StringBuilder();
				display.append(produto.getNome()).append("\tR$: ").append(produto.getPreco());
				rowInline
						.add(new InlineKeyboardButton().setText(display.toString()).setCallbackData(produto.getNome()));
				if (i % 2 == 0 || i == 0) {
					rowsInline.add(rowInline);
					rowInline = new ArrayList<>();
				}
			}
			i++;
		}

		markupInline.setKeyboard(rowsInline);
		return markupInline;
	}

	public InlineKeyboardMarkup comprar() {
		InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

		List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
		List<InlineKeyboardButton> rowInline = new ArrayList<>();

		rowInline.add(new InlineKeyboardButton().setText("Comprar").setCallbackData("comprar"));
		rowInline.add(new InlineKeyboardButton().setText("Voltar").setCallbackData("ver_produtos"));

		rowsInline.add(rowInline);

		markupInline.setKeyboard(rowsInline);
		return markupInline;
	}
}
