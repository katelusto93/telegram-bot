package bot.defaultAbsSenderBots;

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
        return System.getenv("BOT_TOKEN");
    }

    public static void main(String[] args) throws TelegramApiException {
        SendOneMessageBot bot = new SendOneMessageBot(new DefaultBotOptions());
        bot.execute(SendMessage.builder().chatId(System.getenv("CHAT_ID")).text("Hello World from Java").build());
    }
}
