package view;

import java.io.Console;
import java.io.IOException;
import javax.swing.JOptionPane;
import control.*;
import model.Disciplina;

public class App {
  public static String menu() {
    return "Digite:\n" + "1 - Cadastrar disciplina \n" + "2 - Pesquisar disciplina\n" + "3 - Listar disciplinas \n"
        + "0 - para sair";
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    ControleDisciplina cd = new ControleDisciplina();

    int op, primeCode = 1;

    op = Integer.parseInt(JOptionPane.showInputDialog(menu()));

    while (op != 0) {
      switch (op) {
        case 1: { // cadastar disciplina
          String nome = JOptionPane.showInputDialog("Qual o nome da disciplina?");
          int codigo = primeCode++;
          int ch = Integer.parseInt(JOptionPane.showInputDialog("Qual a carga horária da disciplina?"));

          cd.cadastrarDisciplina(nome, codigo, ch);
          break;
        }
        case 2: { // Pesquisar disciplina
          Disciplina d = cd.pesquisarDisciplina(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do objeto?")));

          if( d != null){
            JOptionPane.showMessageDialog(null, d.imprimir());
          }
          else{
            JOptionPane.showInternalMessageDialog(null, "Id inválido");
          }
          break;
        }

        case 3: {// Listar disciplinas
          String message = "";
          
          for (Disciplina d : cd.listarDisciplina()) {
            System.out.println(cd.listarDisciplina().size());
            message += d.imprimir() + "\n ------------------------------ \n";
          }

          JOptionPane.showMessageDialog(null, message);
          break;

        }

      }
      op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
    }
  }

}

/*
 * Questão 1.b) Isso significa que agora os objetos serão salvos em arquivos
 * binários e assim ele poderá ser recupareado mais pra frente.f
 * 
 * Questão 1
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
