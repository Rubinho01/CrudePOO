package pkg1;

import java.math.BigDecimal;

public class associadoAnualista extends Associado implements Valor {
	private BigDecimal anualidadeAnualista;
	private static double taxa = 0.03;
	
	public associadoAnualista(long cpfAssociado, String nomeAssociado, String emailAssociado, BigDecimal anualidadeAnualista) {
		super(cpfAssociado, nomeAssociado, emailAssociado);
		this.anualidadeAnualista = anualidadeAnualista; 
	}

	@Override
	public double calcularValor() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
