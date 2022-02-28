public class PalindromeDemo {
    public static void main(String[] args) {
        
		/*
        String testtext = "Madnam !?987 , I'm Adam.";
        System.out.println(isPalindrome(testtext));
		*/
		
		
		/*
		SentenceTool st = new SentenceTool("Testdatei.txt");

        while (st.hasNextSentence()){
            String test = st.nextSentence();
            if (PalindromeTest.isPalindrome(test)){
                System.out.println(test);
            } else {
              //  System.out.println("Dieser Satz war kein Palindrom");
            }

        }
		*/
		
		SentenceTool st = new SentenceTool("Testdatei.txt");
		while (st.hasNextSentence()){
            String test = st.nextSentence();
			System.out.println(test);
		}
    }
}
