package pkg1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class associadoAnualista extends Associado implements Valor {
    private BigDecimal anualidadeAnualista;
    private BigDecimal taxa = new BigDecimal("1.03");

    public associadoAnualista(String cpfAssociado, String nomeAssociado, String emailAssociado, BigDecimal anualidadeAnualista) {
        super(cpfAssociado, nomeAssociado, emailAssociado);
        this.anualidadeAnualista = anualidadeAnualista;
    }

    public BigDecimal getAnualidadeAnualista() {
        return anualidadeAnualista;
    }

    public void setAnualidadeAnualista(BigDecimal anualidadeAnualista) {
        this.anualidadeAnualista = anualidadeAnualista;
    }

    @Override
    public BigDecimal calcularValor() {
        BigDecimal valor = anualidadeAnualista.multiply(taxa);
        valor = valor.setScale(2, RoundingMode.HALF_UP);
        return valor;
    }
}
