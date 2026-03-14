package modelo;
public class Produto{
    private String nome;
    private double preco;
    private int id;
    private static int count = 1;

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
        this.id = count++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}