public interface iListaClassificada {
    Object get(int i);

    iCursor procurarPosicao(Object o);

    boolean eMembro(Object o);

    void inserir(Object o);

    void remover(Object o);

    Object procurar(Object o);
}
