# Conta Bancaria - monitoria

Projeto simples em Java para praticar Programacao Orientada a Objetos usando uma conta bancaria.

## Enunciado

O programa deve possuir as classes `ContaBancaria`, `Cliente` e `Gerente`.

Cada cliente deve estar associado a uma unica conta bancaria.

Depois que o cadastro do cliente for concluido, ele tambem deve ser associado a um gerente.
Um gerente pode possuir varios clientes.

O menu deve permitir:

1. Cadastrar cliente.
2. Sacar.
3. Depositar.
4. Pedir extrato.
5. Alterar informacoes cadastrais.
6. Listar clientes por gerente.
7. Sair.

## Aulas em video

- Parte 01: https://youtu.be/a5cBNxoFqpc?si=TIy7ZdAMWud2AXAW
- Parte 02: https://youtu.be/7oZmalz_PTI?si=GS0d7wlC5TlLZWkm
- Parte 03: https://youtu.be/BB95R9DGS2c?si=vgWxuXcuuIC65lnK

## Classes do projeto

- `Main.java`: possui o menu e chama as acoes do sistema.
- `Cliente.java`: guarda os dados do cliente e liga o cliente a uma conta e a um gerente.
- `ContaBancaria.java`: controla numero da conta, saldo, deposito, saque e extrato.
- `Gerente.java`: guarda o nome do gerente e a lista de clientes dele.

## Como executar

```bash
cd faculdade/Monitoria/conta-bancaria-monitoria
javac -d out src/*.java
java -cp out Main
```
