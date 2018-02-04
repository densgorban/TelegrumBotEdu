import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class DenisTeachersBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if(message !=null && message.hasText()) {
            switch (message.getText()){
                case "-help": sendMessage(message, "How can I help you?"); break;
                case "Plan": sendMessage(message, getPlanMessage()); break;
                case "Lesson": sendMessage(message, getLessonMessage(message)); break;
                default: sendMessage(message,"default message");
            }
        }

    }

    /**
     * correct input: "Lesson N{1-6}
     * incorrect inputs
     *      Lesson 7
     *      Lesson  blabla
     *      Lesson
     * */
    private String getLessonMessage(Message message) {
        String[] splittedMessage = message.getText().split(" ");

        return
                "";
    }

    private String getPlanMessage() {
        return
                "Lesson 1: Install and Run Telegram Chat bot\n" +
                "Lesson 2: Investigate how Chat Bot Works\n" +
                "Lesson 3: What is Object Oriented Programming?\n" +
                "Lesson 4: Errors and Exceptions\n" +
                "Lesson 5: Data Stricture: List, Set, Map\n" +
                "Lesson 6: Questions & Answers\n"
                ;
    }

    void sendMessage(Message message , String text) {
        SendMessage s = new SendMessage();
        s.setChatId(message.getChatId()); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
        s.setText(text);
        try { //Чтобы не крашнулась программа при вылете Exception
            sendMessage(s);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return System.getProperty("bot.name");
    }

    @Override
    public String getBotToken() {
        return System.getProperty("bot.key");
    }

    public static void main(String[] args) {
        ApiContextInitializer.init(); // Инициализируем апи
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new DenisTeachersBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
