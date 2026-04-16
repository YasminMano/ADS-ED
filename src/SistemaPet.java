public class SistemaPet {
    public static void main(String[] args) {
        MetodosPet.inserir(new Pet("Luna", 3, "Cachorro"));
        MetodosPet.inserir(new Pet("Mingau", 2, "Gato"));
        MetodosPet.inserir(new Pet("Bidu", 5, "Cachorro"));

        System.out.println("=== Lista original ===");
        MetodosPet.exibir();

        System.out.println("\n=== Pesquisar id 2 ===");
        Pet p = MetodosPet.pesquisar(2);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Não encontrado!");
        }

        System.out.println("\n=== Atualizar idade do id 1 ===");
        if (MetodosPet.atualizar(1, 10)) {
            System.out.println("Atualizado com sucesso!");
        } else {
            System.out.println("Pet não encontrado!");
        }

        System.out.println("\n=== Lista ordenada por nome ===");
        MetodosPet.ordenarPorNome();
        MetodosPet.exibir();
    }
}
