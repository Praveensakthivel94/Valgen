package basic_automation;

import java.text.Collator;
import java.util.stream.IntStream;

public class tes {

	public static void main(String[] args) {
    int n=17;
    boolean checker=true;
    
    if (n<=1) {
    	checker=false;}
    	else{
    		for (int i=2;i<=Math.sqrt(n);i++) {
    			if (n%i==0) {
    			checker=false;
    		}
    	}
 System.out.println(checker);   	
    }
	}
	
}