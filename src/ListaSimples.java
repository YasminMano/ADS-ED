//Diferenças de arrays e listas:
//Arrays têm tamanho fixo, ou seja, você precisa definir quantos elementos ele vai ter
//Listas (como ArrayList) podem crescer dinamicamente, ou seja, 
//você pode adicionar quantos elementos quiser sem se preocupar com o tamanho inicial.

public class ListaSimples{
    private No inicio; // Referência para o primeiro nó da lista
    private No aux; // Referência auxiliar para o último nó da lista
    private No atual; // Referência para o nó atual, usada durante a inserção
    
    //Por que referenciar como null? 
    //Porque quando a lista é criada, ela está vazia, 
    //ou seja, não há nenhum nó. Portanto, as referências para o início, 
    //o auxiliar e o atual são definidas como null para indicar que a lista ainda não contém elementos. 
    //À medida que os elementos são inseridos na lista, 
    //essas referências serão atualizadas para apontar para os nós correspondentes.
    public ListaSimples(){
        this.inicio = null; //
        this.aux = null;
        this.atual = null;
    }

    // Método para inserir um objeto na lista
    public void inserir(Object obj) {
        if (inicio == null) { // Verifica se a lista está vazia
            inicio = new No(obj, null); // Cria um novo nó com o objeto e define o próximo como null
            aux = inicio; // O auxiliar aponta para o início, pois é o primeiro nó da lista
        } else { // Se a lista não estiver vazia, insere o novo nó no final da lista
            atual = new No(obj, null); // Cria um novo nó com o objeto e define o próximo como null
            aux.setProx(atual);// O próximo do nó auxiliar aponta para o novo nó atual
            aux = atual; // O auxiliar é atualizado para apontar para o novo nó atual, que agora é o último nó da lista
        }
    }

    public void exibir(){
        No temp = inicio; // Cria uma referência temporária para percorrer a lista, começando pelo início
        while(temp != null){ // Enquanto a referência temporária não for nula (ou seja, enquanto houver nós na lista)
            System.out.println(temp.getObj()); // Imprime a informação do nó atual
            temp = temp.getProx(); // Move a referência temporária para o próximo nó da lista
        }
    }

    //Função para contar nós da lista
    public int contarNos(){
        int contador = 0; // Inicializa um contador para contar os nós
        No temp = inicio; // Cria uma referência temporária para percorrer a lista, começando pelo início
        while(temp != null){ // Enquanto a referência temporária não for nula (ou seja, enquanto houver nós na lista)
            contador++; // Incrementa o contador para cada nó encontrado
            temp = temp.getProx(); // Move a referência temporária para o próximo nó da lista
        }
        return contador; // Retorna o número total de nós contados
    }

    public Object buscar (Object obj){
        No temp = inicio; // Cria uma referência temporária para percorrer a lista, começando pelo início
        while(temp != null){ // Enquanto a referência temporária não for nula (ou seja, enquanto houver nós na lista)
            if(temp.getObj().equals(obj)){ // Verifica se o objeto do nó atual é igual ao objeto buscado
                return temp.getObj(); // Se for encontrado, retorna o objeto do nó atual
            }
            temp = temp.getProx(); // Move a referência temporária para o próximo nó da lista
        }
        return null; // Se o objeto não for encontrado na lista, retorna null
    }

    //Basicamente igual ao buscar, mas retorna um booleano indicando se o objeto existe ou não na lista, em vez de retornar o objeto em si.
    public boolean existe (Object obj){
        No temp = inicio; // Cria uma referência temporária para percorrer a lista, começando pelo início
        while(temp != null){ // Enquanto a referência temporária não for nula (ou seja, enquanto houver nós na lista)
            if(temp.getObj().equals(obj)){ // Verifica se o objeto do nó atual é igual ao objeto buscado
                return true; // Se for encontrado, retorna true indicando que o objeto existe na lista
            }
            temp = temp.getProx(); // Move a referência temporária para o próximo nó da lista
        }
        return false; // Se o objeto não for encontrado na lista, retorna false indicando que o objeto não existe na lista
    }

    // Método para remover um objeto da lista
    public void remover(Object obj) {
        No temp = inicio; // Cria uma referência temporária para percorrer a lista, começando pelo início
        No anterior = null; // Cria uma referência para o nó anterior, inicialmente nula
        while (temp != null) { // Enquanto a referência temporária não for nula (ou seja, enquanto houver nós na lista)
            if (temp.getObj().equals(obj)) { // Verifica se o objeto do nó atual é igual ao objeto a ser removido
                
                // caso 1: remover o primeiro nó da lista
                if (anterior == null) { // Se o nó a ser removido for o primeiro nó da lista
                    inicio = temp.getProx(); // Atualiza o início da lista para o próximo nó
                } else { // Se o nó a ser removido não for o primeiro nó da lista

                    // caso 2 e 3: remover do meio ou o último nó da lista
                    anterior.setProx(temp.getProx()); // Atualiza o próximo do nó anterior para pular o nó a ser removido

                    // se removeu o último, atualiza aux
                    if (temp == aux) {// Se o nó a ser removido for o último nó da lista
                        aux = anterior;// Atualiza o auxiliar para o nó anterior, que agora é o último nó da lista
                    }
                }
                return; // Sai do método após remover o nó
            }
            anterior = temp; // Atualiza a referência do nó anterior para o nó atual
            temp = temp.getProx(); // Move a referência temporária para o próximo nó da lista
        }
    }

    //função remover usando booleano para indicar se a remoção foi bem-sucedida ou não
    public boolean removerBoolean(Object obj) {
        No temp = inicio;
        No anterior = null;
        while(temp != null){
            if(temp.getObj().equal(obj)){
                if(anterior == null){
                    inicio = temp.getProx();
                } else {
                    anterior.setProx(temp.getProx());
                    if(temp == aux){
                        aux = anterior;
                    }
                }
                return true; // Retorna true indicando que a remoção foi bem-sucedida
            }
            anterior = temp;
            temp = temp.getProx();
        }
        return false; // Retorna false indicando que o objeto a ser removido não foi encontrado na lista
    }
}
