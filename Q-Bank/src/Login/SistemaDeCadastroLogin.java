package Login;
import java.util.ArrayList;
import java.util.Scanner;

class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String cpf;

    public Usuario(String nome, String email, String senha, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }
}

class BancoDeDados {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public boolean cadastrarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(usuario.getEmail()) || u.getCpf().equals(usuario.getCpf())) {
                return false;
            }
        }
        usuarios.add(usuario);
        return true;
    }

    public Usuario login(String email, String senha) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null; 
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return u; 
            }
        }
        return null; 
    }
}

public class SistemaDeCadastroLogin {
    private static Scanner scanner = new Scanner(System.in);
    private static BancoDeDados bancoDeDados = new BancoDeDados();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Cadastrar");
            System.out.println("2. Login");
            System.out.println("3. Esqueci a senha");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                cadastrarUsuario();
            } else if (opcao == 2) {
                realizarLogin();
            } else if (opcao == 3) {
                recuperarSenha();
            } else if (opcao == 4) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarUsuario() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nome, email, senha, cpf);
        if (bancoDeDados.cadastrarUsuario(novoUsuario)) {
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.out.println("Email ou CPF já cadastrado. Tente outro.");
        }
    }

    private static void realizarLogin() {
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = bancoDeDados.login(email, senha);
        if (usuario != null) {
            System.out.println("Bem-vindo, " + usuario.getNome() + "!");
            System.out.print("Confirme seu login com 'S' para Sim ou 'N' para Não: ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                System.out.println("Login autorizado!");
            } else {
                System.out.println("Login cancelado.");
            }
        } else {
            System.out.println("Email ou senha incorretos.");
        }
    }

    private static void recuperarSenha() {
        System.out.print("Digite o seu email cadastrado: ");
        String email = scanner.nextLine();

        Usuario usuario = bancoDeDados.buscarUsuarioPorEmail(email);
        if (usuario != null) {
            System.out.print("Confirme o seu CPF: ");
            String cpf = scanner.nextLine();

            if (usuario.getCpf().equals(cpf)) {
                System.out.print("Digite sua nova senha: ");
                String novaSenha = scanner.nextLine();
                usuario.setSenha(novaSenha);
                System.out.println("Senha redefinida com sucesso!");
            } else {
                System.out.println("CPF incorreto.");
            }
        } else {
            System.out.println("Email não encontrado.");
        }
    }
}
