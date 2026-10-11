import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Gerente> gerentes = new ArrayList<>();
    static int proximoNumeroConta = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    sacar();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    mostrarExtrato();
                    break;
                case 5:
                    alterarCliente();
                    break;
                case 6:
                    listarClientesPorGerente();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 7);
    }

    public static void mostrarMenu() {
        System.out.println();
        System.out.println("---------- BEM VINDO! ----------");
        System.out.println("1. Cadastrar.");
        System.out.println("2. Sacar.");
        System.out.println("3. Depositar.");
        System.out.println("4. Pedir extrato.");
        System.out.println("5. Alterar informações cadastrais.");
        System.out.println("6. Listar clientes por gerente.");
        System.out.println("7. Sair");
        System.out.print("Digite a opção: ");
    }

    public static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Gerente: ");
        String nomeGerente = scanner.nextLine();

        Gerente gerente = buscarGerente(nomeGerente);

        if (gerente == null) {
            gerente = new Gerente(nomeGerente);
            gerentes.add(gerente);
        }

        ContaBancaria conta = new ContaBancaria(proximoNumeroConta);
        proximoNumeroConta++;

        Cliente cliente = new Cliente(nomeCliente, cpf, telefone, conta, gerente);
        clientes.add(cliente);
        gerente.adicionarCliente(cliente);

        System.out.println("Cadastro do cliente feito com sucesso!");
        System.out.println("Número da conta: " + conta.getNumero());
    }

    public static void sacar() {
        Cliente cliente = buscarClientePeloCpf();

        if (cliente == null) {
            System.out.println("Cliente não foi encontrado.");
            return;
        }

        System.out.print("Valor do saque: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        cliente.getConta().sacar(valor);
    }

    public static void depositar() {
        Cliente cliente = buscarClientePeloCpf();

        if (cliente == null) {
            System.out.println("Cliente não foi encontrado.");
            return;
        }

        System.out.print("Valor do deposito: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        cliente.getConta().depositar(valor);
    }

    public static void mostrarExtrato() {
        Cliente cliente = buscarClientePeloCpf();

        if (cliente == null) {
            System.out.println("Cliente não foi encontrado.");
            return;
        }

        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Gerente: " + cliente.getGerente().getNome());
        cliente.getConta().mostrarExtrato();
    }

    public static void alterarCliente() {
        Cliente cliente = buscarClientePeloCpf();

        if (cliente == null) {
            System.out.println("Cliente não foi encontrado.");
            return;
        }

        System.out.println("Novo nome: ");
        String novoNome = scanner.nextLine();

        System.out.println("Novo telefone: ");
        String novoTelefone = scanner.nextLine();

        cliente.setNome(novoNome);
        cliente.setTelefone(novoTelefone);

        System.out.println("Dados foram alterados com sucesso!");
    }

    public static void listarClientesPorGerente() {
        System.out.print("Nome do gerente: ");
        String nomeGerente = scanner.nextLine();

        Gerente gerente = buscarGerente(nomeGerente);

        if (gerente == null) {
            System.out.println("Gerente não foi encontrado.");
            return;
        }

        gerente.listarClientes();
    }

    public static Cliente buscarClientePeloCpf() {
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }


    public static Gerente buscarGerente(String nome) {
        for (Gerente gerente : gerentes) {
            if (gerente.getNome().equalsIgnoreCase(nome)) {
                return gerente;
            }
        }
        return null;
    }
}