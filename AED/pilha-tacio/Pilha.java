public class Pilha implements iPilha {
    private ListaEncadeada lista;
    private int count;

    public Pilha() {
        lista = new ListaEncadeada();
        count = 0;
    }

    @Override
    public void fazVazia() {
        lista.fazVazia();
        count = 0;
    }

    @Override
    public boolean estaVazia() {

        return lista.estaVazia();
    }

    @Override
    public Object getTop() throws ContainerVazioException {
        if (count == 0)
            throw new ContainerVazioException();
        try {
            return lista.getPrimeiro();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void push(Object o) {
        lista.inserirInicio(o);
        count++;
    }

    @Override
    public Object pop() throws ContainerVazioException {
        if (count == 0)
            throw new ContainerVazioException();
        try {
            Object o = lista.getPrimeiro();
            lista.extrair(o);
            count--;
            return o;
        } catch (Exception e) {
            return null;
        }

    }

}
