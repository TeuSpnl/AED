public class ListaDupla<T> {
    private Element<T> head;

    public ListaDupla() {

    }

    // classe Element
    public final class Element<K> {
        K data;
        public Element<K> next, prev;

        Element(K data, Element<K> prev, Element<K> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        // metodos
        public Element<K> getNext() {
            return next;
        }

        public Element<K> getPrev() {
            return prev;
        }

        public K getData() {
            return data;
        }

    }

    // metodos
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
        if (head == null) {
            throw new ListaVaziaException("Lista vazia");
        }
        return head.data;
    }

    public Object getUltimo() throws ListaVaziaException {
        if (head.prev == null) {
            throw new ListaVaziaException("Lista vazia");
        }
        return head.prev.data;
    }

    // metodos de inserção
    public void inserirInicio(T item) {
        Element<T> temp = new Element<T>(item, head.prev, head);
        if (this.head == null) {
            this.head = temp;
            this.head.prev = temp;
        } else {
            this.head.prev = temp;
            this.head = temp;
            this.head.prev = head.prev;
            this.head.prev.next = head;
        }
    }

    public void inserirFim(T item) {
        Element<T> temp = new Element<T>(item, head.prev, head);
        if (this.head == null) {
            this.head = temp;
            this.head.prev = temp;
        } else {
            this.head.prev.next = temp;
            this.head.prev = temp;
            this.head.prev.next = head;
            this.head.prev = head.prev;
        }
    }

    // remover
    public void remover(T item) throws ObjetoNaoEncontradoException {
        Element<T> ptr = head;
        int i = 0;
        while (ptr != null && ptr.data != item && i < ) {
            ptr = ptr.next;
        }
        if (ptr == null) {
            throw new ObjetoNaoEncontradoException("Não encontrado!!!");
        }
        if (ptr == head) {
            head = ptr.next;
            head.prev = null;
        }
        if (ptr == head.prev) {
            head.prev = ptr.prev;
            head.prev.next = null;
        } else {
            (ptr.prev).next = ptr.next;
            (ptr.next).prev = ptr.prev;
        }
    }
}