import java.util.*;

public class HuffmanCode {
    /*
     * Implementa��o do Algoritmo de Huffman
     * Compacta��o e Descompata��o de um texto
     * 
     * Para implementar o Algoritmo de Huffman � necess�rio conhecer as �rvores
     * bin�rias.
     */
    public static void main(String[] args) {
        // Texto exemplo para Compactar e Decodifica��o usando o Algoritmo de Huffman
        String test = "paralelepipedo"; // Tamanho do texto = 112 bits

        // Neste exemplo ser� considerado que teremos no m�ximo 256 caracteres
        // diferentes
        // Passo 1 - Percorre o texto contando os s�mbolos e montando um vetor de
        // frequ�ncias.
        int[] charFreqs = new int[256];
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // Criar a �rvore dos c�digos para a Compacta��o
        HuffmanTree tree = buildTree(charFreqs);

        // Resultados das quantidade e o c�digo da Compacta��o
        System.out.println("TABELA DE C�DIGOS");
        System.out.println("S�MBOLO\tQUANTIDADE\tHUFFMAN C�DIGO");
        printCodes(tree, new StringBuffer());

        // Compactar o texto
        String encode = encode(tree, test);
        // Mostrar o texto Compactado
        System.out.println("\nTEXTO COMPACTADO");
        System.out.println(encode); // Tamanho de 40 bits - Economia de 72 bits

        // Decodificar o texto
        System.out.println("\n\nTEXTO DECODIFICADO");
        System.out.println(decode(tree, encode));

    }

    /*
     * Criar a �rvore de Codifica��o - A partir da quantidade de frequ�ncias de cada
     * letra
     * cria-se uma �rvore bin�ria para a compacta��o do texto
     * Par�metro de Entrada: charFreqs: array com quantidade de frequ�ncias de cada
     * letra
     * Par�metro de Sa�da: trees: �rvore bin�ria para a compacta��o e decodifica��o
     */
    public static HuffmanTree buildTree(int[] charFreqs) {
        // Cria uma Fila de Prioridade
        // A Fila ser� criado pela ordem de frequ�ncia da letra no texto
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // Criar as Folhas da �rvore para cada letra
        for (int i = 0; i < charFreqs.length; i++) {
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i)); // Inser os elementos, n� folha, na fila de
                                                                      // prioridade
        }
        // Percorre todos os elementos da fila
        // Criando a �rvore bin�ria de baixo para cima
        while (trees.size() > 1) {
            // Pega os dois n�s com menor frequ�ncia
            HuffmanTree a = trees.poll(); // poll - Retorna o pr�ximo n� da Fila ou NULL se n�o tem mais
            HuffmanTree b = trees.poll(); // poll - Retorna o pr�ximo n� da Fila ou NULL se n�o tem mais

            // Criar os n�s da �rvore bin�ria
            trees.offer(new HuffmanNode(a, b));
        }
        // Retorna o primeiro n� da �rvore
        return trees.poll();
    }

    /*
     * COMPACTAR a string
     * Par�metros de Entrada: tree - Raiz da �rvore de compacta��o
     * encode - Texto original
     * Par�metros de Sa�da: encodeText- Texto Compactado
     */
    public static String encode(HuffmanTree tree, String encode) {
        assert tree != null;

        String encodeText = "";
        for (char c : encode.toCharArray()) {
            encodeText += (getCodes(tree, new StringBuffer(), c));
        }
        return encodeText; // Retorna o texto Compactado
    }

    /*
     * DECODIFICAR a string
     * Par�metros de Entrada: tree - Raiz da �rvore de compacta��o
     * encode - Texto Compactado
     * Par�metros de Sa�da: decodeText- Texto decodificado
     */
    public static String decode(HuffmanTree tree, String encode) {
        assert tree != null;

        String decodeText = "";
        HuffmanNode node = (HuffmanNode) tree;
        for (char code : encode.toCharArray()) {
            if (code == '0') { // Quando for igual a 0 � o Lado Esquerdo
                if (node.left instanceof HuffmanLeaf) {
                    decodeText += ((HuffmanLeaf) node.left).value; // Retorna o valor do n� folha, pelo lado Esquerdo
                    node = (HuffmanNode) tree; // Retorna para a Ra�z da �rvore
                } else {
                    node = (HuffmanNode) node.left; // Continua percorrendo a �rvore pelo lado Esquerdo
                }
            } else if (code == '1') { // Quando for igual a 1 � o Lado Direito
                if (node.right instanceof HuffmanLeaf) {
                    decodeText += ((HuffmanLeaf) node.right).value; // Retorna o valor do n� folha, pelo lado Direito
                    node = (HuffmanNode) tree; // Retorna para a Ra�z da �rvore
                } else {
                    node = (HuffmanNode) node.right; // Continua percorrendo a �rvore pelo lado Direito
                }
            }
        } // End for
        return decodeText; // Retorna o texto Decodificado
    }

    /*
     * M�todo para percorrer a �rvore e mostra a tabela de compacta��o
     * Par�metros de Entrada: tree - Raiz da �rvore de compacta��o
     * prefix - texto codificado com 0 e/ou 1
     */
    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            // Imprime na tela a Lista
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t\t" + prefix);

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    /*
     * M�todo para retornar o c�digo compactado de uma letra (w)
     * Par�metros de Entrada: tree - Raiz da �rvore de compacta��o
     * prefix - texto codificado com 0 e/ou 1
     * w - Letra
     * Par�metros de Sa�da: prefix- Letra codificada
     */
    public static String getCodes(HuffmanTree tree, StringBuffer prefix, char w) {
        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            // Retorna o texto compactado da letra
            if (leaf.value == w) {
                return prefix.toString();
            }

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            // Percorre a esquerda
            prefix.append('0');
            String left = getCodes(node.left, prefix, w);
            prefix.deleteCharAt(prefix.length() - 1);

            // Percorre a direita
            prefix.append('1');
            String right = getCodes(node.right, prefix, w);
            prefix.deleteCharAt(prefix.length() - 1);

            if (left == null)
                return right;
            else
                return left;
        }
        return null;
    }

}
