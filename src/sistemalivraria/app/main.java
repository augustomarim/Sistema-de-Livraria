package sistemalivraria.app;

import sistemalivraria.service.Biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    static Scanner scanner = new Scanner(System.in);
    static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args){
        try{
            boolean ligado = true;
            while(ligado){
                System.out.println("\nMenu");
                System.out.println("Digite (0) para sair do programa");
                System.out.println("Digite (1) para cadastrar um cliente");
                System.out.println("Digite (2) para editar cliente");
                System.out.println("Digite (3) para cadastrar um livro");
                System.out.println("Digite (4) para editar um livro");
                System.out.println("Digite (5) para cadastrar um autor");
                System.out.println("Digite (6) para editar um ator");
                System.out.println("Digite (7) para retirar um livro");
                System.out.println("Digite (8) para devolver um livro");
                System.out.println("Digite (9) para listar todos os clientes");
                System.out.println("Digite (10) para listar todos os livros");
                System.out.println("Digite (11) para filtrar busca por livros");
                System.out.println("Digite (12) para listar todos os autores");
                System.out.println("Digite (13) para listar todos os empréstimos\n");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                switch(opcao){
                    case 0:
                        System.out.println("Saindo do programa\n");
                        ligado = false;
                        break;
                    case 1:
                        biblioteca.adicionarCliente();
                        break;
                    case 2:
                        System.out.println("\nDeseja editar ou apagar cliente:");
                        System.out.println("Digite (0) para voltar ao menu");
                        System.out.println("Digite (1) para editar cliente");
                        System.out.println("Digite (2) para apagar cliente\n");
                        opcao = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcao){
                            case 0:
                                System.out.println("\nVoltando ao menu");
                                break;
                            case 1:
                                biblioteca.editarCliente();
                                break;
                            case 2:
                                biblioteca.excluirCliente();
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente\n");
                        }
                        break;
                    case 3:
                        biblioteca.adicionarLivro();
                        break;
                    case 4:
                        System.out.println("\nDeseja editar ou apagar livro:");
                        System.out.println("Digite (0) para voltar ao menu");
                        System.out.println("Digite (1) para editar livro");
                        System.out.println("Digite (2) para apagar livro\n");
                        opcao = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcao){
                            case 0:
                                System.out.println("\nVoltando ao menu");
                                break;
                            case 1:
                                biblioteca.editarLivro();
                                break;
                            case 2:
                                biblioteca.excluirLivro();
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente\n");

                        }
                        break;
                    case 5:
                        biblioteca.adicionarAutor();
                        break;
                    case 6:
                        System.out.println("\nDeseja editar ou apagar autor:");
                        System.out.println("Digite (0) para voltar ao menu");
                        System.out.println("Digite (1) para editar autor");
                        System.out.println("Digite (2) para apagar autor\n");
                        opcao = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcao){
                            case 0:
                                System.out.println("\nVoltando ao menu");
                                break;
                            case 1:
                                biblioteca.editarAutor();
                                break;
                            case 2:
                                biblioteca.excluirAutor();
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente\n");
                        }
                        break;
                    case 7:
                        biblioteca.pegarLivro();
                        break;
                    case 8:
                        biblioteca.devolverLivro();
                        break;
                    case 9:
                        biblioteca.mostrarClientes();
                        break;
                    case 10:
                        biblioteca.mostrarLivros();
                        break;
                    case 11:
                        System.out.println("\nDeseja filtrar livros por:");
                        System.out.println("Digite (0) para voltar ao menu");
                        System.out.println("Digite (1) para filtrar por título");
                        System.out.println("Digite (2) para filtrar por autor");
                        System.out.println("Digite (3) para filtrar por data de cadastro");
                        System.out.println("Digite (4) para filtrar por gênero\n");
                        opcao = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcao){
                            case 0:
                                System.out.println("\nVoltando ao menu");
                                break;
                            case 1:
                                biblioteca.filtrarTitulo();
                                break;
                            case 2:
                                biblioteca.filtrarAutor();
                                break;
                            case 3:
                                biblioteca.filtrarData();
                                break;
                            case 4:
                                biblioteca.filtrarGenero();
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente\n");
                        }
                        break;
                    case 12:
                        biblioteca.mostrarAutores();
                        break;
                    case 13:
                        biblioteca.mostrarEmprestimos();
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente\n");
                }   }
        }
        catch (InputMismatchException e){
            System.out.println("\nResposta inválida. Digite um valor inteiro.");
            scanner.nextLine();
        }

    }
}
