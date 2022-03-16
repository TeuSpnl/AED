public interface iCursor {
    Object getDado();

    void inserirDepois(Object o) throws ContainerCheioException;

    void inserirAntes(Object o) throws ContainerCheioException;

    void remover() throws ContainerCheioException;

}
