package service.telegramLongPollingBots;

import entity.Currency;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CurrencyCommandsBot extends TelegramLongPollingBot {
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
            try {
                handleMessage(update.getMessage());
            } catch (TelegramApiException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void handleMessage(Message message) throws TelegramApiException {
        //handle command
        if(message.hasText() && message.hasEntities()){
            Optional<MessageEntity> commandEntity = message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
            if (commandEntity.isPresent()){
                String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                switch (command){
                    case "/set_currency":
                        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
                        for (Currency currency : Currency.values()){
                            buttons.add(Arrays.asList(
                                    InlineKeyboardButton.builder()
                                    .text(currency.name())
                                    .callbackData("ORIGINAL: " + currency)
                                    .build(),
                                    InlineKeyboardButton.builder()
                                            .text(currency.name())
                                            .callbackData("TARGET: " + currency)
                                            .build()));
                        }
                        execute(
                                SendMessage.builder()
                                        .chatId(String.valueOf(message.getChatId()))
                                        .text("Please choose Original and Target currencies")
                                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build())
                                        .build());
                        break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CurrencyCommandsBot bot = new CurrencyCommandsBot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }
}

