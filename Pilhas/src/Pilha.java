public interface Pilha {
    void fazVazia(); 
    boolean estaVazia();
	Object getTop() throws ContainerVazioException;
	void push(Object o) throws ContainerCheioException;
	Object pop() throws ContainerVazioException;
  
}
