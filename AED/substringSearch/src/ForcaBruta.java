public class ForcaBruta {
    public static int FB(String pat, String txt) {
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
}