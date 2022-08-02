package control;

import java.io.IOException;
import java.util.ArrayList;
import model.Disciplina;

public class ControleDisciplina {

  public void cadastrarDisciplina(String nome, int codigo, int ch) throws IOException {
    Disciplina d = new Disciplina(nome, codigo, ch);
    d.cadastrarDisciplina(d);

  }

  public Disciplina pesquisarDisciplina(int codigo) throws IOException, ClassNotFoundException {
    Disciplina d = null;
    ArrayList<Disciplina> disc = listarDisciplina();
    for (int i = 0; i < disc.size(); i++) {
      if (codigo == disc.get(i).getCodigo()) {
        d = disc.get(i);
        break;
      }
    }
    return d;
  }

  public ArrayList<Disciplina> listarDisciplina() throws IOException, ClassNotFoundException {
    Disciplina d = new Disciplina();
    return d.listarDisciplina();
  }

  public String imprimir() throws IOException, ClassNotFoundException {
    String res = "";
    ArrayList<Disciplina> disc = listarDisciplina();
    for (int i = 0; i < disc.size(); i++) {
      res += disc.get(i).imprimir() + "\n---------\n";
    }
    return res;
  }
}
