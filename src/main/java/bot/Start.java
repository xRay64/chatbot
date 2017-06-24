package bot;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 13.06.2017.
 */
class Start {
    private static SendMessage toReturn;
    private static InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
    private static List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
    private static List<InlineKeyboardButton> rowInline = new ArrayList<>();

    static SendMessage init(long chatId) {
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode("Квартиру :door:")).setCallbackData("flat"));
        rowInline.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode("Дом :house:")).setCallbackData("house"));
        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);
        toReturn = new SendMessage()
                .setChatId(chatId)
                .setText("Добавить в базу")
                .setReplyMarkup(markupInline);

        return toReturn;
    }
}
