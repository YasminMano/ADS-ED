public class No{
    private Object obj; // O tipo do objeto é genérico, pode ser qualquer tipo de dado
    private No prox;?// Referência para o próximo nó da lista

    public No(Object obj, No prox){
        this.obj = obj;// Inicializa o objeto do nó
        this.prox = prox;// Inicializa a referência para o próximo nó
    }

    // Métodos getters e setters para acessar e modificar os atributos do nó
    public Object getObj(){
        return this.obj;
    }

    public void setObj(Object obj){
        this.obj = obj;
    }

    public No getProx(){
        return this.prox;
    }

    public void setProx(No prox){
        this.prox = prox;
    }

    @Override
    public String toString(){
        return this.obj.toString();
    }
}
