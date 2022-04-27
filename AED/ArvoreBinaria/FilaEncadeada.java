public class FilaEncadeada implements iFila {
    protected ListaDupla lista;
    protected int count;

    public FilaEncadeada() {
        lista = new ListaDupla();
        count = 0;
    }

    @Override
    public void fazVazia() {
        lista.fazVazia();
    }

    @Override
    public boolean estaVazia() {
        return (count == 0);
    }

    @Override
    public Object getPrimeiro() {
        Object o = null;
        try {
            o = lista.getPrimeiro();
        } catch (Exception e) {
        } finally {

        }
        return o;
    }

    @Override
    public void enfileirar(Object objeto) {

        lista.inserirFim(objeto);
        count++;

    }

    @Override
    public Object desenfileirar() {
        Object o = null;
        try {
            o = lista.getPrimeiro();
            lista.extrair(o);
            count--;
        } catch (Exception e) {
        } finally {

        }
        return o;
    }

}
