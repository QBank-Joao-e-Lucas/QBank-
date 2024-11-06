import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Date;

class Usuario {
    private String username;
    private String senha;
    private String tipoUsuario;
    private boolean contaBloqueada;

    public Usuario(String username, String senha, String tipoUsuario) {
        this.username = username;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.contaBloqueada = false;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public boolean isContaBloqueada() {
        return contaBloqueada;
    }

    public void bloquearConta() {
        this.contaBloqueada = true;
    }

    public void desbloquearConta() {
        this.contaBloqueada = false;
    }

    public boolean verificarLogin(String username, String senha) {
        return this.username.equals(username) && this.senha.equals(senha);
    }
}

class Seguranca {
    private static final Map<String, Usuario> usuarios = new HashMap<>();
    private static final Map<String, Integer> tentativasDeLogin = new HashMap<>();
    private static final Map<String, Date> bloqueioDeConta = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Usuario usuario = new Usuario("cliente1", "senha123", "cliente");
        usuarios.put(usuario.getUsername(), usuario);

        int limiteTentativas = 3;
        long tempoBloqueio = 300000; // 5 minutos

        while (true) { 
            System.out.print("Digite seu nome de usuário: ");
            String usernameInput = scanner.nextLine();

            if (!usuarios.containsKey(usernameInput)) {
                System.out.println("Usuário não encontrado.");
                continue; 
            }

            Usuario usuarioAtual = usuarios.get(usernameInput);

            if (usuarioAtual.isContaBloqueada()) {
                Date horaBloqueio = bloqueioDeConta.get(usernameInput);
                long tempoRestante = tempoBloqueio - (new Date().getTime() - horaBloqueio.getTime());
                if (tempoRestante > 0) {
                    System.out.println("Conta bloqueada! Tente novamente em " + tempoRestante / 1000 + " segundos.");
                    continue;
                } else {
                    usuarioAtual.desbloquearConta();
                    bloqueioDeConta.remove(usernameInput);
                    System.out.println("Sua conta foi desbloqueada. Tente novamente.");
                }
            }

            System.out.print("Digite sua senha: ");
            String senhaInput = scanner.nextLine();

            if (usuarioAtual.verificarLogin(usernameInput, senhaInput)) {
                System.out.println("Login bem-sucedido! Agora, por favor, insira o código de autenticação de dois fatores.");

                Random random = new Random();
                int codigo = random.nextInt(999999); 
                System.out.println("Código de 2 fatores: " + codigo);

                System.out.print("Digite o código de 2 fatores: ");
                int codigoInput = scanner.nextInt();

                if (codigo == codigoInput) {
                    System.out.println("Autenticação de dois fatores bem-sucedida!");

                    if ("cliente".equals(usuarioAtual.getTipoUsuario())) {
                        System.out.println("Bem-vindo ao sistema bancário, cliente!");
                    } else {
                        System.out.println("Bem-vindo, gerente!");
                    }

                    registrarLog(usernameInput, "Login bem-sucedido.");
                    break;
                } else {
                    System.out.println("Código de autenticação inválido.");
                    registrarLog(usernameInput, "Falha na autenticação de dois fatores.");
                }
            } else {
                System.out.println("Login falhou! Verifique seu nome de usuário e senha.");
                registrarLog(usernameInput, "Falha no login.");

                int tentativas = tentativasDeLogin.getOrDefault(usernameInput, 0);
                tentativas++;

                if (tentativas >= limiteTentativas) {
                    usuarioAtual.bloquearConta();
                    bloqueioDeConta.put(usernameInput, new Date());
                    System.out.println("Muitas tentativas falhas. Sua conta foi bloqueada por 5 minutos.");
                } else {
                    tentativasDeLogin.put(usernameInput, tentativas);
                    System.out.println("Você tem " + (limiteTentativas - tentativas) + " tentativas restantes.");
                }
            }
        }

        scanner.close();
    }

    private static void registrarLog(String username, String mensagem) {
        Date dataHora = new Date();
        System.out.println("LOG [" + dataHora + "] - Usuário: " + username + " - " + mensagem);
    }
}

