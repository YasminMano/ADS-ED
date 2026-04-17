public class No{
    // O nó tem um objeto, um ponteiro para o próximo nó e um ponteiro para o nó anterior
    private Object obj; 
    private No ant;
    private No prox;

    public No(Object obj, No prox, No ant){
        this.obj = obj;
        this.prox = prox;
        this.ant = ant;
    }

    public Object getObj(){
        return obj;
    }

    public void setObj(Object obj){
        this.obj = obj;
    }

    public No getProx(){
        return prox;
    }

    public void setProx(No prox){
        this.prox = prox;
    }

    public No getAnt(){
        return ant;
    }

    public void setAnt(No ant){
        this.ant = ant;
    }

    @Override
    public String toString(){
        return obj.toString();
    }
}
