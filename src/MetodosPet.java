//Diferenças de arrays e listas:
//Arrays têm tamanho fixo, ou seja, você precisa definir quantos elementos ele vai ter
//Listas (como ArrayList) podem crescer dinamicamente, ou seja, 
//você pode adicionar quantos elementos quiser sem se preocupar com o tamanho inicial.

public class MetodosPet{
    // define que o array começa com 5 posições
    private static final int TAMANHO = 5; //Tamanho inicial do Array
    //O "final" serve para o valor não mudar depois.

    // cria um vetor de Pet com 5 posições
    private static Pet[] lista = new Pet[TAMANHO]; //Vetor que guarda os pets

    // controla quantos pets já foram inseridos
    // e aponta para a próxima posição livre
    private static int indice = 0; //Quantidade de pets inseridos
    //Por que não usar o lista.length, ao invés do indice?
    //Pois ele diz o tamanho total do vetor. Mas isso não diz quantos pets foram realmente inseridos.

    //Função para inserir, verifica se o indice é menor que o tamanho disponívle no array, se for
    //Adiciona um novo pet ao indice atual e soma 1 no indice.
    public static boolean inserir(Pet pet){
        if(indice < lista.lengh){ //verifica o espaço
            lista[indice] = pet; // adiciona um pet na lista para esse indice
            indice++;
            return true
        }
        return false
    }

    //Função de pesquisa por ID
    public static Pet pesquisar(int id){
        for(int i = 0; i < indice; i++){ //compara se o que estamos percorrendo é menor que o indice
            if(lista[i].getId == id){ //pegamos o id da posição i do array e compara com os id existentes
                return lista[i]; //retorna a busca
            }
        }
        return null;
    }

    //Função para atualizar a idade pelo ID
    //Usa a mesma lógica da busca, mas quando acha o id ele seta a idade para o valor novo
    public static boolean atualizarIdade(int id, int novaIdade){
        for(int i = 0; i < indice, i++){
            if(lista[i].getId == id){
                lista[i].setIdade(novaIdade);
                return true;
            }
        }
        return false;
    }

    //Função para ordenar nomes usando selection sort
    //Ele funciona assim:
    //O primeiro for controla a posição que estamos organizando agora.
    //O segundo for olha os elementos depois da posição atual, e compara com o que estamos organizando.
    //Se encontrar alguém com nome menor, atualiza a posição do menor.

    public static void ordenarNomeSelection(){
        Pet temp; //variável temporária para armazenar um nome e realizar a troca entre eles

        for (int j = 0; j < indice - 1; j++) { //Esse for controla a posição que estamos organizando agora.
            int menor = j; //Aqui assumimos por enquanto, que o menor nome está na posição j (atual)

            //Esse for vai olhar os elementos depois de j.
            //Onde o i percorre e compara a posição j (0) com o i (1)
            for (int i = j + 1; i < indice; i++) { 

                //O compareToIgnoreCase() compara duas strings em ordem alfabética, ignorando maiúscula/minúscula.
                //Ou seja, se o nome que eu achava ser o menor vier depois do nome da posição i, então a posição i é a nova menor.”
                if (lista[menor].getNome().compareToIgnoreCase(lista[i].getNome()) > 0) { 
                    menor = i; //Se achei alguém com nome menor, atualizo menor.
                }
            }

            // troca o elemento da posição j com o menor encontrado
            temp = lista[menor];
            lista[menor] = lista[j];
            lista[j] = temp;    
        }
    }

    //Função para ordenar por nome usando bubble sort
    //Ele funciona assim:
    //compara o primeiro com o segundo, se o primeiro for maior, troca
    //compara o segundo com o terceiro, se o segundo for maior, troca
    //repete isso até o final do array, e depois repete tudo de novo,
    //até que não haja mais trocas, ou seja, até que esteja ordenado.

    public static void ordenarNomeBubble(){
        Pet temp; //variável temporária para armazenar um nome e realizar a troca entre eles
        boolean trocou;

        do {
            trocou = false; //inicialmente, assumimos que não houve trocas

            for (int i = 0; i < indice - 1; i++) { //percorre o array comparando pares de elementos
                if (lista[i].getNome().compareToIgnoreCase(lista[i + 1].getNome()) > 0) { 
                    //Se o nome da posição i for maior que o da posição i+1, trocamos
                    temp = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = temp;
                    trocou = true; //indica que houve uma troca
                }
            }
        } while (trocou); //repete enquanto houver trocas, ou seja, até estar ordenado
    }

    //Função para percorrer a lista e exibir os pets
    public static void exibir(){
        for(int i = 0; i < indice; i++){
            System.out.println(lista[i]);
        }
    }

    //A função de busca binária só funciona se a lista estiver ordenada. 
    //Ela começa do meio e compara o id, se for igual retorna, 
    //se for menor vai para a metade inferior, se for maior vai para a metade superior. 
    //E repete isso até encontrar ou acabar as possibilidades.

    //Exemplo de busca binária por ID
    public static Pet buscaBinaria(int id){
        int esquerda = 0, direita = indice - 1, meio;

        while(esquerda <= direita){
            meio = (esquerda + direita) / 2;

            if(lista[meio].getId() == id){
                return lista[meio];
            } else if(lista[meio].getId() < id){
                esquerda = meio + 1; //Busca na metade superior
            } else {
                direita = meio - 1; //Busca na metade inferior
            }
        }
        return null; //Não encontrado
    }

    //Exemplo de busca binária por nome
    public static Pet buscaBinariaNome(String nome){
        int esquerda = 0, direita = indice - 1, meio;

        while(esquerda <= direita){
            meio = (esquerda + direita) / 2;

            //O compareToIgnoreCase() retorna um valor negativo se o nome da posição meio vier antes do nome que estamos procurando,
            //um valor positivo se vier depois, e zero se forem iguais.
            int comparacao = lista[meio].getNome().compareToIgnoreCase(nome); 

            //Se a comparação for zero, encontramos o nome e retornamos o pet.
            if(comparacao == 0){
                return lista[meio];

                //Se a comparação for menor que zero, 
                //significa que o nome da posição meio vem antes do nome que estamos procurando,
                //então devemos buscar na metade superior do array.
            } else if(comparacao < 0){
                esquerda = meio + 1; //Busca na metade superior

                //Se a comparação for maior que zero,
                //significa que o nome da posição meio vem depois do nome que estamos procurando,
                //então devemos buscar na metade inferior do array.
            } else {
                direita = meio - 1; //Busca na metade inferior
            }
        }
        return null; //Não encontrado
    }
}
