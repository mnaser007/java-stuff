package iaas.rest;

public interface Vehicle1 {
		
			int maxSpeed=120;
			int wheelCount();
			String fuelType();
			default String color() {
				return "white";
			}

		}


