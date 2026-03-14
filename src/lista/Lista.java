package lista;
import modelo.Produto;

public class Lista{
    private No inicio;
    private No atual;
    private No aux;

    public void insserir(Produto produto){
        if(inicio == null){
            inicio = new No(produto, null);
            aux=inicio;
        }else{
            atual=new No(produto, null);
            aux.setProximo(atual);
            aux=atual;
        }
    }
}