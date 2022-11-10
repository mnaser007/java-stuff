package iaas.rest;

	public class Inst<T> {
		Object x;
		T ar[];
		public String getType() {
			if(x instanceof Integer)
				return "int";
			else if(x instanceof Float||x instanceof Double)
				return "decimal number";
			else if(x instanceof String)
				return "text";
			else
				return "---";
		}
		
		public void createArray(T... values) {
			ar=values;
		}
		
		public T[] readArray() {
			return ar;
		}
	}

