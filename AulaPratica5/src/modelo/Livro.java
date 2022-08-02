package modelo;

public class Livro extends Produto {
  private int paginas;
  private String autor;

  public Livro(String nome, double preco, int paginas, String autor) {
    super(nome, preco);
    this.paginas = paginas;
    this.autor = autor;
  }

  public int getPaginas() {
    return this.paginas;
  }

  public void setPaginas(int paginas) {
    this.paginas = paginas;
  }

  public String getAutor() {
    return this.autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public boolean ehGrande() {
    if (this.paginas > 200) {
      return true;
    }
    return false;
  }

  public String toString(Livro l) {
    String allData = super.toString() + "Autor: " + this.getAutor() + "Nº de páginas: " + this.getPaginas();
    return allData;
  }
}
