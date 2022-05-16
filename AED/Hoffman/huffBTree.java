// Classse modelo para o nó e as folhas
abstract class huffBTree implements Comparable<huffBTree> {
    public final int freq;

    public huffBTree(int freq) {
        this.freq = freq;
    }

    // Compara as frequência para ordenar na fila
    public int compareTo(huffBTree tree) {
        return freq - tree.freq;
    }
}
