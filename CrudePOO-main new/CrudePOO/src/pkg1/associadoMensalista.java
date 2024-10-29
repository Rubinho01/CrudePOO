package pkg1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class associadoMensalista extends Associado implements Valor {
	private BigDecimal mensalidadeMensalista;
	private BigDecimal taxa = new BigDecimal("1.05");
	private BigDecimal ano = new BigDecimal("12.00");
	public associadoMensalista(String cpfAssociado, String nomeAssociado, String emailAssociado, BigDecimal mensalidadeMensalista) {
		super(cpfAssociado, nomeAssociado, emailAssociado);
		this.mensalidadeMensalista = mensalidadeMensalista;

}

	public BigDecimal getMensalidadeMensalista() {
		return mensalidadeMensalista;
	}

	public void setMensalidadeMensalista(BigDecimal mensalidadeMensalista) {
		this.mensalidadeMensalista = mensalidadeMensalista;
	}

	



	@Override
	public BigDecimal calcularValor() {
		BigDecimal valor = mensalidadeMensalista.multiply(ano);
		valor = valor.multiply(taxa);
		valor = valor.divide(ano,RoundingMode.HALF_UP);
		valor = valor.setScale(2, RoundingMode.HALF_UP);
		return valor;
	}
}
