package data_structures.arrays_strings.palindrome;

public class Palindrome {
    public static void main(String[] args) {
        boolean isPalindrome = true;
        String str = "++++1%$^&*&^%^%#%^%&^*&2+1+++1+++2+++++1+++++";
        str = str.toLowerCase();
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            Character chi = str.charAt(i);
            Character chj = str.charAt(j);
            if (Character.isLetterOrDigit(chi) && Character.isLetterOrDigit(chj)) {
                if (str.charAt(i) != str.charAt(j)) {
                    isPalindrome = false;
                    break;
                }
                i++;
                j--;
            } else {

                if (!Character.isLetterOrDigit(chi)) {
                    i++;
                }

                if (!Character.isLetterOrDigit(chj)) {
                    j--;
                }
            }
        }

        System.out.println("isPalindrome " + isPalindrome);
    }
}
