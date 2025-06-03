public class Endereco {

    String CEP;
    String estado;
    String localidade;
    String bairro;
    String logradouro;

    public Endereco(EnderecoRecord endereco) {
        this.CEP = endereco.cep();
        this.estado = endereco.estado();
        this.localidade = endereco.localidade();
        this.bairro = endereco.bairro();
        this.logradouro = endereco.logradouro();
    }

    @Override
    public String toString() {
        String string = "CEP: " + CEP + ";\n";
        if (!estado.isEmpty()) {
            string += ("Estado: " + estado + ";\n");
        }
        if (!localidade.isEmpty()) {
            string += ("Localidade: " + localidade + ";\n");
        }
        if (!bairro.isEmpty()) {
            string += ("Bairro: " + bairro + ";\n");
        }
        if (!logradouro.isEmpty()) {
            string += ("Logradouro: " + logradouro + ".");
        }
        return string;
    }
}
