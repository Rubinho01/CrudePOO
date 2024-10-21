
package pkg1;


import java.math.*;
public class Associado {
	private long cpfAssociado;
	private String nomeAssociado;
	private String emailAssociado;
	private BigDecimal valorMensalidade;
	private boolean tipoAssociado; //false = Mensalista e true = Anualista
	public Associado(long cpfAssociado, String nomeAssociado, String emailAssociado, BigDecimal valorMensalidade,
		boolean tipoAssociado) {
		this.cpfAssociado = cpfAssociado;
		this.nomeAssociado = nomeAssociado;
		this.emailAssociado = emailAssociado;
		this.valorMensalidade = valorMensalidade;
		this.tipoAssociado = tipoAssociado;
	}
	public long getCpfAssociado() {
		return cpfAssociado;
	}
	public void setCpfAssociado(long cpfAssociado) {
		this.cpfAssociado = cpfAssociado;
	}
	public String getNomeAssociado() {
		return nomeAssociado;
	}
	public void setNomeAssociado(String nomeAssociado) {
		this.nomeAssociado = nomeAssociado;
	}
	public String getEmailAssociado() {
		return emailAssociado;
	}
	public void setEmailAssociado(String emailAssociado) {
		this.emailAssociado = emailAssociado;
	}
	public BigDecimal getValorMensalidade() {
		return valorMensalidade;
	}
	public void setValorMensalidade(BigDecimal valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}
	public boolean isTipoAssociado() {
		return tipoAssociado;
	}
	public void setTipoAssociado(boolean tipoAssociado) {
		this.tipoAssociado = tipoAssociado;
	}
	
	@Override
	public String toString() {
		return "Associado [cpfAssociado=" + cpfAssociado + ", nomeAssociado=" + nomeAssociado + ", emailAssociado="
				+ emailAssociado + ", valorMensalidade=" + valorMensalidade + ", tipoAssociado=" + tipoAssociado + "]";
	}
	
	
	
	
}
