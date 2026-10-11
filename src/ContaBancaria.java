import java.util.ArrayList;

public class ContaBancaria {
    private int numero;
    private double saldo;
    private ArrayList<String> extrato = new ArrayList<>();

    public ContaBancaria(int numero) {
        this.numero = numero;
        this.saldo = 0;
        extrato.add("Conta criada com saldo inicial de R$0.0");
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor do depósito é inválido");
            return;
        }
        saldo += valor;
        extrato.add("Deposito de R$: " + valor);
        System.out.println("Deposito realizado com sucesso!");
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor do saque é inválido");
            return;
        }

        if (valor > saldo) {
            System.out.println("Saldo insuficiente");
            return;
        }

        saldo -= valor;
        extrato.add("Saque de R$: " + valor);
        System.out.println("Saque realizado com sucesso!");
    }

    public void mostrarExtrato() {
        System.out.println("Conta: " + numero);
        System.out.println("Saldo: R$" + saldo);
        System.out.println("Movimentações: ");

        for (String movimentacao : extrato) {
            System.out.println("- " + movimentacao);
        }
    }
}
