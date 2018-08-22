public class Thing {
	private final String thing;
	public Thing(String thing) {
		this.thing  = thing;
	}

	public char getSymbol() {
		return thing.charAt(0);
	}
}