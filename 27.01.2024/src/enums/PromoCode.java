package enums;

public enum PromoCode {
	A(10), B(15), C(20);

	private int val;

	private PromoCode(int val) {
		this.val = val;
		
	}
	public int getVal() {
		return this.val;
	}
}
