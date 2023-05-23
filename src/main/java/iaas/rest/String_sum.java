package iaas.rest;

public class String_sum {

	
	static int strScore(String str[], String s, int n)
	{
	    int score = 0, index=0;
	    for (int i = 0; i < n; i++) {
	        if (str[i] == s) {
	            for (int j = 0; j < s.length(); j++)
	                score += s.charAt(j) - 'a' + 1;
	            index = i + 1;
	            break;
	        }
	    }
	    score = score * index;
	    return score;
	}
	 
	// Driver code
	 
	 
	    /*public static void main (String[] args) {
	            String str[] = { "sahil", "shashanak"
	                    , "sanjit", "abhinav", "mohit" };
	    String s = "abhinav";
	    int n = str.length;
	    int score = strScore(str, s, n);
	    System.out.println( score);
	    }*/
	}

