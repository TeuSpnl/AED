public class Kmp {

    private String pat;
    private int[][] dfa;

    // Construtor (pré-processamento)
    public Kmp(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256; // Tabela ASCII
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;

        for (int X = 0, j = 1; j < M; j++) {
            // Calcula  o dfa[][j]
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X]; // Conflito
            }

            dfa[pat.charAt(j)][j] = j + 1; // Casamento
            X = dfa[pat.charAt(j)][X]; // Posição back-up
        }
    }

    // Simula funcionamento do DFA sobre o texto
    public int search(String txt) {
        int j, M = pat.length();
        int i, N = txt.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }

        if (j == M) {
            return i - M;
        } else {
            return N;
        }
    }
}