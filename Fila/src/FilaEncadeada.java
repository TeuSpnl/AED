import ListaEncadeada.Element;

public class FilaEncadeada implements iFila {
    private ListaEncadeada lista;
    private int count;

    public FilaEncadeada() {
        lista = new ListaEncadeada();
        count = 0;
    }

    public void fazVazia() {
        lista.fazVazia();
        count = 0;
    }

    public boolean estaVazia() {
        return count == 0;
    }

    public Object getPrimeiro() throws ContainerVazioException, ListaVaziaException {
        if (count == 0)
            throw new ContainerVazioException();
        return lista.getPrimeiro();
    }

    public void enfileirar(Object objeto) {
        lista.inserirFim(objeto);
        count++;
    }

    public Object desenfileirar() throws ContainerVazioException, ListaVaziaException {
        if (count == 0)
            throw new ContainerVazioException();

        Object result = lista.getPrimeiro();
        lista.extrair(result);
        --count;
        return result;
    }

    public String toString(){
        if (this.estaVazia()){
            return "[ ]";
        }
        StringBuilder builder = new StringBuilder();

        for (Element element = this.getHead()){
            builder.append(element.getData());
            
        }
        }
}
