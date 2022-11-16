package iaas.rest;

public class Vote {
	boolean canVote(int age) {
		if(age<18)
			return false;
		else
			return true;
	}
}
