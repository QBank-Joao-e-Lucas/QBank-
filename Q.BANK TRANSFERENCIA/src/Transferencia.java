import java.util.Scanner;

public class Transferencia {
    private String numeroConta;
    private String titular;
    private double saldo;

    public Transferencia(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque!");
        }
    }

    public void transferir(Transferencia destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " para a conta " + destino.getNumeroConta() + " realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número da conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Digite o nome do titular: ");
        String titular = scanner.nextLine();

        Transferencia conta = new Transferencia(numeroConta, titular);

        System.out.print("Digite o valor a ser depositado: R$ ");
        double valorDeposito = scanner.nextDouble();
        conta.depositar(valorDeposito);

        System.out.print("Digite o valor a ser sacado: R$ ");
        double valorSaque = scanner.nextDouble();
        conta.sacar(valorSaque);

        scanner.nextLine();
        System.out.print("Digite o número da conta de destino: ");
        String numeroContaDestino = scanner.nextLine();
        
        System.out.print("Digite o nome do titular da conta de destino: ");
        String titularDestino = scanner.nextLine();
        
        Transferencia contaDestino = new Transferencia(numeroContaDestino, titularDestino);
        
        System.out.print("Digite o valor a ser transferido: R$ ");
        double valorTransferencia = scanner.nextDouble();
        conta.transferir(contaDestino, valorTransferencia);

        scanner.close();
    }
}

