package com.task62;
import java.util.HashMap;

public class G_7_Duplicate_Characters_Using_HashMap {

	public static void main(String[] args) {

	    String str = "programming";

	    HashMap<Character, Integer> map = new HashMap<>();

	    for (char ch : str.toCharArray()) {
	        map.put(ch, map.getOrDefault(ch, 0) + 1);
	    }

	    System.out.println("Duplicate Characters:");

	    for (char ch : map.keySet()) {
	        if (map.get(ch) > 1) {
	            System.out.println(ch + " = " + map.get(ch));
	        }
	    }
	}
}
