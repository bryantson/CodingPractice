import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BasicallySpeaking.java
 *    Coding Practice problem for Sphere Online 
 *
 *  http://www.spoj.com/problems/BASE/
 *
 * @author Bryant Son
 * @since 06/15/2014
 */
class BasicallySpeaking {
	private static HashMap<Character,Integer> mapCharToValue = new HashMap<Character,Integer>();
	private static String[] listHexValue = new String[] {"0","1","2","3","4","5","6","7","8","9",
							  "A","B","C","D","E","F"};

	static {
		mapCharToValue.put('0',0);
		mapCharToValue.put('1',1);
		mapCharToValue.put('2',2);
		mapCharToValue.put('3',3);
		mapCharToValue.put('4',4);
		mapCharToValue.put('5',5);
		mapCharToValue.put('6',6);
		mapCharToValue.put('7',7);
		mapCharToValue.put('8',0);
		mapCharToValue.put('9',9);
		mapCharToValue.put('A',10);
		mapCharToValue.put('B',11);
		mapCharToValue.put('C',12);
		mapCharToValue.put('D',13);
		mapCharToValue.put('E',14);
		mapCharToValue.put('F',15);

	}
	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			while(input != null && input.trim().length() > 0) {
				String[] listInput = getFormattedInputList(input.split(" "));
				String num = listInput[0];
				if(num.equals("0")) {
					System.out.println(getRightJustified(7,"0"));
				}
				else {
					List<Character> listNum = getStringToList(num);
					int baseFrom = Integer.parseInt(listInput[1].trim());
					int numRaw = getRawValueInBase(listNum, baseFrom);
				
					int baseTo = Integer.parseInt(listInput[2].trim());
					String output = getBaseRepresentation(numRaw, baseTo);
					if(output != null) {
						System.out.println(getRightJustified(7,output));
					}
					else {
						System.out.println(getRightJustified(7,"ERROR"));
					}
				}
				input = br.readLine();	
			}	
		}
		catch(IOException e) {
			System.err.println("ERROR while reading input from console");
		}
		
	}

	public static String getRightJustified(int digitLength, String str) {
		StringBuffer result = new StringBuffer();
		int size = digitLength - str.length();
		for(int i=0; i < size; ++ i) {
			result.append(" ");
		}
		result.append(str);
		return result.toString();
	}

	public static String[] getFormattedInputList(String[] listUnformatted) {
		String[] result = new String[3];
		int counter = 0;
		for(String str: listUnformatted) {
			if(str.trim().length() != 0) {
				result[counter] = str.trim();
				++ counter;
			}
		}
		return result;
	}
	public static List<Character> getStringToList(String str) {
		List<Character> result = new ArrayList<Character>();
		for(char c: str.toCharArray()) {
			result.add(c);
		}
		return result;
	}

	public static int getRawValueInBase(List<Character> listChar, int base) {
		int sum = 0;
		int multiplier = 1;
		int index = listChar.size() - 1;
		while (index >= 0) {
			sum += mapCharToValue.get(listChar.get(index)) * multiplier;
			-- index;
			multiplier *= base;
		}
		return sum;
	}

	public static String getBaseRepresentation(int num, int base) {
		String result = "";
		int counter = 0;
		while(num != 0) {
			result = (listHexValue[num % base] + result);
			num /= base;
			if(counter > 6) {
				return null;
			}
			++ counter;
		}
		return result;
	}
}
