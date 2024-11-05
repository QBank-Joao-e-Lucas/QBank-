import java.util.Scanner;

public class BancoBancario {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Banco Bancário");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Cadastro");
        System.out.println("2. Login");
        System.out.println("3. Recuperação de Senha");

        int escolha = scanner.nextInt();
        scanner.nextLine(); 

        switch (escolha) {
            case 1:
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine();
                System.out.println("Digite seu email:");
                String emailCadastro = scanner.nextLine();
                System.out.println("Digite sua senha:");
                String senhaCadastro = scanner.nextLine();
                System.out.println("Digite seu CPF:");
                String cpf = scanner.nextLine();

                usuarioDAO.cadastrarUsuario(nome, emailCadastro, senhaCadastro, cpf);
                break;

            case 2:
                System.out.println("Digite seu email:");
                String emailLogin = scanner.nextLine();
                System.out.println("Digite sua senha:");
                String senhaLogin = scanner.nextLine();

                usuarioDAO.fazerLogin(emailLogin, senhaLogin);
                break;

            case 3:
                System.out.println("Digite seu email para recuperação de senha:");
                String emailRecuperacao = scanner.nextLine();
                
                usuarioDAO.recuperarSenha(emailRecuperacao);
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }

        scanner.close();
    }
}
