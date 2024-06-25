import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int eta;
    private String indirizzo;

    public Cliente(String nome, int eta, String indirizzo) {
        this.nome = nome;
        this.eta = eta;
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() {
        return "Cliente{nome='" + nome + "', eta=" + eta + ", indirizzo='" + indirizzo + "'}";
    }
}
