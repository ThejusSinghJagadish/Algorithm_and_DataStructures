package com.algorithms_and_datastructures.palindromes.palindrome_permutation;
import java.util.*;

public class PalindromePermutation {
	static List<String> permutation;
	public static List<String> allPermutation(String s){
		permutation = new ArrayList<>();
		List<String> result = new ArrayList<>();
		String mid = "";
		if(isPalindrome(s)){
			char[] chArr = s.substring(0, s.length()/2).toCharArray();
			Arrays.sort(chArr);
			findAllPerm(new String(chArr), new StringBuilder());
		}
		if(s.length() != 0)
			mid = String.valueOf(s.charAt(s.length()/2));
		for(String str: permutation){
			StringBuilder sb = new StringBuilder(str);
			String reverse = sb.reverse().toString();
			result.add(str+mid+reverse);
		}
		return result;
	}

	public static void findAllPerm(String s, StringBuilder sb){
		if(s.length() == 0){
			permutation.add(sb.toString());
			return;
		}
		Set<Character> set = new HashSet<>();
		for(int i=0; i<s.length(); i++){
			if(set.contains(s.charAt(i)))
				continue;
			set.add(s.charAt(i));
			sb.append(s.charAt(i));
			findAllPerm(s.substring(0, i)+s.substring(i+1), sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static boolean isPalindrome(String s){
		int low = 0;
		int high = s.length()-1;
		while(low < high){
			if(s.charAt(low++) != s.charAt(high--))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "malayalam";
		System.out.println(allPermutation(s));
		
	}

}
