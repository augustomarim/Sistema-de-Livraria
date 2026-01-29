package sistemalivraria.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean status;

    public Emprestimo(int id, LocalDate dataDevolucao, LocalDate dataEmprestimo, Cliente cliente, Livro livro, boolean status) {
        this.id = id;
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
        this.cliente = cliente;
        this.livro = livro;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDataDevolucao() {
        if(dataDevolucao == null){
            return "Não Devolvido";
        }
        return dataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }


}
