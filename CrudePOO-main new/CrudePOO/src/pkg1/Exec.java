package pkg1;

import java.math.BigDecimal;
import java.util.Scanner;

public class Exec {
    public static void main(String[] args) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        conexao.getConexaoMySQL();
        
        CrudMensalista crudMensalista = new CrudMensalista();
        CrudAnualista crudAnualista = new CrudAnualista(); 
        
        int escolha;
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("Seja Bem-vindo");
            System.out.println("1. Adicionar novo Associado");
            System.out.println("2. Ver lista de Associados");
            System.out.println("3. Excluir Associado");
            System.out.println("4. Calcular Boleto");
            System.out.println("5. Atualizar Associado");
            System.out.print("Digite a opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();
            
            switch (escolha) {
                case 1:
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }
                    System.out.println("1. Adicionar Associado Anualista:");
                    System.out.println("2. Adicionar Associado Mensalista:");
                    System.out.print("Digite a opção: ");
                    int e2 = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (e2) {
                        case 1: // BLOCO ANUALISTA
                            System.out.println("Digite o cpf do Associado:");
                            String cpfAnualista = scanner.next();
                            scanner.nextLine();
                            System.out.println("Digite o nome do Associado:");
                            String nomeAnualista = scanner.next();
                            scanner.nextLine();
                            System.out.println("Digite o E-mail do Associado:");
                            String emailAnualista = scanner.next();
                            scanner.nextLine();
                            System.out.println("Digite o valor da anualidade:");
                            System.out.print("R$");
                            BigDecimal anualidade = scanner.nextBigDecimal();
                            scanner.nextLine();
                            System.out.println("Confirmar Registro?");
                            System.out.println("1. Finalizar registro");
                            System.out.println("2. Cancelar registro");
                            int e3 = scanner.nextInt();
                            scanner.nextLine();
                            
                            switch (e3) {
                                case 1:
                                    associadoAnualista anualista = new associadoAnualista(cpfAnualista, nomeAnualista, emailAnualista, anualidade);
                                    crudAnualista.inserirAnualista(anualista); 
                                    break;
                                case 2:
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {}
                            } // FIM do BLOCO ANUALISTA
                            break;
                        case 2: // BLOCO ADICIONAR MENSALISTA
                            System.out.println("Digite o cpf do Associado:");
                            String cpfMensalista = scanner.next();
                            scanner.nextLine();
                            System.out.println("Digite o nome do Associado:");
                            String nomeMensalista = scanner.next();
                            scanner.nextLine();
                            System.out.println("Digite o E-mail do Associado:");
                            String emailMensalista = scanner.next();
                            scanner.nextLine();
                            System.out.println("Digite o valor da mensalidade:");
                            System.out.print("R$");
                            BigDecimal mensalidade = scanner.nextBigDecimal();
                            scanner.nextLine();
                            System.out.println("Confirmar Registro?");
                            System.out.println("1. Finalizar registro");
                            System.out.println("2. Cancelar registro");
                            int e4 = scanner.nextInt();
                            scanner.nextLine();
                            
                            switch (e4) {
                                case 1:
                                    associadoMensalista mensalista = new associadoMensalista(cpfMensalista, nomeMensalista, emailMensalista, mensalidade);
                                    crudMensalista.inserirMensalista(mensalista);
                                    break;
                                case 2:
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {}
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
                    System.out.print("Digite a opção: ");
                    int e5 = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (e5) {
                        case 1:
                            crudAnualista.listarAnualistas(); // Listar Anualistas
                            System.out.print("Pressione ENTER para sair");
                            scanner.nextLine();
                            break;
                        case 2:
                            crudMensalista.listarMensalistas(); // Listas Mensalistas
                            System.out.print("Pressione ENTER para sair");
                            scanner.nextLine();
                            break;
                    }
                    break;

                case 3: // Excluir associados
                    System.out.println("1. Excluir Associados Anualistas:");
                    System.out.println("2. Excluir Associados Mensalistas:");
                    System.out.print("Digite a opção: ");
                    int e6 = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (e6) {
                        case 1:
                            crudAnualista.listarAnualistas(); // Listar anualistas para exclusão
                            System.out.print("Digite o CPF para cancelamento:");
                            String cpfAnualistaExcluir = scanner.next();
                            scanner.nextLine();
                            System.out.println("Confirmar exclusão?");
                            System.out.println("1. Sim");
                            System.out.println("2. Não");
                            int confirmacao = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (confirmacao == 1) {
                                crudAnualista.excluirAnualista(cpfAnualistaExcluir); // Excluir anualista
                            }
                            break;
                        case 2:
                            crudMensalista.listarMensalistas();
                            System.out.print("Digite o CPF para cancelamento:");
                            String cpfMensalistaExcluir = scanner.next();
                            scanner.nextLine();
                            System.out.println("Confirmar exclusão?");
                            System.out.println("1. Sim");
                            System.out.println("2. Não");
                            confirmacao = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (confirmacao == 1) {
                                crudMensalista.excluirMensalista(cpfMensalistaExcluir);
                            }
                            break;
                    }
                    break;

                case 4: // Calcular Boleto
                    System.out.println("1. Calcular Associados Anualistas:");
                    System.out.println("2. Calcular Associados Mensalistas:");
                    System.out.print("Digite a opção: ");
                    int e7 = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (e7) {
                        case 1: // Cálculo para anualistas
                            crudAnualista.listarAnualistas(); // Listar anualistas
                            System.out.print("Digite o CPF do associado para calcular o valor: ");
                            String cpfAnualistaCalcular = scanner.next();
                            scanner.nextLine();

                            // Buscar o anualista pelo CPF
                            associadoAnualista anualistaCalcular = crudAnualista.buscarAnualistaPorCpf(cpfAnualistaCalcular);
                            if (anualistaCalcular != null) {
                                System.out.println("O valor da anualidade será de: R$" + anualistaCalcular.calcularValor());
                            } else {
                                System.out.println("Anualista não encontrado.");
                            }
                            break;

                        case 2: // Cálculo para mensalistas
                            crudMensalista.listarMensalistas();
                            System.out.print("Digite o CPF do associado para calcular o valor: ");
                            String cpfMensalistaCalcular = scanner.next();
                            scanner.nextLine();

                            // Buscar o mensalista pelo CPF
                            associadoMensalista mensalistaCalcular = crudMensalista.buscarMensalistaPorCpf(cpfMensalistaCalcular);
                            if (mensalistaCalcular != null) {
                                System.out.println("O valor da mensalidade será de: R$" + mensalistaCalcular.calcularValor());
                            } else {
                                System.out.println("Mensalista não encontrado.");
                            }
                            break;
                    }
                    break;
                case 5: 
                	System.out.println("1. Atualizar Associados Anualistas:");
                    System.out.println("2. Atualizar Associados Mensalistas:");
                    System.out.print("Digite a opção: ");
                    int ee = scanner.nextInt();
                    scanner.nextLine();
                    if(ee == 1) {
                    	break;
                    }else if(ee== 2) {
                    	crudMensalista.listarMensalistas();
                    	 System.out.print("Digite o CPF para Aualizar:");
                         String cpfMensalistaAtualizar = scanner.next();
                         
                         System.out.println("Digite o Nome do Associado:");
                         String nomeMensalista = scanner.next();
                         scanner.nextLine();
                         System.out.println("Digite o E-mail do Associado:");
                         String emailMensalista = scanner.next();
                         scanner.nextLine();
                         System.out.println("Digite o valor da mensalidade:");
                         System.out.print("R$");
                         BigDecimal mensalidade = scanner.nextBigDecimal();
                         scanner.nextLine();
                         System.out.println("Confirmar Atualização?");
                         System.out.println("1. Finalizar Atualização");
                         System.out.println("2. Cancelar Atualização");
                         int e4 = scanner.nextInt();
                         scanner.nextLine();
                         switch (e4) {
                         case 1:
                             crudMensalista.atualizarMensalista(nomeMensalista, emailMensalista, mensalidade, cpfMensalistaAtualizar);
                             break;
                         case 2:
                             break;
                         default:
                             System.out.println("Opção inválida");
                         
                         }}
                    break;
                    
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {}
            }
        } while (escolha != 6);
        
        System.out.println("Saindo....");
        scanner.close();
    }
}
