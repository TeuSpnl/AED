public class Node<T> {

  private T value;
  private Node<T> lChild, rChild;

  public Node(T v) {
    value = v;
    lChild = null;
    rChild = null;
  }

  public Node(T v, Node<T> lChild, Node<T> rChild) {
    value = v;
    this.lChild = lChild;
    this.rChild = rChild;
  }

  public void inserirOrdenado(T v) {
    if (v.toString().compareTo(this.getValue().toString()) < 0) { // menor
      if (this.getLChild() != null) {
        this.getLChild().inserirOrdenado(v);
      } else {
        Node<T> n = new Node<T>(v);
        this.setLChild(n);
      }
    } else { // maior ou igual
      if (this.getRChild() != null) {
        this.getRChild().inserirOrdenado(v);
      } else {
        Node<T> n = new Node<T>(v);
        this.setRChild(n);
      }
    }
  }

  public void imprimeInOrdem() {
    if (this.getLChild() != null) {
      this.getLChild().imprimeInOrdem();
    }

    System.out.print(this.value + " "); // visita o no

    if (this.getRChild() != null) {
      this.getRChild().imprimeInOrdem();
    }
  }

  public void imprimeDesOrdem() {
    if (this.getRChild() != null) {
      this.getRChild().imprimeDesOrdem();
    }

    System.out.print(this.value + " "); // visita o no

    if (this.getLChild() != null) {
      this.getLChild().imprimeDesOrdem();
    }
  }

  // Gets and Sets
  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getLChild() {
    return lChild;
  }

  public void setLChild(Node<T> lChild) {
    this.lChild = lChild;
  }

  public Node<T> getRChild() {
    return rChild;
  }

  public void setRChild(Node<T> rChild) {
    this.rChild = rChild;
  }

  // calcular o comprimento do caminho entre dois nos
  // calcular altura de um node
  // verificar se um node é interno ou externo
  // calcular a profundidade de um node

  protected void imprimeEmLarguraRecursivo(iFila f) {
    if (!f.estaVazia()) {
      Node<T> no = (Node<T>) f.desenfileirar();

      if (no != null) {
        if (no.getLChild() != null) {
          f.enfileirar(no.getLChild());
        }
        if (no.getRChild() != null) {
          f.enfileirar(no.getRChild());
        }
        System.out.println(no.getValue());

        this.imprimeEmLarguraRecursivo(f);
      }
    }
  }

  protected void imprimeEmLarguraInverso() {
    FilaEncadeada f = new FilaEncadeada();
    java.util.Stack<String> pl = new java.util.Stack<String>();

    f.enfileirar(this);

    while (!f.estaVazia()) {
      Node<T> no = (Node<T>) f.desenfileirar();

      if (no.getLChild() != null) {
        f.enfileirar(no.getLChild());
      }
      if (no.getRChild() != null) {
        f.enfileirar(no.getRChild());
      }

      pl.push(no.getValue().toString());
    }
  }

  protected int calculaAltura() {
    int alturaE = 0;
    int alturaD = 0;

    if (this.getLChild() != null) {
      alturaE = this.getLChild().calculaAltura() + 1;
    }
    if (this.getRChild() != null) {
      alturaD = this.getRChild().calculaAltura() + 1;
    }

    if (alturaE > alturaD) {
      return alturaE;
    }
    return alturaD;
  }

  protected int calculaAlturaEmLargura() {
    FilaEncadeada f = new FilaEncadeada();
    FilaEncadeada dist = new FilaEncadeada();

    f.enfileirar(this);

    int altura_maxima = 0;

    while (!f.estaVazia()) {
      Node<T> no = (Node<T>) f.desenfileirar();
      int dist_pai = (int) dist.desenfileirar();

      if (no.getLChild() != null) {
        f.enfileirar(no.getLChild());
        dist.enfileirar(dist_pai + 1);
      }
      if (no.getRChild() != null) {
        f.enfileirar(no.getRChild());
        dist.enfileirar(dist_pai + 1);
      }

      if (dist_pai > altura_maxima) {
        altura_maxima = dist_pai;
      }

    }
    return altura_maxima;
  }

  public int[] getFrequencia(String text) {
    int[] freq = new int[255];

    for (int i = 0; i < text.length(); i++) {
      char[] character = new char[text.length()];
      character[i] = text.charAt(i);

      freq[(int) character[i]]++;
    }

    return freq;
  }

  // public boolean eAVL(){
  //   if(-(this.lChild.altura()) + this.rChild.altura() > 1 || -(this.lChild.altura()) + this.rChild.altura() < -1){
  //     return false;
  //   }
  //   else if(this.lChild.eAVL() == false || this.rChild.eAVL() == false){
  //     return false;
  //   }

  //   return true;
  // }

}
