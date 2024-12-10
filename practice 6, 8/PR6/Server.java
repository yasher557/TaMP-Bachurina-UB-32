package PR6.PR6;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 7777;
    private static Set<Socket> clientSockets = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер работает на порту " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                synchronized (clientSockets) {
                    clientSockets.add(clientSocket);
                }
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = in.readLine()) != null) {
                    broadcastMessage(message, socket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientSockets) {
                    clientSockets.remove(socket);
                }
            }
        }

        private void broadcastMessage(String message, Socket senderSocket) {
            synchronized (clientSockets) {
                for (Socket socket : clientSockets) {
                    if (socket != senderSocket) {
                        try {
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            out.println(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
