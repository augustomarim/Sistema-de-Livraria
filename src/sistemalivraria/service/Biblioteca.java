package sistemalivraria.service;

import sistemalivraria.model.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Biblioteca {
    private List<Livro> livros;
    private List<Autor> autores;
    private List<Emprestimo> emprestimos;
    private List<Cliente> clientes;
    int idClienteAuto = 4;
    int idAutorAuto = 5;
    int idLivroAuto = 10;
    int idEmprestimoAuto = 6;
    Scanner scanner = new Scanner(System.in);

    public Biblioteca() {
        autores = new ArrayList<>();
        livros = new ArrayList<>();
        emprestimos = new ArrayList<>();
        clientes = new ArrayList<>();


        // Dados para sistemalivraria.service.Biblioteca iniciar com Dados Salvos

        Autor a1 = new Autor(1, LocalDate.of(1839, 6, 21) ,"Machado de Assis", true);
        Autor a2 = new Autor(2, LocalDate.of(1920, 12, 10),"Clarice Lispector", true);
        Autor a3 = new Autor(3, LocalDate.of(1892, 1, 3),"J. R. R. Tolkien", true);
        Autor a4 = new Autor(4, LocalDate.of(1903, 6, 25),"George Orwell", true);
        Autor a5 = new Autor(5, LocalDate.of(1832, 1, 17),"Lewis Carroll", true);

        autores.add(a1);
        autores.add(a2);
        autores.add(a3);
        autores.add(a4);
        autores.add(a5);

        livros.add(new Livro(1, "Dom Casmurro", a1, StatusLivro.DISPONIVEL, LocalDate.of(2010, 3, 3), null, "Romance", true));
        livros.add(new Livro(2, "Memórias Póstumas", a1, StatusLivro.DISPONIVEL, LocalDate.of(2011, 4, 17), null, "Romance", true));
        livros.add(new Livro(3, "A Hora da Estrela", a2, StatusLivro.DISPONIVEL, LocalDate.of(2012, 5, 21), null, "Romance", true));
        livros.add(new Livro(4, "Alice No País Das Maravilhas", a5, StatusLivro.DISPONIVEL, LocalDate.of(2013, 6, 9), null, "Fantasia", true));
        livros.add(new Livro(5, "Alice Através do Espelho", a5, StatusLivro.DISPONIVEL, LocalDate.of(2014, 7, 8), null, "Fantasia", true));
        livros.add(new Livro(6, "1984", a4, StatusLivro.DISPONIVEL, LocalDate.of(2015, 8, 12), null, "Ficção Ciêntifica", true));
        livros.add(new Livro(7, "A Revolução dos Bichos", a4, StatusLivro.DISPONIVEL, LocalDate.of(2016, 9, 25), null, "Ficção Ciêntifica", true));
        livros.add(new Livro(8, "O Senhor dos Anéis: A Sociedade do Anel", a3, StatusLivro.DISPONIVEL, LocalDate.of(2017, 10, 24), null, "Fantasia", true));
        livros.add(new Livro(9, "O Senhor dos Anéis: As Duas Torres", a3, StatusLivro.DISPONIVEL, LocalDate.of(2018, 11, 13), null, "Fantasia", true));
        livros.add(new Livro(10, "O Senhor dos Anéis: O Retorno do Rei", a3, StatusLivro.DISPONIVEL, LocalDate.of(2019, 12, 30), null, "Fantasia", true));

        Cliente c1 = new Cliente(1, "Augusto Luiz Marim", "augustoluiz@gmail.com",true);
        Cliente c2 = new Cliente(2, "Geilson Lucas de Souza Silva", "geilsonlucas@gmail.com", true);
        Cliente c3 = new Cliente(3, "Kim Se-jeong", "kim_sejeong@gmail.com", true);
        Cliente c4 = new Cliente(4, "Yoo Yeon-jung", "yeonjung_yoo@gmail.com", true);


        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);

        emprestimos.add(new Emprestimo(1, LocalDate.of(2020, 4, 4), LocalDate.of(2020, 3, 1), c1, livros.get(3), false));
        emprestimos.add(new Emprestimo(2, LocalDate.of(2021, 3, 7), LocalDate.of(2021, 2, 4), c2, livros.get(4), false));
        emprestimos.add(new Emprestimo(3, LocalDate.of(2022, 6, 9), LocalDate.of(2022, 5, 7), c3, livros.get(5), false));
        emprestimos.add(new Emprestimo(4, LocalDate.of(2023, 8, 20), LocalDate.of(2023, 7, 15), c4, livros.get(6), false));
        emprestimos.add(new Emprestimo(5, LocalDate.of(2024, 12, 12), LocalDate.of(2024, 11, 18), c1, livros.get(7), false));
        emprestimos.add(new Emprestimo(6, LocalDate.of(2026, 1, 31), LocalDate.of(2025, 12, 21), c2, livros.get(8), false));
    }

    public void pegarLivro(){
        try{
            System.out.print("\nClientes: ");
            mostrarClientes();
            System.out.print("\nDigite o ID do cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Cliente cliente = buscarCliente(id);
            if (cliente == null) {
                System.out.println("\nsistemalivraria.model.Cliente não encontrado");
                return;
            }
            mostrarLivros();
            System.out.print("\nDigite o ID do livro: ");
            id = scanner.nextInt();
            scanner.nextLine();
            Livro livro = buscarLivros(id);
            if (livro == null) {
                System.out.println("\nsistemalivraria.model.Livro não encontrado");
                return;
            }
            if (livro.getStatus() == StatusLivro.INDISPONIVEL){
                System.out.println("\nsistemalivraria.model.Livro indisponível");
                return;
            }
            livro.setStatus(StatusLivro.INDISPONIVEL);
            Emprestimo emprestimo = new Emprestimo(++idEmprestimoAuto, null, LocalDate.now(), cliente, livro, true);
            emprestimos.add(emprestimo);
            System.out.println("\nEmpréstimo realizado!");
        }
        catch (InputMismatchException e){
            System.out.println("\nID inválido. Digite um número inteiro.");
            scanner.nextLine();

        }

    }

    public void devolverLivro(){
        try{
            mostrarEmprestimosAbertos();
            System.out.print("\nDigite o ID do empréstimo: ");
            int id = scanner.nextInt();
            Emprestimo emprestimo = buscarEmprestimo(id);
            if(emprestimo == null) {
                System.out.println("\nEmpréstimo não encontrado");
                return;
            }
            emprestimo.setDataDevolucao(LocalDate.now());
            emprestimo.setStatus(false);
            Livro livro = emprestimo.getLivro();
            livro.setStatus(StatusLivro.DISPONIVEL);
            System.out.println("\nDevolução realizada!");
        }
        catch (InputMismatchException e){
            System.out.println("\nID inválido. Digite um número inteiro.");
            scanner.nextLine();
        }

    }

    public void adicionarAutor(){
        try{
            System.out.print("\nNome do autor: ");
            String nome = scanner.nextLine();
            System.out.print("\nData de nascimento (dd/MM/yyyy): ");
            String dataString = scanner.nextLine();
            LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Autor autor = new Autor(++idAutorAuto, data ,nome, true);
            autores.add(autor);
            System.out.println("\nsistemalivraria.model.Autor cadastrado!");
        }
        catch(DateTimeParseException e){
            System.out.println("\nData inválida. Use o formato dd/MM/yyyy");
        }
    }

    public void editarAutor(){
        try{
            System.out.print("\nEditar qual autor: ");
            mostrarAutores();
            System.out.print("\nDigite o ID do autor: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Autor autor = buscarAutor(id);
            if (autor == null) {
                System.out.println("\nsistemalivraria.model.Autor não encontrado");
                return;
            }
            System.out.print("\nDeseja editar o nome (1) Sim (0) Não: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao != 0 && opcao != 1) {
                System.out.println("Opção inválida.");
                return;
            }
            if(opcao == 1){
                System.out.print("Qual o novo nome desse autor: ");
                String resposta = scanner.nextLine();
                autor.setNome(resposta);
            }
            System.out.print("\nDeseja editar a data de nascimento (1) Sim (0) Não: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao != 0 && opcao != 1) {
                System.out.println("Opção inválida.");
                return;
            }
            if(opcao == 1){
                System.out.print("Qual a nova data de nascimento desse autor (dd/MM/yyyy) : ");
                String resposta = scanner.nextLine();
                LocalDate data = LocalDate.parse(resposta, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                autor.setDataNascimento(data);
            }
            System.out.println("\nsistemalivraria.model.Autor editado!");
        }
        catch (InputMismatchException e){
            System.out.println("\nResposta inválida. Digite um valor inteiro.");
            scanner.nextLine();
        }
        catch (DateTimeParseException e) {
            System.out.println("\nData inválida. Use o formato dd/MM/yyyy.");
        }
    }

    public void excluirAutor(){
        try {
            System.out.print("\nExcluir qual autor: ");
            mostrarAutores();
            System.out.print("\nDigite o ID do autor: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Autor autor = buscarAutor(id);
            if (autor == null) {
                System.out.println("\nsistemalivraria.model.Autor não encontrado");
                return;
            }
            System.out.print("\nConfirmar ao excluir autor (1) Sim (0) Não: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if(opcao != 0 && opcao != 1){
                System.out.println("Opção inválida.");
                return;
            }
            if(opcao == 0){
                System.out.println("\nVoltando ao menu!");
                return;
            }
            autor.setAtivo(false);
            System.out.println("\nsistemalivraria.model.Autor excluído!");
        }
        catch (InputMismatchException e){
            System.out.println("\nResposta inválida. Digite um valor inteiro.");
            scanner.nextLine();
        }
    }

    public void adicionarCliente(){
        System.out.print("\nNome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Email do cliente: ");
        String email = scanner.nextLine();
        Cliente cliente = new Cliente(++idClienteAuto, nome, email, true);
        clientes.add(cliente);
        System.out.println("\nsistemalivraria.model.Cliente cadastrado!");
    }

    public void editarCliente(){
        try{
            System.out.print("\nEditar qual cliente: ");
            mostrarClientes();
            System.out.print("\nDigite o ID do cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Cliente cliente = buscarCliente(id);
            if (cliente == null) {
                System.out.println("\nsistemalivraria.model.Cliente não encontrado");
                return;
            }
            System.out.print("\nDeseja editar o nome (1) Sim (0) Não: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao != 0 && opcao != 1) {
                System.out.println("Opção inválida.");
                return;
            }
            if(opcao == 1){
                System.out.print("Qual o novo nome desse cliente: ");
                String resposta = scanner.nextLine();
                cliente.setNome(resposta);
            }
            System.out.print("\nDeseja editar o email (1) Sim (0) Não: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao != 0 && opcao != 1) {
                System.out.println("Opção inválida.");
                return;
            }
            if(opcao == 1){
                System.out.print("Qual o novo email desse cliente: ");
                String resposta = scanner.nextLine();
                cliente.setEmail(resposta);
            }
            System.out.println("\nsistemalivraria.model.Cliente editado!");
        }
        catch (InputMismatchException e){
            System.out.println("\nResposta inválida. Digite um valor inteiro.");
            scanner.nextLine();
        }
    }

    public void excluirCliente(){
        try {
            System.out.print("\nExcluir qual cliente: ");
            mostrarClientes();
            System.out.print("\nDigite o ID do cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Cliente cliente = buscarCliente(id);
            if (cliente == null) {
                System.out.println("\nsistemalivraria.model.Cliente não encontrado");
                return;
            }
            System.out.print("\nConfirmar ao excluir cliente (1) Sim (0) Não: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if(opcao != 0 && opcao != 1){
                System.out.println("Opção inválida.");
                return;
            }
            if(opcao == 0){
                System.out.println("\nVoltando ao menu!");
                return;
            }
            cliente.setAtivo(false);
            System.out.println("\nsistemalivraria.model.Cliente excluído!");
        }
        catch (InputMismatchException e){
            System.out.println("\nResposta inválida. Digite um valor inteiro.");
            scanner.nextLine();
        }
    }

    public void adicionarLivro(){
        try {
            System.out.print("\nTítulo do livro: ");
            String titulo = scanner.nextLine();
            System.out.println("sistemalivraria.model.Autor do livro: ");
            mostrarAutores();
            System.out.print("\nDigite o ID do autor: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Autor autor = buscarAutor(id);
            if (autor == null) {
                System.out.println("\nsistemalivraria.model.Autor não encontrado");
                return;
            }
            System.out.print("Gênero do livro: ");
            String genero = scanner.nextLine();
            Livro livro = new Livro(++idLivroAuto, titulo, autor, StatusLivro.DISPONIVEL, LocalDate.now(), null, genero, true);
            livros.add(livro);
        }
        catch (InputMismatchException e){
            System.out.println("\nID inválido. Digite um número inteiro.");
            scanner.nextLine();
        }
    }

    public void editarLivro(){
        try{
            System.out.print("\nEditar qual livro: ");
            mostrarLivros();
            System.out.print("\nDigite o ID do livro: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Livro livro = buscarLivros(id);
            if (livro == null) {
                System.out.println("\nsistemalivraria.model.Livro não encontrado");
                return;
            }
            System.out.print("\nDeseja editar o título (1) Sim (0) Não: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao != 0 && opcao != 1) {
                System.out.println("Opção inválida.");
                return;
            }
            if(opcao == 1){
                System.out.print("Qual o novo título desse livro: ");
                String resposta = scanner.nextLine();
                livro.setTitulo(resposta);
            }
            System.out.print("\nDeseja editar o autor (1) Sim (0) Não: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao != 0 && opcao != 1) {
                System.out.println("Opção inválida.");
                return;
            }
            if(opcao == 1){
                System.out.print("Selecione o novo autor desse livro: ");
                mostrarAutores();
                System.out.print("\nDigite o ID do autor: ");
                id = scanner.nextInt();
                scanner.nextLine();
                Autor autor = buscarAutor(id);
                if (autor == null) {
                    System.out.println("\nsistemalivraria.model.Autor não encontrado");
                    return;
                }
                livro.setAutor(autor);
            }
            livro.setDataAtualizacao(LocalDate.now());
            System.out.print("\nDeseja editar o gênero (1) Sim (0) Não: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao != 0 && opcao != 1) {
                System.out.println("Opção inválida.");
                return;
            }
            if(opcao == 1){
                System.out.print("Qual o novo gênero desse livro: ");
                String resposta = scanner.nextLine();
                livro.setGenero(resposta);
            }
            System.out.println("\nsistemalivraria.model.Livro editado!");
        }
        catch (InputMismatchException e){
            System.out.println("\nResposta inválida. Digite um valor inteiro.");
            scanner.nextLine();
        }
    }

    public void excluirLivro(){
        try {
            System.out.print("\nExcluir qual livro: ");
            mostrarLivros();
            System.out.print("\nDigite o ID do livro: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Livro livro = buscarLivros(id);
            if (livro == null) {
                System.out.println("\nsistemalivraria.model.Livro não encontrado");
                return;
            }
            if(livro.getStatus() == StatusLivro.DISPONIVEL){
                System.out.print("\nConfirmar ao excluir livro (1) Sim (0) Não: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                if(opcao != 0 && opcao != 1){
                    System.out.println("Opção inválida.");
                    return;
                }
                if(opcao == 0){
                    System.out.println("\nVoltando ao menu!");
                    return;
                }
                livro.setAtivo(false);
                System.out.println("\nsistemalivraria.model.Livro excluído!");
            }
            else {
                System.out.println("\nsistemalivraria.model.Livro ainda não devolvido!");
            }
        }
        catch (InputMismatchException e){
            System.out.println("\nResposta inválida. Digite um valor inteiro.");
            scanner.nextLine();
        }
    }

    public void filtrarTitulo(){
        System.out.print("\nDigite parte ou título completo: ");
        String titulo = scanner.nextLine().toLowerCase();
        for (Livro i : livros) {
            if (i.getTitulo().toLowerCase().contains(titulo)) {
                imprimirLivro(i);
            }
        }
    }

    public void filtrarAutor(){
        try{
            System.out.println("\nSelecione o autor: ");
            mostrarAutores();
            System.out.print("\nDigite o ID do autor: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Autor autor = buscarAutor(id);
            if (autor == null) {
                System.out.println("\nsistemalivraria.model.Autor não encontrado.");
                return;
            }
            for (Livro i : livros) {
                if (i.getAutor().equals(autor)) {
                    imprimirLivro(i);
                }
            }
        }
        catch (InputMismatchException e){
            System.out.println("\nID inválido. Digite um número inteiro.");
            scanner.nextLine();
        }
    }

    public void filtrarData(){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.print("\nData inicial (dd/MM/yyyy): ");
            String inicioString = scanner.nextLine();
            LocalDate inicio = LocalDate.parse(inicioString, formatter);
            System.out.print("Data final (dd/MM/yyyy): ");
            String fimString = scanner.nextLine();
            LocalDate fim = LocalDate.parse(fimString, formatter);
            if(inicio.isAfter(fim)) {
                System.out.println("\nA data inicial não pode ser maior que a final.");
                return;
            }
            for(Livro i : livros){
                LocalDate cadastro = i.getDataCadastro();
                if ((cadastro.isEqual(inicio) || cadastro.isAfter(inicio)) &&
                        (cadastro.isEqual(fim) || cadastro.isBefore(fim))) {
                    imprimirLivro(i);
                }
            }
        }
        catch(DateTimeParseException e){
            System.out.println("\nData inválida. Use o formato dd/MM/yyyy.");
        }
    }

    public void filtrarGenero(){
        System.out.print("\nDigite parte ou gênero completo: ");
        String genero = scanner.nextLine().toLowerCase();
        for (Livro i : livros) {
            if (i.getGenero().toLowerCase().contains(genero)) {
                imprimirLivro(i);
            }
        }
    }

    public void mostrarClientes(){
        for(Cliente i: clientes){
            if(i.isAtivo()){
                System.out.println("\nID: " + i.getId());
                System.out.println("Nome: " + i.getNome());
                System.out.println("Email: " + i.getEmail());
            }
        }
    }

    public void mostrarLivros(){
        for(Livro i: livros){
            if(i.isAtivo()){
                System.out.println("\nID: " + i.getId());
                System.out.println("Título: " + i.getTitulo());
                System.out.println("sistemalivraria.model.Autor: " + i.getAutor().getNome());
                System.out.println("Status: " + i.getStatus().getDescricao());
                System.out.println("Data de cadastro: " + i.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Data da última atualização: " + i.getDataAtualizacao());
                System.out.println("Gênero: " + i.getGenero());
            }
        }
    }

    public void imprimirLivro(Livro i){
        if(i.isAtivo()){
            System.out.println("\nID: " + i.getId());
            System.out.println("Título: " + i.getTitulo());
            System.out.println("sistemalivraria.model.Autor: " + i.getAutor().getNome());
            System.out.println("Status: " + i.getStatus().getDescricao());
            System.out.println("Data de cadastro: " + i.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Data da última atualização: " + i.getDataAtualizacao());
            System.out.println("Gênero: " + i.getGenero());
        }
    }

    public void mostrarAutores(){
        for(Autor i: autores){
            if(i.isAtivo()){
                System.out.println("\nID: " + i.getId());
                System.out.println("Nome: " + i.getNome());
                System.out.println("Data de nascimento: " + i.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        }
    }

    public void mostrarEmprestimos(){
        for(Emprestimo i: emprestimos){
            System.out.println("\nID: " + i.getId());
            System.out.println("Data do emprestimo: " + i.getDataEmprestimo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Data da devolução: " + i.getDataDevolucao());
            System.out.println("Nome do cliente: " + i.getCliente().getNome());
            System.out.println("Nome do livro: " + i.getLivro().getTitulo());
        }
    }

    public void mostrarEmprestimosAbertos(){
        for(Emprestimo i: emprestimos){
            if(i.isStatus()){
                System.out.println("\nID: " + i.getId());
                System.out.println("Data do emprestimo: " + i.getDataEmprestimo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Data da devolução: " + i.getDataDevolucao());
                System.out.println("Nome do cliente: " + i.getCliente().getNome());
                System.out.println("Nome do livro: " + i.getLivro().getTitulo());
            }
        }
    }

    public Autor buscarAutor(int id){
        for(Autor i: autores){
           if(i.getId() == id && i.isAtivo()){
               return i;
           }
        }
        return null;
    }

    public Cliente buscarCliente(int id){
        for(Cliente i: clientes){
            if(i.getId() == id && i.isAtivo()){
                return i;
            }
        }
        return null;
    }

    public Livro buscarLivros(int id){
        for(Livro i: livros){
            if(i.getId() == id &&  i.isAtivo()){
                return i;
            }
        }
        return null;
    }

    public Emprestimo buscarEmprestimo(int id){
        for(Emprestimo i: emprestimos){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }

}
