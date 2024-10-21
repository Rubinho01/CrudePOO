package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoCrud {
	public void inserirProduto(Produto produto) {
		String sql = "INSERT INTO produtos (codProd, DescrProd, precoProd, ativoProd) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = ConexaoMySQL.getConexaoMySQL();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            
				stmt.setInt(1, produto.getCodProd());
	            stmt.setString(2, produto.getDescProd());
	            stmt.setBigDecimal(3, produto.getPrecoProd());
	            stmt.setBoolean(4, produto.isAtivoProd());

	            stmt.executeUpdate();
	            System.out.println("Produto inserido com sucesso!");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
					
	}
	public static void listarProdutos() {
	    String sql = "SELECT * FROM produtos";
	    
	    try (Connection conn = ConexaoMySQL.getConexaoMySQL();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {
	         
	        while (rs.next()) {
	            Produto produto = new Produto(
	                rs.getInt("codProd"),
	                rs.getString("DescrProd"),
	                rs.getBigDecimal("precoProd"),
	                rs.getBoolean("ativoProd")
	            );
	            // Faça algo com o produto, como adicioná-lo a uma lista
	            System.out.println(produto);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
