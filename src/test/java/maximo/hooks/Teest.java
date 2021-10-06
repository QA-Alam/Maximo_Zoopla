package maximo.hooks;

public class Teest {

	
	public static void main(String argu[]) {
		String str = "Co22g33ni444zant";
		String str1 =str.replaceAll("[^A-Za-z]", "");
		String str2=str.replaceAll("[^0-9]", "");
		System.out.println("String ="+str1);
		System.out.println("Int = : " + str2);

	
		  String str5 = "Co22g33ni444zant";
		  int cnt = 0;
		  char[] inp = str5.toCharArray();
		  System.out.println("Duplicate Characters are:");
		  for (int i = 0; i < str5.length(); i++) {
		   for (int j = i + 1; j < str5.length(); j++) {
		    if (inp[i] == inp[j]) {
		    	
		     System.out.println(inp[j]);
		     cnt++;
		     break;
		    }
		   }
		  }
		 }
		}
