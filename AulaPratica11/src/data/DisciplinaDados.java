package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.*;

public class DisciplinaDados {
  public void cadastrarDisciplina(Disciplina d) throws IOException {
    FileOutputStream fos = new FileOutputStream("disciplina.ser", true);
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    oos.writeObject(d);
    oos.close();
  }

  // Se der erro, o ois tem que ser declarado dentro do while.
  public ArrayList<Disciplina> listarDisciplina() throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream("disciplina.ser");
    ObjectInputStream ois;

    ArrayList<Disciplina> DiscList = new ArrayList<>();

    while (fis.available() != 0) {
      ois = new ObjectInputStream(fis);
      DiscList.add((Disciplina) ois.readObject());
    }

    fis.close();
    return DiscList;
  }

  public Disciplina pesquisarDisciplina(int codigo) throws ClassNotFoundException, IOException {
    ArrayList<Disciplina> DiscList = listarDisciplina();

    for (Disciplina d : DiscList) {
      if (codigo == d.getCodigo()) {
        return d;
      }
    }
    return null;
  }

  public void cadastrarDisciplina2(Disciplina d) throws ClassNotFoundException, IOException, FileNotFoundException {
    ArrayList<Disciplina> disciplinas = new ArrayList();
    File arq = new File("listaDisciplina.ser");

    if (arq.exists()) {
      disciplinas = listarDisciplina2();
    }

    disciplinas.add(d);
    
    FileOutputStream fluxo = new FileOutputStream(arq);
    try (ObjectOutputStream gravarObj = new ObjectOutputStream(fluxo)) {
      gravarObj.writeObject(disciplinas);
    }
  }

  public ArrayList<Disciplina> listarDisciplina2() throws ClassNotFoundException, IOException, FileNotFoundException {
    ArrayList<Disciplina> disciplinas;
    File arq = new File("listaDisciplina.ser");
    FileInputStream fluxo = new FileInputStream(arq);
    ObjectInputStream lerObj = new ObjectInputStream(fluxo);
    disciplinas = (ArrayList<Disciplina>) lerObj.readObject();
    return disciplinas;
  }

}
