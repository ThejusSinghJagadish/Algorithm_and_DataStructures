package com.algorithms_and_datastructures.integer2english;

//Input: 1234567891
//Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"


public class Integer2EnglishWord {
	private String[] units = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	private String[] teens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixieen", "Seventeen", "Eighteen", "Nineteen"};
	private String[] tens = new String[]{"", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
	
	public String int2eng(int num){
		StringBuilder result = new StringBuilder();
		
		int billion = num/1000000000;
		if(billion > 0)
			result.append(hundreds(billion)).append(" ").append("Billion").append(" ");
		
		num -= billion*1000000000;
		
		int million = num/1000000;
		if(million > 0)
			result.append(hundreds(million)).append(" ").append("Million").append(" ");
		
		num -= million*1000000;
		
		int thousand = num/1000;
		if(thousand > 0)
			result.append(hundreds(thousand)).append(" ").append("Thousand").append(" ");
		
		num -= thousand*1000;
		if(num > 0)
			result.append(hundreds(num));
		
		return result.toString().trim();
	}
	
	public String hundreds(int num){
		StringBuilder sb = new StringBuilder();
		int hundred = num / 100;
		if(hundred > 0)
			sb.append(units[hundred]).append(" ").append("Hundred");
		
		num -= hundred*100;
		
		if(num > 0)
			sb.append(" ").append(tens(num));
		
		return sb.toString();
	}
	
	public String tens(int num){
		StringBuilder sb = new StringBuilder();
		int ten = num/10;
		num -= ten * 10;
		if(ten == 1){
			return teens[num];
		}
		sb.append(tens[ten]).append(" ").append(units[num]);
		return sb.toString();
	}
	
}
