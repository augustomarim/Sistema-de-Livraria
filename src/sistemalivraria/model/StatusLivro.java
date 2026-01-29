package sistemalivraria.model;

public enum StatusLivro {
    DISPONIVEL("Disponível"),
    INDISPONIVEL("Indisponível");

    private String descricao;

    StatusLivro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
