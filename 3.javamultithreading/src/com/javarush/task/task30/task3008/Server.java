package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Server started...");
            while (true) {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException ex) {
                ConsoleHelper.writeMessage("Fail to send message");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String userName;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    userName = message.getData();
                    if (userName != null && !connectionMap.containsKey(userName) && !userName.equals("")) {
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        break;
                    }
                }
            }
            return userName;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!userName.equals(entry.getKey())) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, String.format("%s: %s", userName, message.getData())));
                } else {
                    ConsoleHelper.writeMessage("Error");
                }
            }
        }

        public void run() {
            ConsoleHelper.writeMessage("New connection " + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException ex) {
                ConsoleHelper.writeMessage("Remote address communication error");
            }
            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            ConsoleHelper.writeMessage("Connection down");
        }
    }
}
