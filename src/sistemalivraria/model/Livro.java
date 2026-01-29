package sistemalivraria.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private StatusLivro status;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
    private String genero;
    private boolean ativo;

    public Livro(int id, String titulo, Autor autor, StatusLivro status, LocalDate dataCadastro, LocalDate dataAtualizacao, String genero, boolean ativo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.genero = genero;
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getDataAtualizacao() {
        if(dataAtualizacao == null){
            return "Nunca Atualizado";
        }
        return dataAtualizacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public StatusLivro getStatus() {
        return status;
    }

    public void setStatus(StatusLivro status) {
        this.status = status;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
