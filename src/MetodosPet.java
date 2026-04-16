public class MetodosPet {
    private static final int TAMANHO = 5;
    private static Pet[] lista = new Pet[TAMANHO];
    private static int indice = 0;

    public static Pet[] alocarArray() {
        Pet[] novo = new Pet[lista.length + 5]; //Cria um novo vetor de Pet.

        for (int i = 0; i < lista.length; i++) { // ercorre todas as posições do vetor antigo.
            novo[i] = lista[i];// Copia cada elemento do vetor antigo para o novo.
        }

        return novo; //Devolve o vetor novo para quem chamou o método.
    }

    public static boolean inserir(Pet pet) {

        //Se o vetor estiver cheio, chama o método que cria outro maior e faz lista passar a usar esse novo vetor.
        if (indice >= lista.length) {
            lista = alocarArray(); 
        }

        lista[indice] = pet; // Insere o pet na posição do índice atual.
        indice++;
        return true;
    }

    //Como o array possui tamanho fixo, é necessário criar um novo array com capacidade maior, 
    //copiar os elementos do array antigo para o novo e depois fazer a referência principal apontar para o novo array.
}
