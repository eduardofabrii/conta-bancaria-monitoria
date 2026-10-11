public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private ContaBancaria conta;
    private Gerente gerente;

    public Cliente(String nome, String cpf, String telefone, ContaBancaria conta, Gerente gerente) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.conta = conta;
        this.gerente = gerente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}
