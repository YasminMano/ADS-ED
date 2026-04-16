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
    //escolhe uma posição do array
    //procura o menor nome dali para frente
    //troca esse menor com a posição atual
    //repete

    public static void ordenarNome(){
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

    //Função para percorrer a lista e exibir os pets
    public static void exibir(){
        for(int i = 0; i < indice; i++){
            System.out.println(lista[i]);
        }
    }
}
