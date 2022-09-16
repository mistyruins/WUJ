package chap7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Hangman2 extends Hangman {
	
	String[] words = {"fever","poison","victim","drug","hygine"};
	String[] meaning = {"열","독","환자","약","위생학"}; // 나중에 2차원 배열로 

	public Hangman2() {
		Random ran = new Random();
		int random = Math.abs(ran.nextInt() % words.length);
		hiddenString = words[random];
		System.out.println("\n의미: " + meaning[random]);
	}
	
	public char readChar() {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char userInput = 0;
		
		try {
			do{
				System.out.println("문자를 입력하세요 (힌트는 ?) : ");
				userInput = (char) bf.read();
			
			if(userInput == '?') {
				boolean giveHint = false;
				int i = 0;
				while (!giveHint) {
					if(outputString.charAt(i)=='_') {
						System.out.println();
						System.out.println("힌트 : "+ hiddenString.charAt(i));
						System.out.println();
						failed++;
						giveHint = true;
					}
					i++;
				}
			}

			}while(userInput == '?');
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		
		return userInput;
		}
	}
}
