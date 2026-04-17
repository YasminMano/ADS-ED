//A estrutra do nó da lista ciruclar, é o mesmo da lista simples

public class No{
    private Object obj; 
    private No prox;

    public No(Object obj, No prox){
        this.obj = obj;
        this.prox = prox;
    }

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
