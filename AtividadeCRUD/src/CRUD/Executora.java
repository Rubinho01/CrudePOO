package CRUD;

import java.math.BigDecimal;
import java.util.Scanner;

public class Executora {

	public static void main(String[] args) {
		ConexaoMySQL conexao = new ConexaoMySQL();
		conexao.getConexaoMySQL();
		
		/*Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o código do produto: ");
        int codProd = scanner.nextInt();	
        scanner.nextLine();
		
        System.out.print("Digite a descrição do produto: ");
        String descProd = scanner.next();
        scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        BigDecimal precoProd = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.print("O produto está ativo? (true/false): ");
        boolean ativoProd = scanner.nextBoolean();
        scanner.nextLine();
        Produto Produto = new Produto(codProd, descProd,precoProd,ativoProd);
        ProdutoCrud ProdutoCrud = new ProdutoCrud();
        ProdutoCrud.inserirProduto(Produto);

        scanner.close();*/
		
		CRUD.ProdutoCrud.listarProdutos();

	}

}
