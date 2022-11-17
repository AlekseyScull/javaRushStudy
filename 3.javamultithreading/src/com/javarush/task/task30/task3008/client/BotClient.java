package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public static void main(String[] args) {
        new BotClient().run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.contains(": ")) {
                String[] strings = message.split(": ");
                String userName = strings[0];
                String userMessage = strings[1].trim();
                Date date = Calendar.getInstance().getTime();
                String pattern = "";
                switch (userMessage) {
                    case "дата":
                        pattern = "d.MM.YYYY";
                        break;
                    case "день":
                        pattern = "d";
                        break;
                    case "месяц":
                        pattern = "MMMM";
                        break;
                    case "год":
                        pattern = "YYYY";
                        break;
                    case "время":
                        pattern = "H:mm:ss";
                        break;
                    case "час":
                        pattern = "H";
                        break;
                    case "минуты":
                        pattern = "m";
                        break;
                    case "секунды":
                        pattern = "s";
                }
                if (!pattern.equals("")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    sendTextMessage(String.format("Информация для %s: %s", userName, simpleDateFormat.format(date)));
                }
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

    @Override
    protected String getUserName() throws IOException {
        return String.format("date_bot_%d", (int) (Math.random() * 100));
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }
}
