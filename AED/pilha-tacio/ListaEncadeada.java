public class ListaEncadeada {

  private Element head;

  public final class Element {

    private Object data;
    private Element next;

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
  }

  public ListaEncadeada() {
    this.fazVazia();
  }

  public Element getHead() {
    return head;
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
