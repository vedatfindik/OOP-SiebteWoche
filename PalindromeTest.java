public class PalindromeTest {
	
    //test if text is a sentence palindrome
    public static boolean isPalindrome (String text){

        String work = text.toLowerCase().replaceAll("\\W", "");

		if (work.length() <= 1) return true;
		
		else if ( work.charAt(0) == work.charAt(work.length()-1) )
			return isPalindrome(work.substring(1, work.length()-1));
		
		else return false;
    }
	
}


