public class Expressions {
    public static String infixToPosFix(String strIn) {
        iPilha pilha = new Pilha();
        String strOut = "";
        char c;
        char cpop = 0;

        for (int i = 0; i < strIn.length(); i++) {
            c = strIn.charAt(i);

            if (isDigito(c)) {
                strOut = strOut + c;
            } else if (isOperator(c)) {
                // empilhar verificando prioridade
                try {
                    cpop = (char) pilha.getTop();
                    while (Prioridade(cpop) >= Prioridade(c)) {
                        strOut = strOut + (char) pilha.pop();
                        cpop = (char) pilha.getTop();
                    }
                    pilha.push(c); // empilha o operador
                } catch (Exception e) {
                }
            } else if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                // desempilhar até encontrar o '('
                do {
                    try {
                        cpop = (char) pilha.pop();
                        if (cpop != '(') {
                            strOut = strOut + cpop;
                        }
                    } catch (Exception e) {
                    }
                } while (cpop != '(');
            } else {
                // excecao
            }

        }
        return strOut;
    }

    public static boolean isDigito(char c) {
        int asccInt = (int) c;
        return ((asccInt >= 48) & (asccInt <= 57));
    }

    public static boolean isOperator(char c) {
        if ((c == '+') || (c == '-') || (c == '*') || (c == '/') || (c == '$')) {
            return true;
        }
        return false;
    }

    public static int Prioridade(char c) {
        if ((c == '+') || (c == '-')) {
            return 0; // prioridade soma/sub
        } else if ((c == '*') || (c == '/')) {
            return 1;
        } else if (c == '$') {
            return 2;
        } else {
            return -1;
        }
    }
}