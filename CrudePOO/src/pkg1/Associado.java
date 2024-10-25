
package pkg1;


import java.math.*;
public abstract class Associado {
	private String cpfAssociado;
	private String nomeAssociado;
	private String emailAssociado;
	public Associado(String cpfAssociado, String nomeAssociado, String emailAssociado) {
		this.cpfAssociado = cpfAssociado;
		this.nomeAssociado = nomeAssociado;
		this.emailAssociado = emailAssociado;
	}
	public String getCpfAssociado() {
		return cpfAssociado;
	}
	public void setCpfAssociado(String cpfAssociado) {
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

	
	
	
	
}
