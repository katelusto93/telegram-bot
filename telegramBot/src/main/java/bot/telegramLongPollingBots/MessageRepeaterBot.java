package bot.telegramLongPollingBots;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MessageRepeaterBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "@katsiaryna_test_bot";
    }

    @Override
    public String getBotToken() {
        return "1965488089:AAFZcboMaLd9XB2eXyQvVyqsF3L7ircqCZ0";
    }

    @Override
    public void onUpdateReceived (Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            if (message.hasText()){
                try {
                    execute(
                            SendMessage.builder()
                                    .chatId(String.valueOf(message.getChatId()))
                                    .text("You sent: \n\n" + message.getText())
                                    .build());
                } catch (TelegramApiException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        MessageRepeaterBot bot = new MessageRepeaterBot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }
}
