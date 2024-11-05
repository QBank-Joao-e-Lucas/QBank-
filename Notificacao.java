import java.util.Scanner;

interface NotificacaoInterface {
    void enviarNotificacao(String mensagem);
}

class NotificacaoEmail implements NotificacaoInterface {
    private String emailUsuario;

    public NotificacaoEmail(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Notificação por e-mail enviada para " + emailUsuario + ": " + mensagem);
    }
}

class ContaBancaria {
    private double saldo;
    private NotificacaoInterface notificacao;

    public ContaBancaria(double saldoInicial, NotificacaoInterface notificacao) {
        this.saldo = saldoInicial;
        this.notificacao = notificacao;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        saldo += valor;
        notificacao.enviarNotificacao("Depósito de R$ " + valor + " realizado. Saldo atual: R$ " + saldo);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar o saque.");
        }
        saldo -= valor;
        notificacao.enviarNotificacao("Saque de R$ " + valor + " realizado. Saldo atual: R$ " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Notificacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Digite seu e-mail para notificações: ");
        String email = scanner.nextLine();
        NotificacaoInterface notificacao = new NotificacaoEmail(email);
        ContaBancaria conta = new ContaBancaria(500.0, notificacao);

        while (true) {
            System.out.println("\nSaldo atual: R$ " + conta.getSaldo());
            System.out.println("Escolha uma operação:");
            System.out.println("1: Depositar");
            System.out.println("2: Sacar");
            System.out.println("3: Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    try {
                        conta.depositar(valorDeposito);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: R$ ");
                    double valorSaque = scanner.nextDouble();
                    try {
                        conta.sacar(valorSaque);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
