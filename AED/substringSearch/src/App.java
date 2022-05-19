import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        String pat;
        String txt;
        long tStart, tEnd, tResult;

        System.out.println("Digite o texto: ");
        txt = read.nextLine();
        System.out.println("Digite o padrao a ser encontrado no texto: ");
        pat = read.nextLine();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n============ Metodo Forca Bruta ============");

        tStart = System.currentTimeMillis();

        int offset = ForcaBruta.FB(pat, txt);
        if (offset == txt.length()) {
            System.out.println("Padrão não encontrado");
        } else {
            System.out.println("O padrao se encontra na posicao: " + offset);
        }

        tEnd = System.currentTimeMillis();

        tResult = (tEnd - tStart);
        System.out.println("Tempo de processamento: " + tResult + "ms");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\n\n============ Metodo KMP ============");

        tStart = System.currentTimeMillis();

        Kmp kmp = new Kmp(pat);
        offset = kmp.search(txt);
        if (offset == txt.length()) {
            System.out.println("Padrão não encontrado");
        } else {
            System.out.println("O padrao se encontra na posicao: " + offset);
        }

        tEnd = System.currentTimeMillis();

        tResult = (tEnd - tStart);
        System.out.println("Tempo de processamento: " + tResult + "ms\n");

        read.close();
    }
}
