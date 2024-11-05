import java.sql.*;

public class UsuarioDAO {

    private static final String URL = "banco bancario";
    private static final String USER = "seu usuario";
    private static final String PASSWORD = "sua senha";

    public void cadastrarUsuario(String nome, String email, String senha, String cpf) {
        String hashedSenha = Utilidades.hashSenha(senha);

        String sql = "INSERT INTO usuarios (nome, email, senha, cpf) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, hashedSenha);
            stmt.setString(4, cpf);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário cadastrado com sucesso.");
            } else {
                System.out.println("Falha ao cadastrar o usuário.");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Erro: Email ou CPF já cadastrado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean fazerLogin(String email, String senha) {
        String hashedSenha = Utilidades.hashSenha(senha);

        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            stmt.setString(2, hashedSenha);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login bem-sucedido. Bem-vindo, " + rs.getString("nome") + "!");
                return true;
            } else {
                System.out.println("Falha no login: Email ou senha incorretos.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void recuperarSenha(String email) {
        String senhaTemporaria = Utilidades.gerarSenhaTemporaria();
        String senhaHash = Utilidades.hashSenha(senhaTemporaria);

        String sql = "UPDATE usuarios SET senha = ? WHERE email = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, senhaHash);
            stmt.setString(2, email);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Uma nova senha temporária foi gerada e enviada para o email.");
                System.out.println("Senha temporária (para teste): " + senhaTemporaria); 
            } else {
                System.out.println("Erro: Email não encontrado no sistema.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
