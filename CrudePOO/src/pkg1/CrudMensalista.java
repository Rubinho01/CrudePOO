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
			
				
			
		}catch (SQLException e) {
            System.out.println("Erro ao cadastrar Associado");
			e.printStackTrace();
        }
			
	}
}
