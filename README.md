# Telegram Bot

Java Telegram bot examples built with the [TelegramBots](https://github.com/rubenlagus/TelegramBots) library.

## Bots

| Bot | Description |
|---|---|
| `CurrencyCommandsBot` | Converts amounts between USD, EUR, RUB, and BYN using live rates from the NBRB API |
| `MessageRepeaterBot` | Echoes every text message back to the sender |
| `SendOneMessageBot` | Sends a single message using `DefaultAbsSender` |

## Tech Stack

- Java 8+
- Gradle 9
- TelegramBots 5.3.0
- Lombok 1.18.20

## Setup

1. Copy `.env.example` to `.env` and fill in your values:

```bash
BOT_TOKEN=your_bot_token_here
BOT_USERNAME=@your_bot_username
CHAT_ID=your_chat_id_here
```

2. Export the variables before running:

```bash
export BOT_TOKEN=...
export BOT_USERNAME=...
export CHAT_ID=...
```

3. Build:

```bash
./gradlew build
```

4. Run the desired bot's `main` method:
   - `bot.telegramLongPollingBots.CurrencyCommandsBot`
   - `bot.telegramLongPollingBots.MessageRepeaterBot`
   - `bot.defaultabssenderbots.SendOneMessageBot`

Get a bot token from [@BotFather](https://t.me/BotFather).

## Currency Bot Commands

| Input | Result |
|---|---|
| `/set_currency` | Opens an inline keyboard to select original and target currencies |
| Any number | Converts it from the original currency to the target currency |

Exchange rates are fetched from the [NBRB API](https://www.nbrb.by/api/exrates/rates/).