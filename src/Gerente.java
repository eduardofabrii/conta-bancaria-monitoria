import java.util.ArrayList;

public class Gerente {
    private String nome;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Gerente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarClientes() {
        System.out.println("Clientes do gerente " + nome + ": ");

        for (Cliente cliente : clientes) {
            System.out.println("- " + cliente.getNome() + " | CPF: " + cliente.getCpf() + " | " + cliente.getTelefone());
        }
    }
}
