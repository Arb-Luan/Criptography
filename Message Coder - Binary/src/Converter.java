import java.util.Scanner;  // Classe que permite leitura de dados do teclado
import java.io.FileWriter;  // Classe que permite escrever no arquivo

public class Converter {
    public void converter(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, type a message to be coded into binary ^^: ");
        String message = scan.nextLine();
        scan.close();
        String binaryMessage = textToBin(message);
        saveToFile(binaryMessage, "message_encoded.txt");
        System.out.println("Binary message saved in 'message_encoded.txt'");
    }

    private String textToBin(String message) {
        StringBuilder bin = new StringBuilder();
        // A classe StringBuilder é mais eficiente na manipulação de texto em loops
        for (char c : message.toCharArray()) {
            // A escolha do for each: Ele percorre cada caractere da mensagem.
            bin.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0')).append("");
        }
        return bin.toString().trim();
    }

    // Função para salvar a mensagem binária no arquivo
    private void saveToFile(String message, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(message);
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

