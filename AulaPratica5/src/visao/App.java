package visao;

// import modelo.*;
import controle.*;

// import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {
    public static String menu() {
        return "Digite:\n" +
                "1 - Cadastrar produto \n" +
                "2 - Imprimir produto \n" +
                "3 - Eh caro? \n" +
                "0 - para sair";
    }

    public static void main(String[] args) {
        ControleProduto cp = new ControleProduto();
        int op;

        op = Integer.parseInt(JOptionPane.showInputDialog(menu()));

        while (op != 0) {
            switch (op) {
                case 1: {// cadstrar produto
                    String nome;
                    double preco;
                    nome = JOptionPane.showInputDialog("Digite o nome do produto");
                    preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco do produto"));
                    int op2 = Integer.parseInt(JOptionPane.showInputDialog("Este produto é um livro? \n1 - Sim \n2 - Não "));
                    if (op2 == 1) {
                        String autor = JOptionPane.showInputDialog("Digite o autor do livro");
                        int pag = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de paginas do livro"));

                        int op3 = Integer.parseInt(JOptionPane.showInputDialog("Este livro é didádico? \n1 - Sim \n2 - Não "));
                        if (op3 == 1) {
                        String disciplina = JOptionPane.showInputDialog("Digite a disciplina do livro.");
                            cp.cadastrarProduto(nome, preco, autor, pag, disciplina);
                        } else {
                            cp.cadastrarProduto(nome, preco, autor, pag);
                        }
                    } else {
                        cp.cadastrarProduto(nome, preco);
                    }
                    break;
                }
                case 2: {// Imprimir produto
                    int code = Integer.parseInt(JOptionPane.showInputDialog("Digite o cógido do produto: "));
                    System.out.println(cp.imprimirProduto(code));
                    break;
                }
                case 3: {// eh caro
                    int code = Integer.parseInt(JOptionPane.showInputDialog("Digite o cógido do produto: "));
                    if (cp.produtoEhCaro(code) == true){
                        System.out.println("É caro.");
                    }
                    else {
                        System.out.println("Não é caro.");
                    }
                    break;
                }
            }
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        }
    }

}

// public static void main(String[] args) {
// ArrayList<Produto> produtos = new ArrayList();
// String resultado = "";
// produtos.add(new Livro("Java Como Programar", 300, 1000, "Deitel"));
// produtos.add(new Produto("Lapis preto", 2));
// produtos.add(new Produto("Caneta azul", 3.5));
// produtos.add(new Livro("A hora da estrela", 37.8, 120, "Clarice Lispector"));

// // for (int i = 0; i < produtos.size(); i++) {
// // resultado = resultado + produtos.get(i).toString() + "\n--------\n";
// // produtos.get(i).ehGrande();
// // }

// for (int i = 0; i < produtos.size(); i++) {
// resultado = resultado + produtos.get(i).toString() + "\n--------\n";
// ((Livro) produtos.get(i)).ehGrande();
// }

// JOptionPane.showMessageDialog(null, resultado);
// }