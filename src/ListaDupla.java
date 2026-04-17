public class ListaDupla{
    private No inicio;
    private No aux;
    private No atual;

    public ListaDupla(){
        this.inicio = null;
        this.aux = null;
        this.atual = null;
    }

    public void inserir(Object obj){
        if(inicio == null){ // Lista vazia
            inicio = new No(obj, null, null); // Cria o primeiro nó
            aux = inicio; // Auxiliar aponta para o início
        }else{
            atual = new No(obj, aux, null);// Cria um novo nó com o objeto, apontando para o nó anterior (aux) e sem próximo
            aux.setProx(atual); // O nó anterior (aux) agora aponta para o novo nó (atual)
            aux = atual; // Atualiza o auxiliar para o novo nó, tornando-o o último da lista
        }
    }

    //Exibir fim para inicio
    public void exibirFimParaInicio(){
        No temp = aux; // Começa do último nó (aux)
        while(temp != null){ // Enquanto não chegar ao início da lista
            System.out.println(temp.getObj()); // Exibe o valor do nó atual
            temp = temp.getAnt(); // Move para o nó anterior
        }
    }

    //Exibir inicio para fim
    public void exibirInicioParaFim(){  
        No temp = inicio; // Começa do primeiro nó (inicio)
        while(temp != null){ // Enquanto não chegar ao final da lista
            System.out.println(temp.getObj()); // Exibe o valor do nó atual
            temp = temp.getProx(); // Move para o próximo nó
        }
    }

    //Remover um elemento específico
    public void remover(Object obj){
        No temp = inicio; // Começa do primeiro nó
        while(temp != null){ // Percorre a lista
            if(temp.getObj().equals(obj)){ // Verifica se o valor do nó é igual ao objeto a ser removido
                if(temp == inicio){ // Se for o primeiro nó
                    inicio = temp.getProx(); // Atualiza o início para o próximo nó
                    if(inicio != null){ // Se a lista não ficar vazia
                        inicio.setAnt(null); // O novo início não tem nó anterior
                    }
                }else if(temp == aux){ // Se for o último nó
                    aux = temp.getAnt(); // Atualiza o auxiliar para o nó anterior
                    if(aux != null){ // Se a lista não ficar vazia
                        aux.setProx(null); // O novo último nó não tem próximo
                    }
                }else{ // Se for um nó intermediário
                    temp.getAnt().setProx(temp.getProx()); // O nó anterior aponta para o próximo do nó atual
                    temp.getProx().setAnt(temp.getAnt()); // O próximo do nó atual aponta para o anterior do nó atual
                }
                return; // Elemento removido, sai do método
            }
            temp = temp.getProx(); // Move para o próximo nó
        }
    }

    // Na lista duplamente ligada, cada nó conhece o anterior e o próximo. 
    //Por isso, na remoção de um nó do meio, 
    //é possível ajustar tanto o prox do nó anterior quanto o ant do nó seguinte, 
    //sem depender de uma variável separada para guardar o anterior.
}
