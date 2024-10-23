package pkg1;

import java.math.BigDecimal;

public class associadoMensalista extends Associado implements Valor {

	public associadoMensalista(long cpfAssociado, String nomeAssociado, String emailAssociado) {
		super(cpfAssociado, nomeAssociado, emailAssociado);


}

	@Override
	public double calcularValor() {
		// TODO Auto-generated method stub
		return 0;
	}
}
