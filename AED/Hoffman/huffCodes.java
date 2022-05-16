import java.util.PriorityQueue;

public class huffCodes {
    public static huffBTree buildBTree(int[] charFreq) {
        PriorityQueue<huffBTree> trees = new PriorityQueue<huffBTree>(); // Uma lista já ordenada automaticamente do
                                                                         // tipo huffBTree, ou seja, é uma árvore lista
                                                                         // ou lista árvore, não sei.

        // Inserir as letras na lista
        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] > 0) {
                trees.offer(new huffLeaf(charFreq[i], (char) i));
            }
        }

        // Pega as menores frequências, cria um node com elas e insere na trees
        while (trees.size() > 1) {
            huffBTree a = trees.poll();
            huffBTree b = trees.poll();

            trees.offer(new huffNode(a, b));
        }

        // Retorna o primeiro nó de trees
        return trees.poll();
    }

    public static String encode(huffBTree tree, String text) {
        assert tree != null;

        String encodedText = "";

        for (char c : text.toCharArray()) {
            encodedText += (getCode(tree, new StringBuffer(), c)); // Concatena todos os códigos dos caracteres
        }

        return encodedText;
    }

    public static String decode(huffBTree tree, String encoded) {
        assert tree != null;

        huffNode node = (huffNode) tree;
        String decodedText = "";
        // Aqui é usado uma String porque outros métodos usam String

        for (char c : encoded.toCharArray()) {
            if (c == '0') { // Quando é filho da esquerda da raiz
                if (node.lChild instanceof huffLeaf) { // Caso seja folha
                    decodedText += ((huffLeaf) node.lChild).value; // Salva o valor na variável
                    node = (huffNode) tree; // Retorna à raiz da árvore
                } else {
                    node = (huffNode) node.lChild;
                }
            } else if (c == '1') { // Quando é filho da direita da raiz
                if (node.rChild instanceof huffLeaf) { // Caso seja nó
                    decodedText += ((huffLeaf) node.rChild).value;
                    node = (huffNode) tree;
                } else {
                    node = (huffNode) node.rChild;
                }
            }
        }

        return decodedText; // Retorna o valor decodificado
    }

    public static String getCode(huffBTree tree, StringBuffer prefix, char c) { // Pega o código do caractere
        assert tree != null;

        if (tree instanceof huffLeaf) { // Caso seja uma folha
            huffLeaf leaf = (huffLeaf) tree;

            if (leaf.value == c) {
                return prefix.toString(); // Retorna o código do caractere
            }
        } else if (tree instanceof huffNode) { // Caso seja um nó
            huffNode node = (huffNode) tree;

            // Filho da esquerda
            prefix.append('0');
            String lChild = getCode(node.lChild, prefix, c);
            prefix.deleteCharAt(prefix.length() - 1);

            // Filho da direita
            prefix.append('1');
            String rChild = getCode(node.rChild, prefix, c);
            prefix.deleteCharAt(prefix.length() - 1);

            if (lChild == null) {
                return rChild;
            } else {
                return lChild;
            }
        }

        return null;
    }

    public static void printCode(huffBTree tree, StringBuffer prefix) {
        assert tree != null;

        if (tree instanceof huffLeaf) {
            huffLeaf leaf = (huffLeaf) tree;

            System.out.println(leaf.value + "\t\t" + leaf.freq + "\t\t" + prefix);
        } else if (tree instanceof huffNode) {
            huffNode node = (huffNode) tree;

            prefix.append('0');
            printCode(node.lChild, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            prefix.append('1');
            printCode(node.rChild, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

}
