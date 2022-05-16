import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int[] charFreq = new int[255];

        String text = "";

        Scanner scanner = new Scanner(new FileReader("file.txt"));
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            
            for (char c : next.toCharArray()) {
                charFreq[c]++;
            }

            text += next;
        }

        huffBTree tree = huffCodes.buildBTree(charFreq);

        System.out.println("Símbolo:\tQuantidade:\tCódigo:");
        huffCodes.printCode(tree, new StringBuffer());

        String encoded = huffCodes.encode(tree, text);
        System.out.println("\n\nCodificado:\n");
        System.out.println(encoded);

        String decoded = huffCodes.decode(tree, encoded);
        System.out.println("\n\nDescodificado:\n");
        System.out.println(decoded);

    }
}
