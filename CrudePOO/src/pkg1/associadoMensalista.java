package pkg1;

import java.math.BigDecimal;

public class associadoMensalista extends Associado implements Valor {
	private BigDecimal mensalidadeMensalista;
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
	public double calcularValor() {
		// TODO Auto-generated method stub
		return 0;
	}
}
