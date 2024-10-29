package pkg1;

import java.math.BigDecimal;
import java.sql.*;

public class CrudAnualista {
    
    Connection conn = null;

    // Insersão do anualista
    public void inserirAnualista(associadoAnualista anualista) {
        String sql = "INSERT INTO anualistas (cpf_anualista, nome_anualista, email_anualista, anuidade) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
                    
            stmt.setString(1, anualista.getCpfAssociado());
            stmt.setString(2, anualista.getNomeAssociado());
            stmt.setString(3, anualista.getEmailAssociado());
            stmt.setBigDecimal(4, anualista.getAnualidadeAnualista());
                      
            stmt.executeUpdate();
            System.out.println("Associado Anualista cadastrado com sucesso!");
            
        } catch (SQLException e) {
            System.out.println("Erro ao realizar o cadastro do Associado Anualista");
            e.printStackTrace();
        }
    }   
    // Método para excluir associado anualista
    public void excluirAnualista(String cpf) {
        String sql = "DELETE FROM anualistas WHERE cpf_anualista = ?";
        
        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            // análise do erro de linhas
            if (linhasAfetadas > 0) {
                System.out.println("O Anualista com o CPF: " + cpf + " foi excluído com sucesso!");
            } else {
                System.out.println("Nenhum anualista com o CPF: " + cpf + " foi encontrado.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }   
    // Lista dos anualistas
    public void listarAnualistas() {
        String sql = "SELECT cpf_anualista, nome_anualista, email_anualista, anuidade FROM anualistas";
        
        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                String cpf = rs.getString("cpf_anualista");
                String nome = rs.getString("nome_anualista");
                String email = rs.getString("email_anualista");
                BigDecimal anuidade = rs.getBigDecimal("anuidade");
                
                // Dados do associado
                System.out.println("CPF: " + cpf + ", Nome: " + nome + ", Email: " + email + ", Anuidade: " + anuidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Busca do associado anualista pelo CPF
    public associadoAnualista buscarAnualistaPorCpf(String cpf) {
        String sql = "SELECT cpf_anualista, nome_anualista, email_anualista, anuidade FROM anualistas WHERE cpf_anualista = ?";
        associadoAnualista anualista = null;
        
        try (Connection conn = ConexaoMySQL.getConexaoMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
                    
            if (rs.next()) {
                anualista = new associadoAnualista(
                    rs.getString("cpf_anualista"),
                    rs.getString("nome_anualista"),
                    rs.getString("email_anualista"),
                    rs.getBigDecimal("anuidade")
                );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return anualista; // Retorna o associado encontrado ou null se não encontrado
    }
}
