package iaas.rest;

public abstract class Car implements Vehicle1, Vehicle2{

	@Override
	public int wheelCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	/*@Override
	public String fuelType() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	@Override
	public String color() {
		return "black";
	}
	
	public int seatCount() {
		return 5;
	}
}

