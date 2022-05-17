public class searchCodes {
    public static int searchFB(String pat, String txt) {
        int j, M = pat.length();
        int i, N = txt.length();

        for (i = 0; i <= N - M; i++) {
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            if (j == M)
                return i;
        }
        return N;
    }

    public int searchKMP(String txt) {
        int j, M = pat.length();
        int i, N = txt.length();

        for (i = 0, j = 0; i < N && j < M; i++)
            j = dfa[txt.charAt(i)][j];

        if (j == M)
            return i - M;
        else
            return N;
    }
}