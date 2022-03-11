public class FilaArray implements iFila {
    private Object array[];
    private int head, tail, count;

    public FilaArray(int tam) {
        array = new Object[tam];
        head = 0;
        tail = tam - 1;
        count = 0;
    }

    public void fazVazia() {
        while (count > 0) {
            array[head] = null;
            ++head;
            if (head == array.length)
                head = 0;
            --count;
        }
    }

    public boolean estaVazia() {
        return (count == 0);
    }

    public Object getPrimeiro() throws ContainerVazioException {
        if (count == 0)
            throw new ContainerVazioException();
        return array[head];
    }

    public void enfileirar(Object objeto) throws ContainerCheioException {
        if (count == array.length)
            throw new ContainerCheioException();
        ++tail;
        if (tail == array.length)
            tail = 0;
        array[tail] = objeto;
        ++count;
    }

    public Object desenfileirar() throws ContainerVazioException {
        if (count == 0)
            throw new ContainerVazioException();
        Object result = array[head];
        array[head] = null;
        ++head;
        if (head == array.length)
            head = 0;
        --count;
        return result;
    }
}
