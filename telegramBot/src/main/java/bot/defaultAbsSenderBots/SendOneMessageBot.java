package bot.defaultAbsSenderBots;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendOneMessageBot extends DefaultAbsSender {
    protected SendOneMessageBot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotToken() {
        return "1965488089:AAFZcboMaLd9XB2eXyQvVyqsF3L7ircqCZ0";
    }

    public static void main(String[] args) throws TelegramApiException {
        SendOneMessageBot bot = new SendOneMessageBot(new DefaultBotOptions());
        bot.execute(SendMessage.builder().chatId("195225060").text("Hello World from Java").build());
    }
}
