package com.gio.vo;

public class TaxIncome {
	private String tax_type;
	private int sum;
	public String getTax_type() {
		return tax_type;
	}
	public void setTax_type(String tax_type) {
		this.tax_type = tax_type;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "TaxIncome [tax_type=" + tax_type + ", sum=" + sum + "]";
	}
	
}
