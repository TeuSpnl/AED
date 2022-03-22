public class ListaEncadeada {

    private Element head;

    private Element tail;

    public ListaEncadeada() {
        this.fazVazia();
    }

    public void fazVazia() {

        head = null;

        tail = null;

    }

    public Element getHead() {
        return head;
    }

    public Element getTail() {
        return tail;
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
        if (tail == null)
            throw new ListaVaziaException();
        return tail.data;
    }

    public void inserirInicio(Object item) {
        Element temp = new Element(item, head);
        if (head == null) {
            tail = temp;
        }
        head = temp;
    }

    public void inserirFim(Object item) {
        Element temp = new Element(item, null);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
    }

    public void atribuir(ListaEncadeada l) {
        if (l != this) {
            this.fazVazia();
            for (Element ptr = l.head; ptr != null; ptr = ptr.next) {
                this.inserirFim(ptr.data);
            }
        }
    }

    public void extrair(Object item) throws Exception {

        Element ptr = head;
        Element prevPtr = null;

        while (ptr != null && ptr.data != item) {
            prevPtr = ptr;
            ptr = ptr.next;
        }
        if (ptr == null) {
            throw new ObjetoNaoEncontradoException();
        }

        if (ptr == head) {
            head = ptr.next;
        } else {
            prevPtr.next = ptr.next;
        }

        if (ptr == tail) {
            tail = prevPtr;
        }
    }

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

    @Override
    public String toString(){
        String volta = "Object";

        for (int i = 0; i < 10; i++){
            try {
                Object primeiro = getPrimeiro();

                System.out.println(primeiro);

            } catch (ListaVaziaException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return(volta);
    }
}