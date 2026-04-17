//Diferença entre lista simplesmente liagda e lista circular: 
//a lista circular tem o último nó apontando para o primeiro nó, 
//formando um ciclo, enquanto a lista simplesmente ligada tem o último nó apontando para null.

public class ListaCircular{
    private No inicio;
    private No aux;
    private No atual;

    public ListaDupla(){
        this.inicio = null;
        this.aux = null;
        this.atual = null;
    }

    public void inserir(Object obj){
        if(inicio == null){ // Verifica se a lista está vazia
            inicio = new No(obj, null); // Cria um novo nó com o objeto e aponta para null
            inicio.setProx(inicio); // O próximo nó do início aponta para ele mesmo, formando um ciclo
            aux = inicio; // O auxiliar aponta para o início, pois é o único nó na lista
        }else{
            atual = new No(obj, inicio); // Cria um novo nó com o objeto e aponta para o início da lista
            aux.setProx(atual); // O próximo nó do auxiliar aponta para o novo nó, inserindo-o no final da lista
            aux = atual; //O auxiliar agora aponta para o novo nó, que é o último nó da lista
        }
    }

    public void exibir(){
        if(inicio == null) return; //Como é uma lista circular, se o início for null, a lista está vazia e não há nada para exibir
        No temp = inicio; // Cria um nó temporário para percorrer a lista, começando pelo início

        // O loop do-while é usado para garantir que o código dentro do loop seja executado pelo menos uma vez, 
        //mesmo que a lista tenha apenas um nó. 
        //O loop continua enquanto o nó temporário não voltar ao início da lista, 
        //indicando que todos os nós foram percorridos.
        do{ 
            System.out.println(temp.getObj());
            temp = temp.getProx();
        }while(temp != inicio); 
    }

    public boolean remover(Object obj) {
        // Se a lista estiver vazia, não há nada para remover
        if (inicio == null) {  
            return false;
        }

        No temp = inicio; // Nó temporário para percorrer a lista, começando pelo início
        No anterior = aux; // Nó para manter referência ao nó anterior, começando pelo último nó (aux), pois a lista é circular

        // O loop do-while é usado para garantir que o código dentro do loop seja executado pelo menos uma vez, 
        //mesmo que a lista tenha apenas um nó. O loop continua enquanto o nó temporário não voltar ao início da lista, 
        //indicando que todos os nós foram percorridos.
        do {
            if (temp.getObj().equals(obj)) {

                //lista com um único nó
                // Se o nó a ser removido for o único nó na lista, ou seja, 
                //o início é igual ao auxiliar e o temporário é igual ao início,
                if (inicio == aux && temp == inicio) {
                    inicio = null;
                    aux = null;
                }

                // caso 1: remover o primeiro nó
                // Se o nó a ser removido for o primeiro nó da lista, ou seja, o temporário é igual ao início,
                //então o início da lista é atualizado para o próximo nó do temporário, 
                //e o próximo nó do auxiliar é atualizado para apontar para o novo início, 
                //mantendo a circularidade da lista.
                else if (temp == inicio) {
                    inicio = temp.getProx();
                    aux.setProx(inicio);
                }

                // caso 2: remover o último nó
                // Se o nó a ser removido for o último nó da lista, ou seja, o temporário é igual ao auxiliar,
                //então o auxiliar é atualizado para o nó anterior, e o próximo nó do auxiliar
                //é atualizado para apontar para o início, mantendo a circularidade da lista.
                else if (temp == aux) {
                    aux = anterior;
                    aux.setProx(inicio);
                }

                // caso 3: remover nó do meio
                // Se o nó a ser removido estiver no meio da lista, ou seja, não é o primeiro nem o último nó,
                //então o próximo nó do nó anterior é atualizado para apontar para o próximo nó do temporário,
                //removendo efetivamente o nó do meio da lista.
                else {
                    anterior.setProx(temp.getProx());
                }

                return true;
            }

            anterior = temp;
            temp = temp.getProx();

        } while (temp != inicio);

        return false;
    }

    //Na lista circular, a remoção segue os casos da lista simples, mas é necessário manter a circularidade. 
    //Ao remover o primeiro nó, o último deve apontar para o novo início. 
    //Ao remover o último, o nó anterior passa a ser o novo último e deve apontar para o início. 
    //Ao remover um nó do meio, o nó anterior passa a apontar para o próximo do removido.
}
