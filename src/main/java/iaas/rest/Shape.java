package iaas.rest;

	public abstract class Shape {
		public abstract float area(float x);
		public String drawnBy(String name) {
			return "drawn by "+name;
		}
}
