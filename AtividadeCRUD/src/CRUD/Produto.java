package CRUD;

import java.math.BigDecimal;

public class Produto {
	private int codProd;
	private String DescProd;
	private BigDecimal precoProd;
	private boolean ativoProd;
	public Produto(int codProd, String descProd, BigDecimal precoProd, boolean ativoProd) {
		this.codProd = codProd;
		DescProd = descProd;
		this.precoProd = precoProd;
		this.ativoProd = ativoProd;
	}
	public int getCodProd() {
		return codProd;
	}
	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}
	public String getDescProd() {
		return DescProd;
	}
	public void setDescProd(String descProd) {
		DescProd = descProd;
	}
	public BigDecimal getPrecoProd() {
		return precoProd;
	}
	public void setPrecoProd(BigDecimal precoProd) {
		this.precoProd = precoProd;
	}
	public boolean isAtivoProd() {
		return ativoProd;
	}
	public void setAtivoProd(boolean ativoProd) {
		this.ativoProd = ativoProd;
	}
	
	public String toString() {
        return "Produto{" +
                "codProd=" + codProd +
                ", descProd='" + DescProd + '\'' +
                ", precoProd=" + precoProd +
                ", ativoProd=" + ativoProd +
                '}';
    }
	
}
