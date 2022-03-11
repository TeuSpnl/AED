public class PilhaEncadeada implements Pilha {

  private ListaEncadeada lista;
  private int count;

  public PilhaEncadeada() {
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
    return count == 0;
  }

  @Override
  public void push(Object objeto) {
    lista.inserirInicio(objeto);
    count++;
  }

  @Override
  public Object pop() throws ContainerVazioException {
    if (count == 0) throw new ContainerVazioException();

    try {
      Object result;
      result = lista.getPrimeiro();
      lista.extrair(result);
      count--;
      return result;
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public Object getTop() throws ContainerVazioException {
    if (count == 0) throw new ContainerVazioException();
    try {
      return lista.getPrimeiro();
    } catch (Exception e) {
      return null;
    }
  }
}
