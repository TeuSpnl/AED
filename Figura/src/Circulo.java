public class Circulo extends Ponto{

    private double raio, area;


    public Circulo(double raio) {
        this.raio = raio;
    }


    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double area() {
        this.area = Math.PI * (raio * raio);
        return area;
    }

    public String toString (){
        return "area";
    }

}
