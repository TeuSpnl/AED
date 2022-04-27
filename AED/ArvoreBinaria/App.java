import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Node<Integer> tree = new Node<Integer>(6);

    Scanner scan = new Scanner(System.in);

    System.out.println("Digite uma frase.");

    String text = scan.nextLine();
    text = text.toUpperCase();

    System.out.println(text);
    tree.getFrequencia(text);

    scan.close();

    
    // tree.inserirOrdenado(3);
    // tree.inserirOrdenado(9);
    // tree.inserirOrdenado(8);
    // tree.inserirOrdenado(1);
    // tree.inserirOrdenado(2);
    // tree.inserirOrdenado(7);
    // tree.inserirOrdenado(91);
    // tree.imprimeInOrdem();
    // System.out.println();
    // tree.imprimeDesOrdem();
    // System.out.println("\nEm largura: ");
    
    // FilaEncadeada f = new FilaEncadeada();

    // f.enfileirar(tree);
    // System.out.println("Imprimindo em largura:");
    // tree.imprimeEmLarguraRecursivo(f);
    
    // System.out.println("Imprimindo em largura inverso:");
    // tree.imprimeEmLarguraInverso();

    // System.out.println("A altura da árvore é: " + tree.calculaAltura());
  }
}
