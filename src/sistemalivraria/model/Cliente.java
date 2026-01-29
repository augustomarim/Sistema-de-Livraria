package sistemalivraria.model;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private boolean ativo;

    public Cliente(int id, String nome, String email, boolean ativo) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
