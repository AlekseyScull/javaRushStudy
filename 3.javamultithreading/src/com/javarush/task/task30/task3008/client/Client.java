package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        new Client().run();
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " joined");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " leaving");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while(true) {
                Message message = connection.receive();
                if (message != null) {
                    if (message.getType() == MessageType.NAME_REQUEST) {
                        connection.send(new Message(MessageType.USER_NAME, getUserName()));
                    } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                        notifyConnectionStatusChanged(true);
                        return;
                    } else {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while(true) {
                Message message = connection.receive();
                if (message != null) {
                    if (message.getType() == MessageType.TEXT) {
                        processIncomingMessage(message.getData());
                    } else if (message.getType() == MessageType.USER_ADDED) {
                        informAboutAddingNewUser(message.getData());
                    } else if (message.getType() == MessageType.USER_REMOVED) {
                        informAboutDeletingNewUser(message.getData());
                    } else {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }

        public void run() {
            try (Socket socket = new Socket(getServerAddress(), getServerPort())) {
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    protected String getServerAddress() throws IOException {
        System.out.print("Input server address: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException {
        System.out.print("Input server port: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException {
        System.out.print("Input your name: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException ex) {
            ConsoleHelper.writeMessage("Unable to send message, connection drop");
            clientConnected = false;
        }
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }

            notify();
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента!");
        }
        while (clientConnected) {
            String text = ConsoleHelper.readString();
            if (text.equals("exit")) {
                break;
            }
            if (shouldSendTextFromConsole()) sendTextMessage(text);
        }
    }
}
