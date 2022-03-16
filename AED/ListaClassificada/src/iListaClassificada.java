public interface iListaClassificada {
    Object get(int i);

    iCursor procurarPosicao(Object o);

    boolean eMembro(Object o);

    void inserir(Object o) throws ContainerCheioException;

    void remover(Object o) throws ContainerVazioException, ArgumentoInvalidoException;

    Object procurar(Object o);

}
