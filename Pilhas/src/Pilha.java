public interface Pilha {
    void fazVazia(); 
    boolean estaVazia();
	Object getTop() throws ContainerVazioException;
	void push(Object o);
	Object pop() throws ContainerVazioException;
}
