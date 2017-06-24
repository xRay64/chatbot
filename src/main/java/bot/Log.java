package bot;

import org.telegram.telegrambots.api.objects.Update;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Антон on 11.06.2017.
 */
public class Log {
    private static String user_first_name;
    private static String user_last_name;
    private static String user_username;
    private static long user_id;
    private static String message_text;
    private static long chat_id;

    private static FileWriter fileWriter;

    static {
        try {
            fileWriter = new FileWriter(Options.getLogFile(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void logWrite(Update update) {
        user_first_name = update.getMessage().getChat().getFirstName();
        user_last_name = update.getMessage().getChat().getLastName();
        user_username = update.getMessage().getChat().getUserName();
        user_id = update.getMessage().getChat().getId();
        message_text = update.getMessage().getText();
        chat_id = update.getMessage().getChatId();
        //write log to file
        try {
            fileWriter.write("\n [INFO]");
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Date date = new Date();
            fileWriter.write(dateFormat.format(date));
            fileWriter.write(" Message from " + user_first_name + " " + user_last_name + " username = " + user_username +". (user_id = " + user_id + ") in chat_id = " + chat_id
                    + "\n Text: " + message_text);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void logAnswerWrite(String answer) {
        try {
            fileWriter.write("\n Bot answer: " + answer);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
