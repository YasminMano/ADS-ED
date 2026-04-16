public class Pet {
    private String nome;
    private int idade;
    private String especie;
    private int id;
    private static int valor = 1; //Para fazer o auto incremete unico de cada pet

    public Pet(String nome, int idade, String especie, int id){
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.id = valo++; //Incrementando
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getEspecie(){
        return especie;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", especie='" + especie + '\'' +
                ", id=" + id +
                '}';
    }
}
