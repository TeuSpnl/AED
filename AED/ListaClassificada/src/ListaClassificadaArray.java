public class ListaClassificadaArray implements iListaClassificada {
    private Object[] array;

    int count;

    public ListaClassificadaArray(
            int tam) {
        array = new Object[tam];
        count = 0;
    }

    public void inserir(Object objeto) throws ContainerCheioException {

        if (count == array.length)
            throw new ContainerCheioException();
        else {
            array[count] = objeto;
            count++;
        }
    }

    public boolean eMembro(Object o) { // Pressupondo uma lista ordenada
        int i;
        for (i = 0; i < count; i++) {
            if (((int) o <= (int) array[i])) {
                break; // Sai do laço
            }
        }

        return ((i < count) && ((int) o == (int) array[i]));
    }

    public Object procurar(Object o) { // Pressupondo que nossa lista está ordenada
        int i;
        for (i = 0; i < count; i++) {
            if (((int) o) == (int) array[i]) {
                return array[i];
            } else if (((int) o) < (int) array[i]) {
                break; // Sai do laço
            }
        }

        return null;
    }

    public void remover(Object objeto) throws ContainerVazioException, ArgumentoInvalidoException {

        if (count == 0)
            throw new ContainerVazioException();
        else {
            int i = 0;
            while (i < count && array[i] != objeto)
                i++;
            if (i == count)
                throw new ArgumentoInvalidoException();
            else {
                for (; i < count - 1; i++)
                    array[i] = array[i + 1];
                array[i] = null;
                count--;
            }
        }
    }

    protected class MeuCursor implements iCursor {

        int offset;

        MeuCursor(int offset) {
            this.offset = offset;
        }

        public Object getDado() {

            if (offset < 0 || offset >= count)
                throw new IndexOutOfBoundsException();
            return array[offset];
        }

        public void inserirAntes(Object objeto) throws ContainerCheioException {

            if (offset < 0 || offset >= count)
                throw new IndexOutOfBoundsException();
            if (count == array.length)
                throw new ContainerCheioException();
            else {
                for (int i = count; i > offset; i--)
                    array[i] = array[i - 1];
                array[offset] = objeto;
                count++;
            }
        }

        public void inserirDepois(Object objeto) throws ContainerCheioException {

            if (offset < 0 || offset >= count)
                throw new IndexOutOfBoundsException();
            if (count == array.length)
                throw new ContainerCheioException();
            else {
                int posInserir = offset + 1;
                for (int i = count; i > posInserir; i--)
                    array[i] = array[i - 1];
                array[posInserir] = objeto;
                count++;
            }

        }

        public void remover() throws ContainerCheioException {

            if (offset < 0 || offset >= count)
                throw new IndexOutOfBoundsException();
            if (count == 0)
                throw new ContainerCheioException();
            else {
                int i = offset;
                while (i < count - 1) {
                    array[i] = array[i + 1];
                    i++;
                }
                array[i] = null;
                count--;
            }
        }

    }

    public iCursor procurarPosicao(Object objeto) {

        int i = 0;
        while (i < count && !array[i].eIgual(objeto))
            i++;
        return new MeuCursor(i);
    }

    public Object get(int offset) {

        if (offset < 0 || offset >= count)
            throw new IndexOutOfBoundsException();
        return array[offset];
    }
}
