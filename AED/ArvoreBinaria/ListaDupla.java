public class ListaDupla<T> {

    private Element<T> head;

    public ListaDupla() {
        this.fazVazia();
    }

    public final class Element<K> {

        K data;
        public Element<K> next, prev;

        Element(K data, Element<K> next, Element<K> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public K getData() {
            return data;
        }

        public Element<K> getNext() {
            return next;
        }

        public Element<K> getPrev() {
            return prev;
        }

        public void inserirDepois(Object item) {

            this.next = new Element(item, this.next, this);
        }

        public void inserirAntes(Object item) {

            Element<K> temp = new Element(item, this, this.prev);

            if (this == head) {
                head = (ListaDupla<T>.Element<T>) temp;
            } else {
                Element<K> prevPtr = (ListaDupla<T>.Element<K>) head;
                while (prevPtr != null && prevPtr.next != this) {
                    prevPtr = prevPtr.next;
                }

                prevPtr.next = temp;
            }
        }

    }

    public void fazVazia() {
        head = null;
    }

    public Element<T> getHead() {
        return head;
    }

    public boolean estaVazia() {
        return (head == null);
    }

    public Object getPrimeiro() throws ListaVaziaException {

        if (head == null)
            throw new ListaVaziaException();
        return head.data;

    }

    public Object getUltimo() throws ListaVaziaException {
        if (head.prev == null)
            throw new ListaVaziaException();
        return head.prev.data;

    }

    public void inserirInicio(T conteudo) {
        Element<T> temp = new Element(conteudo, head, head.prev);

        if (head == null) {
            head = temp;
            head.prev = temp;
        } else {
            head.prev = temp;
            head = temp;
            head.prev.next = temp;
        }

    }

    public void inserirFim(T item) {

        Element<T> temp = new Element(item, head, head.prev);

        if (head == null) {
            head = temp;
            head.prev = temp;
        } else {
            head.prev.next = temp;
            head.prev = temp;
        }
    }

    public void atribuir(ListaDupla<T> l) {
        if (l != this) {
            this.fazVazia();
            for (Element<T> ptr = l.head; ptr != null; ptr = ptr.next) {
                this.inserirFim(ptr.data);
            }
        }
    }

    public void extrair(Object item) throws ObjetoNaoEncontradoException {

        Element<T> ptr = head;

        while (ptr != head.prev && ptr.data != item) {
            ptr = ptr.next;
        }

        if (ptr == head.prev && item != head.prev) {
            throw new ObjetoNaoEncontradoException();
        }

        if (ptr == head) {
            head.next.prev = ptr.prev;
            head = ptr.next;
            head.prev.next = head;
        }
        if (ptr == head.prev) {
            head.prev = ptr.prev;
            head.prev.next = head;

        } else {
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
        }

    }

}
