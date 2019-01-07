import java.util.HashMap;

public class Converter {
	public void convert(String str) {
		
		
		try {
			
			int number = Integer.parseInt(str);
			String roman = "";
			System.out.println("number");
			while(number >= 1000) {
				number -= 1000;
				roman += "M";
			}
			while(number >= 500) {
				number -= 500;
				roman += "D";
			}
			while(number >= 100) {
				number -= 100;
				roman += "C";
			}
			while(number >= 50) {
				number -= 50;
				roman += "L";
			}
			while(number >= 10) {
				number -= 10;
				roman += "X";
			}
			while(number >= 5) {
				number -= 5;
				roman += "V";
			}
			while(number >= 1) {
				number -= 1;
				roman += "I";
			}
			if(roman.contains("LXXXX")) {
				roman = roman.replaceAll("LXXXX","XC");
			}
			if(roman.contains("XXXX")) {
				roman = roman.replaceAll("XXXX","XL");
			}
			
			if(roman.contains("VIIII")) {
				roman = roman.replaceAll("VIIII","IX");
			}
			if(roman.contains("IIII")) {
				roman = roman.replaceAll("IIII","IV");
			}
			System.out.println(roman);
			
			
			
		}
		catch(Exception e) {
			System.out.println("roman numeral");
			
			HashMap<String, Integer> map = new HashMap<>();
			map.put("I", 1);
			map.put("V", 5);
			map.put("X", 10);
			map.put("L", 50);
			map.put("C", 100);
			map.put("D", 500);
			map.put("M", 1000);
			
			String[] romans = str.split("");
			int sum = 0;
			for(int i=0;i<romans.length;i++) {
				if(i+1<romans.length && (romans[i]+romans[i+1]).equals("XC")) {
					sum += 90;
					i++;
					continue;
				}
				if(i+1<romans.length && (romans[i]+romans[i+1]).equals("XL")) {
					sum += 40;
					i++;
					continue;
				}
				if(i+1<romans.length && (romans[i]+romans[i+1]).equals("IX")) {
					sum += 9;
					i++;
					continue;
				}
				if(i+1<romans.length && (romans[i]+romans[i+1]).equals("IV")) {
					sum += 4;
					i++;
					continue;
				}
				sum += map.get(romans[i]);
			}
			System.out.println(sum);
		}
	}
}
