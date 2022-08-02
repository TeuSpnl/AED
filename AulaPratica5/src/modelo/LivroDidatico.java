package modelo;

public class LivroDidatico extends Livro {
  private String disciplina;

  public LivroDidatico(String nome, double preco, int paginas, String autor, String disciplina) {
    super(nome, preco, paginas, autor);
    this.disciplina = disciplina;
  }

  public String getDisciplina() {
    return this.disciplina;
  }

  public void setDisciplina(String disciplina) {
    this.disciplina = disciplina;
  }

  public boolean ehCaro() {
    boolean caro = false;
    if (this.getPreco() > 200) {
      caro = true;
    }
    return caro;
  }

  public String toString(LivroDidatico d) {
    String allData = super.toString() + "Disciplina" + this.getDisciplina();
    return allData;
  }
}
