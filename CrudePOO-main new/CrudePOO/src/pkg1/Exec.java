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
            System.out.println("6. Sair");
            System.out.print("Digite a opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    do {
                        System.out.println("1. Adicionar Associado Anualista");
                        System.out.println("2. Adicionar Associado Mensalista");
                        System.out.println("0. Voltar");
                        System.out.print("Digite a opção: ");
                        int e2 = scanner.nextInt();
                        scanner.nextLine();

                        if (e2 == 0) break; // voltar

                        switch (e2) {
                            case 1: // Adicionar Anualista
                                System.out.print("Digite o CPF do Associado: ");
                                String cpfAnualista = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o nome do Associado: ");
                                String nomeAnualista = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o e-mail do Associado: ");
                                String emailAnualista = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o valor da anualidade: R$");
                                BigDecimal anualidade = scanner.nextBigDecimal();
                                scanner.nextLine();

                                associadoAnualista anualista = new associadoAnualista(cpfAnualista, nomeAnualista, emailAnualista, anualidade);
                                crudAnualista.inserirAnualista(anualista);
                                break;

                            case 2: // Adicionar Mensalista
                                System.out.print("Digite o CPF do Associado: ");
                                String cpfMensalista = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o nome do Associado: ");
                                String nomeMensalista = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o e-mail do Associado: ");
                                String emailMensalista = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o valor da mensalidade: R$");
                                BigDecimal mensalidade = scanner.nextBigDecimal();
                                scanner.nextLine();

                                associadoMensalista mensalista = new associadoMensalista(cpfMensalista, nomeMensalista, emailMensalista, mensalidade);
                                crudMensalista.inserirMensalista(mensalista);
                                break;

                            default:
                                System.out.println("Opção inválida");
                        }
                    } while (true);
                    break;

                case 2: // lista dos associados no banco de dados
                    do {
                        System.out.println("1. Visualizar Associados Anualistas");
                        System.out.println("2. Visualizar Associados Mensalistas");
                        System.out.println("0. Voltar");
                        System.out.print("Digite a opção: ");
                        int e5 = scanner.nextInt();
                        scanner.nextLine();

                        if (e5 == 0) break; // voltar

                        switch (e5) {
                            case 1:
                                crudAnualista.listarAnualistas();
                                break;
                            case 2:
                                crudMensalista.listarMensalistas();
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    } while (true);
                    break;

                case 3: // exclusao de associados
                    do {
                        System.out.println("1. Excluir Associado Anualista");
                        System.out.println("2. Excluir Associado Mensalista");
                        System.out.println("0. Voltar");
                        System.out.print("Digite a opção: ");
                        int e6 = scanner.nextInt();
                        scanner.nextLine();

                        if (e6 == 0) break; // voltar

                        switch (e6) {
                            case 1:
                                crudAnualista.listarAnualistas();
                                System.out.print("Digite o CPF para exclusão: ");
                                String cpfAnualistaExcluir = scanner.next();
                                scanner.nextLine();
                                crudAnualista.excluirAnualista(cpfAnualistaExcluir);
                                break;

                            case 2:
                                crudMensalista.listarMensalistas();
                                System.out.print("Digite o CPF para exclusão: ");
                                String cpfMensalistaExcluir = scanner.next();
                                scanner.nextLine();
                                crudMensalista.excluirMensalista(cpfMensalistaExcluir);
                                break;

                            default:
                                System.out.println("Opção inválida");
                        }
                    } while (true);
                    break;

                case 4: // Boleto
                    do {
                        System.out.println("1. Calcular Boleto para Anualista");
                        System.out.println("2. Calcular Boleto para Mensalista");
                        System.out.println("0. Voltar");
                        System.out.print("Digite a opção: ");
                        int e7 = scanner.nextInt();
                        scanner.nextLine();

                        if (e7 == 0) break; // voltar

                        switch (e7) {
                            case 1:
                                crudAnualista.listarAnualistas(); // Calculo dos Anualistas
                                System.out.print("Digite o CPF para calcular: ");
                                String cpfAnualistaCalcular = scanner.next();
                                scanner.nextLine();
                                associadoAnualista anualistaCalcular = crudAnualista.buscarAnualistaPorCpf(cpfAnualistaCalcular);
                                if (anualistaCalcular != null) {
                                    System.out.println("O valor da anualidade será de: R$" + anualistaCalcular.calcularValor());
                                } else {
                                    System.out.println("Anualista não encontrado.");
                                }
                                break;

                            case 2:
                                crudMensalista.listarMensalistas(); // Calculo dos Mensalistas
                                System.out.print("Digite o CPF para calcular: ");
                                String cpfMensalistaCalcular = scanner.next();
                                scanner.nextLine();
                                associadoMensalista mensalistaCalcular = crudMensalista.buscarMensalistaPorCpf(cpfMensalistaCalcular);
                                if (mensalistaCalcular != null) {
                                    System.out.println("O valor da mensalidade será de: R$" + mensalistaCalcular.calcularValor());
                                } else {
                                    System.out.println("Mensalista não encontrado.");
                                }
                                break;

                            default:
                                System.out.println("Opção inválida");
                        }
                    } while (true);
                    break;

                case 5: // aualizar associados
                    do {
                        System.out.println("1. Atualizar Associado Anualista");
                        System.out.println("2. Atualizar Associado Mensalista");
                        System.out.println("0. Voltar");
                        System.out.print("Digite a opção: ");
                        int e8 = scanner.nextInt();
                        scanner.nextLine();

                        if (e8 == 0) break; //voltar

                        switch (e8) {
                            case 1: // atualização dos dados Anualistas
                                crudAnualista.listarAnualistas();
                                System.out.print("Digite o CPF para atualizar: ");
                                String cpfAnualistaAtualizar = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o nome do associado: ");
                                String nomeAnualista = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o e-mail do associado: ");
                                String emailAnualista = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o valor da anuidade: R$");
                                BigDecimal anuidade = scanner.nextBigDecimal();
                                scanner.nextLine();

                                crudAnualista.atualizarAnualista(nomeAnualista, emailAnualista, anuidade, cpfAnualistaAtualizar);
                                break;

                            case 2: // atualização dos dados Mensalitas
                                crudMensalista.listarMensalistas(); // listar mensalistas
                                System.out.print("Digite o CPF para atualizar: ");
                                String cpfMensalistaAtualizar = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o nome do associado: ");
                                String nomeMensalista = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o e-mail do associado: ");
                                String emailMensalista = scanner.next();
                                scanner.nextLine();
                                System.out.print("Digite o valor da mensalidade: R$");
                                BigDecimal mensalidade = scanner.nextBigDecimal();
                                scanner.nextLine();

                                crudMensalista.atualizarMensalista(nomeMensalista, emailMensalista, mensalidade, cpfMensalistaAtualizar);
                                break;

                            default:
                                System.out.println("Opção inválida");
                        }
                    } while (true);
                    break;

                case 6:
                    System.out.println("Encerrando o programa.");
                    break;

               
            }
        } while (escolha != 6);

        System.out.println("Saindo...");
        scanner.close();
    }
}