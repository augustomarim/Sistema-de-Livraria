package sistemalivraria.model;

import java.time.LocalDate;

public class Autor {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private boolean ativo;

    public Autor(int id, LocalDate dataNascimento, String nome, boolean ativo) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
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

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
