package pkg1;
import java.util.Scanner;


public class Exec {

	public static void main(String[] args) {
		ConexaoMySQL conexao = new ConexaoMySQL();
		conexao.getConexaoMySQL();
		
		int escolha;
		
		Scanner scanner = new Scanner(System.in);
		do {
		System.out.println("Seja Bem-vindo");
		System.out.println("1. Adicionar novo Associado");
		System.out.println("2. Ver lista de Associados ");
		System.out.println("3. Excluir Associado");
		System.out.println("4. Encerrar Programa");
		System.out.println("Digite a opção: ");
		escolha = scanner.nextInt();
		
	}while(escolha!=4);
		System.out.println("Saindo....");
		scanner.close();

}
}
