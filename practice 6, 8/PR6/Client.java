package PR6.PR6;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 7777;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            JFrame frame = new JFrame("Клиент");
            JTextArea textArea = new JTextArea(20, 50);
            JTextField textField = new JTextField(40);

            textArea.setEditable(false);
            frame.getContentPane().add(new JScrollPane(textArea), "Center");
            frame.getContentPane().add(textField, "South");
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            textField.addActionListener(e -> {
                String message = textField.getText();
                if (!message.trim().isEmpty()) {
                    out.println(message);
                    textArea.append("Вы: " + message + "\n");
                    textField.setText("");
                }
            });

            String message;
            while ((message = in.readLine()) != null) {
                textArea.append("Собеседник: " + message + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}