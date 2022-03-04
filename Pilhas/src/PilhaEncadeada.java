public class PilhaEncadeada implements Pilha {
    private ListaEncadeada lista;
    private int count;

    public PilhaEncadeada() {
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

    public void push(Object objeto) {
        lista.inserirInicio(objeto);
        count++;
    }

    public Object pop() throws ContainerVazioException{
		if (count == 0)
			throw new ContainerVazioException();
		Object result = lista.getPrimeiro();
		lista.extrair(result);
		count --;
		return result;
	}

    public Object getTop() throws ContainerVazioException{
        if (count == 0)
            throw new ContainerVazioException();
        return lista.getPrimeiro();
    }
}
