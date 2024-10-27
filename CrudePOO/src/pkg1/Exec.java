package pkg1;
import java.math.BigDecimal;
import java.util.Scanner;


public class Exec {

	public static void main(String[] args) {
		ConexaoMySQL conexao = new ConexaoMySQL();
		conexao.getConexaoMySQL();
		CrudMensalista CrudMensalista = new CrudMensalista();
		
		int escolha;
		
		Scanner scanner = new Scanner(System.in);
		do {
		System.out.println("Seja Bem-vindo");
		System.out.println("1. Adicionar novo Associado");
		System.out.println("2. Ver lista de Associados ");
		System.out.println("3. Excluir Associado");
		System.out.println("4. Calcular Boleto");
		System.out.print("Digite a opção: ");
		escolha = scanner.nextInt();
		scanner.nextLine();
		switch(escolha) {

	    case 1 : 
	        for (int i = 0; i < 50; i++) {
	            System.out.println();
	        }
	        System.out.println("1. Adicionar Associado Anualista:");
	        System.out.println("2. Adicionar Associado Mensalista:");
	        System.out.println("Digite a opção: ");
	        int e2 = scanner.nextInt();
	        scanner.nextLine();
	        
	        switch(e2) {
	            case 1:
	                break;
	            case 2: // BLOCO ADICIONAR MENSALISTA
	                System.out.println("Digite o cpf do Associado:");
	                String cpf = scanner.next();
	                scanner.nextLine();
	                System.out.println("Digite o nome do Associado:");
	                String nome = scanner.next();
	                scanner.nextLine();
	                System.out.println("Digite o E-mail do Associado");
	                String email = scanner.next();
	                scanner.nextLine();
	                System.out.println("Digite o valor da mensalidade");
	                System.out.print("R$"); 
	                BigDecimal mensalidade = scanner.nextBigDecimal();
	                scanner.nextLine();
	                System.out.println("Confirmar Registro?");
	                System.out.println("1. Finalizar registro");
	                System.out.println("2. Cancelar registro");
	                int e3 = scanner.nextInt();
	                scanner.nextLine();
	                
	                switch(e3) {
	                    case 1:
	                        associadoMensalista mensalista = new associadoMensalista(cpf, nome, email, mensalidade);
	                        CrudMensalista.inserirMensalista(mensalista);
	                        break;
	                    case 2:
	                        break;
	                    default:
	                        System.out.println("opção inválida");
	                        try {
	                            Thread.sleep(2000);
	                        } catch(InterruptedException e) {}
	                } // FIM do BLOCO ADICIONAR MENSALISTA
	                break; 
	        }
	        break; 

	    case 2: // Ver Associados
	        for (int i = 0; i < 50; i++) {
	            System.out.println();
	        }
	        System.out.println("1. Visualizar Associados Anualistas:");
	        System.out.println("2. Visualizar Associados Mensalistas:");
	        System.out.println("Digite a opção: ");
	        int e3 = scanner.nextInt();
	        scanner.nextLine();
	        
	        switch(e3) {
	            case 1:
	                break;
	            case 2: // Ver mensalistas
	                CrudMensalista.listarMensalistas();
	                System.out.print("Pressione ENTER para sair");
	                scanner.next();
	                scanner.nextLine();
	                break;
	        }
	        break;

	    case 3: // Excluir associados
	        System.out.println("1. Excluir Associados Anualistas:");
	        System.out.println("2. Excluir Associados Mensalistas:");
	        System.out.println("Digite a opção: ");
	        int e4 = scanner.nextInt();
	        scanner.nextLine();
	        
	        switch(e4) {
	            case 1:
	                break;
	            case 2:
	                CrudMensalista.listarMensalistas();
	                System.out.print("Digite o CPF para cancelamento:");
	                String cpf = scanner.next();
	                scanner.nextLine();
	                System.out.println("Confirmar exclusão?");
	                System.out.println("1. Sim");
	                System.out.println("2. Não");
	                int c = scanner.nextInt();
	                scanner.nextLine();
	                
	                if (c == 1) {
	                    CrudMensalista.excluirMensalista(cpf);
	                }
	                break;
	        }
	        break;

	    case 4:
	    	  System.out.println("1. Calcular Associados Anualistas:");
		        System.out.println("2. Calcular Associados Mensalistas:");
		        System.out.println("Digite a opção: ");
		        int e5 = scanner.nextInt();
		        scanner.nextLine();
		        if(e5==2) {
		        	CrudMensalista.listarMensalistas();
		        	System.out.print("Digite o CPF do associado para calcular o valor: ");
		            String cpf = scanner.next();
		            scanner.nextLine();

		            // Buscar o mensalista pelo CPF
		            associadoMensalista mensalista = CrudMensalista.buscarMensalistaPorCpf(cpf);
		            System.out.println("O valor da mensalidade ano que vem será de:R$"+mensalista.calcularValor());
		        }break;
	    case 6:
	        System.out.println("Encerrando o programa...");
	        break;
	    
	    default:
	        System.out.println("Opção inválida");
	        try {
	            Thread.sleep(2000);
	        } catch(InterruptedException e) {}
	}

		
	}while(escolha!=6);
		System.out.println("Saindo....");
		scanner.close();

}
}

