package pkg1;
import java.math.BigDecimal;
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
	public void excluirMensalista(String cpf) {
        String sql = "DELETE FROM mensalistas WHERE cpf_mensalista = ?";

        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Mensalista com CPF " + cpf + " foi excluído com sucesso!");
            } else {
                System.out.println("Nenhum mensalista encontrado com o CPF " + cpf);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	 public associadoMensalista buscarMensalistaPorCpf(String cpf) {
	        String sql = "SELECT cpf_mensalista, nome_mensalista, email_mensalista, mensalidade FROM mensalistas WHERE cpf_mensalista = ?";
	        associadoMensalista mensalista = null;

	        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, cpf);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                mensalista = new associadoMensalista(
	                    rs.getString("cpf_mensalista"),
	                    rs.getString("nome_mensalista"),
	                    rs.getString("email_mensalista"),
	                    rs.getBigDecimal("mensalidade")
	                );
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return mensalista; // Retorna o objeto ou null se não encontrado
	    }
	 public void atualizarMensalista(String nome,String email, BigDecimal mensalidade, String cpf) {
		 String sql = "UPDATE mensalistas SET nome_mensalista = ?, email_mensalista = ?, mensalidade = ? WHERE cpf_mensalista = ? ";
		 try (Connection conn = ConexaoMySQL.getConexaoMySQL();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
			 stmt.setString(1, nome);
			 stmt.setString(2, email);
			 stmt.setBigDecimal(3, mensalidade);
			 stmt.setString(4, cpf);
			 stmt.executeUpdate();
			 
			 int linhasAfetadas = stmt.executeUpdate();
	            if (linhasAfetadas > 0) {
	                System.out.println("Mensalista do cpf" +""+  cpf +""+ "alterado com Sucesso");
	            } else {
	                System.out.println("Nenhum mensalista encontrado com o CPF " + cpf);
	            }
			
	 }catch (SQLException e) {
		 System.out.print("CPF Inválido");
         e.printStackTrace();
     }

}
}

