public class ListaEncadeada {

  private Element head;
  private Element tail;

  public final class Element {

    Object data;
    Element next;

    Element(Object d, Element n) {
      data = d;
      next = n;
    }

    public Object getData() {
      return data;
    }

    public Element getNext() {
      return next;
    }
  }

  public void fazVazia() {
    head = null;
    tail = null;
  }

  public ListaEncadeada() {
    this.fazVazia();
  }

  public Element getHead() {
    return head;
  }

  public Element getTail(){
    return tail;
  }

  public boolean estaVazia() {
    return (head == null);
  }

  public Object getPrimeiro() throws ListaVaziaException {
    if (head == null) throw new ListaVaziaException();
    return head.data;
  }

  public void inserirInicio(Object item) {
    Element temp = new Element(item, head);

    if (head == null) {}
    head = temp;
  }

  public void inserirFim(Object item){
    Element temp = new Element(item, null);

    if (head == null){
      head = temp;
    } else {
      tail.next = temp;
    }
    tail = temp;
  }

  public void extrair(Object item) {
    Element ptr = head;
    Element prevPtr = null;

    while (ptr != null && ptr.data != item) {
      prevPtr = ptr;
      ptr = ptr.next;
    }

    if (ptr == head) {
      head = ptr.next;
    } else {
      prevPtr.next = ptr.next;
    }
  }
}
