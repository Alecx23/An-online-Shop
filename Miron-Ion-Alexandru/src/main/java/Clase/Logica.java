package Clase;

public class Logica {

public static boolean verifyPass(String pass) {
		
		
	
		int q=0;
		if(pass.length()>=8) {
			for(int i=0;i<pass.length()&&q==0;i++) 
				if('a'<=pass.charAt(i) && pass.charAt(i)<='z') 
					q=1;
		
			if(q==1) {
				q=0;
				for(int i=0;i<pass.length() && q==0;i++) 
					if('A'<=pass.charAt(i)&&pass.charAt(i)<='Z') 
						q=1;
				
			}
			if(q==1) {
				q=0;
				for(int i=0;i<pass.length() && q==0;i++) 
					if('0'<=pass.charAt(i)&&pass.charAt(i)<='9') 
						q=1;	
			}
			if(q==1) {
				q=0;
				for(int i=0;i<pass.length() && q==0;i++) 
					if(('!'<=pass.charAt(i) && pass.charAt(i)<='/') || ('{'<=pass.charAt(i) && pass.charAt(i)<='~')) {
						q=1;
					} else if((':'<=pass.charAt(i)&&pass.charAt(i)<='@') || ('['<=pass.charAt(i) && pass.charAt(i)<='`'))
						q=1;
			}		
	    }
		
		if(q==1) return true;
		else return false;
    }
}
