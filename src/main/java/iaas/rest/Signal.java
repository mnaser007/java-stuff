package iaas.rest;

public enum Signal { //singal type object or enum type object
	
	RED("stop",30),YELLOW("wait",5),GREEN("move",20);
	String action;
	int time;
	Signal(String action,int time) {
		this.action=action;
		this.time=time;
		
	}
}