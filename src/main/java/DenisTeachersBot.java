import com.sun.javafx.geom.transform.CanTransformVec3d;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import study.oop.HeavyAuto;

public class DenisTeachersBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if(message !=null && message.hasText()) {
            String messageText = message.getText().trim().toLowerCase();

            if(messageText.equals("-help")){
                sendMessage(message,  "How can I help you?");
            } else if(messageText.equals("plan")){
                sendMessage(message, getPlanMessage());
            } else if(messageText.contains("lesson")){
                sendMessage(message, getLessonMessage(message));
            } else {
                sendMessage(message,"default message");
            }

//            switch (message.getText()){
//                case "-help": sendMessage(message,
//                        "How can I help you?"); break;
//                case "Plan": sendMessage(message, getPlanMessage()); break;
//                case "Lesson": sendMessage(message, getLessonMessage(message)); break;
//                default: sendMessage(message,"default message");
            }
        }



    private String getLessonMessage(Message message) {
        String[] splittedMessage = message.getText().split(" ");
        int lessonNumber = 0;
        try {
            lessonNumber = Integer.parseInt(splittedMessage[1]);
        } catch(NumberFormatException nfe){
            System.out.println(nfe);
            return "Error on parsing integer";
        }
        switch(lessonNumber) {
            case 1: return "Install and Run Telegram Chat bot";
            case 2: return "Investigate how Chat Bot Works";
            case 3: return "What is Object Oriented Programming?";
            case 4: return "Errors and Exceptions";
            case 5: return "Data Stricture: List, Set, Map";
            case 6: return "Questions & Answers";
            default: return "Please enter correct number";
        }
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
            sendApiMethod(s);
        } catch (TelegramApiException e){
            System.out.println("TelegramApiException block");
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "denis_teacher_bot";
    }

    @Override
    public String getBotToken() {
        return "473102786:AAEA8DWzRuo09esFTvDoTgt6S8SXgu0OqiY";
    }

    //Enter point
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
