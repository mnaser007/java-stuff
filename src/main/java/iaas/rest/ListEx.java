package iaas.rest;

import java.util.List;
import java.util.Arrays;

public class ListEx {
	public List<Integer> addValues(Integer...integers) {
		List<Integer> list=Arrays.asList(integers);
		return list;
	}
}
