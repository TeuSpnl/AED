public class App {

  public static void main(String[] args) throws Exception {
    Node<Integer> arvore = new Node<Integer>(6);

    
    arvore.inserirOrdenado(3);
    arvore.inserirOrdenado(9);
    arvore.inserirOrdenado(8);
    arvore.inserirOrdenado(1);
    arvore.inserirOrdenado(2);
    arvore.inserirOrdenado(7);
    arvore.inserirOrdenado(91);
    arvore.imprimeInOrdem();
    System.out.println();
    arvore.imprimeDesOrdem();
    System.out.println("\nEm largura: ");
    
    FilaEncadeada f = new FilaEncadeada();

    f.enfileirar(arvore);
    System.out.println("Imprimindo em largura:");
    arvore.imprimeEmLarguraRecursivo(f);
    
    System.out.println("Imprimindo em largura inverso:");
    arvore.imprimeEmLarguraInverso();

    System.out.println("A altura da árvore é: " + arvore.calculaAltura());
  }
}
