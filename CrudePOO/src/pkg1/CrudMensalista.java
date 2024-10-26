package pkg1;
import java.sql.*;
public class CrudMensalista {
	Connection conn = null;
	public void inserirMensalista(associadoMensalista mensalista) {
		String sql = "INSERT INTO mensalistas (cpf_mensalista, nome_mensalista, email_mensalista, mensalidade) VALUES (?,?,?,?)";
		
		try(Connection conn = ConexaoMySQL.getConexaoMySQL();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, mensalista.getCpfAssociado());
            stmt.setString(2, mensalista.getNomeAssociado());
            stmt.setString(3, mensalista.getEmailAssociado());
            stmt.setBigDecimal(4, mensalista.getMensalidadeMensalista());
            
            stmt.executeUpdate();
            System.out.println("Associado Mensalista cadastrado com sucesso!");
			
				
			
		}catch (SQLException e) {
            System.out.println("Erro ao cadastrar Associado");
			e.printStackTrace();
        }
			
	}
	public void listarMensalistas() {
        String sql = "SELECT cpf_mensalista, nome_mensalista, email_mensalista, mensalidade FROM mensalistas";

        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Iterando sobre o ResultSet e imprimindo os dados
            while (rs.next()) {
                String cpf = rs.getString("cpf_mensalista");
                String nome = rs.getString("nome_mensalista");
                String email = rs.getString("email_mensalista");
                double mensalidade = rs.getDouble("mensalidade");

                // Exibindo os dados no console
                System.out.println("CPF: " + cpf + ", Nome: " + nome + ", Email: " + email + ", Mensalidade: " + mensalidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

