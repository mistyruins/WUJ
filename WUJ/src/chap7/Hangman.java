package chap7;

import java.io.*;

public class Hangman {

	String hiddenString;
	StringBuffer outputString;
	StringBuffer inputString;
	int reminder ; // ������ ���ڼ�
	int failed;
	
	
	public Hangman() {
		hiddenString = "Hello"; // ����
	}
	
	public int playGame() {
		outputString = new StringBuffer(); // ���ڿ��� ����� �����϶��� buffer �ʼ�
		
		for(int i=0; i<hiddenString.length(); i++) {
			outputString.append('_'); // ���ڼ���ŭ ����ǥ�� 
		}
		
		inputString = new StringBuffer();
		reminder = hiddenString.length();
		failed = 0 ; 
		
		System.out.println("\n�ܾ� : " + hiddenString.length() + " ���� : " + outputString);
		drawMan(); // ������ �׸��� �޼��� 
		
		do{
			checkChar(readChar());
			System.out.println("\n�ܾ� : " + hiddenString.length() + " ���� : " + outputString);
		drawMan();
		}while(reminder>0 && failed<6 );
		
		return failed;
	}

	
	public void checkChar(char guess) {
		boolean already = false; 
		for(int i=0; i<inputString.length(); i++) {
			if(inputString.charAt(i) == guess) {
				System.out.println("�̹� �Է��� ����");
				already = true;
			}
		} // ���� �Է¿��� ���� üũ 
		
		if(!already) {
			inputString.append(guess); // �Է��� �� ������ inputString�� ����
			
			//�Է¹��ڿ� ���� �� ���� 
			boolean success = false;
			for(int i=0; i<hiddenString.length(); i++) {
				if(hiddenString.charAt(i)==guess) {
					outputString.setCharAt(i, guess); // ������ ��¿� ���� ����
					reminder--;
					success = true;
				}
			}
			if(!success) failed++; // ����� �Է� ���� �� ���Ƶ� ��ġ���� ������ ����
		}
	}

	public char readChar() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char userInput = 0;
		System.out.println("�� ���� ���ڸ� �Է��ϼ��� : ");
		try {
			userInput = (char) in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInput;
		
	}

	private void drawMan() {
		System.out.println("  ����������������");
		System.out.println("  �� ��    ��");
		
		switch(failed) {
			case 0:
				System.out.println("         ��");
				System.out.println("         ��");
				System.out.println("         ��");
				System.out.println("         ��");
				System.out.println("         ��");
				System.out.println("         ��");
				break; // �ʼ�!! 
			case 1:
				System.out.println("  ��      ��");
				System.out.println("         ��");
				System.out.println("         ��");
				System.out.println("         ��");
				System.out.println("         ��");
				System.out.println("         ��");
				break; 
			case 2:
				System.out.println("  ��      ��");
				System.out.println(" �Ǧ���     ��");
				System.out.println("         ��");
				System.out.println("         ��");
				System.out.println("         ��");
				System.out.println("         ��");
				break; 
			case 3:
				System.out.println("  ��      ��");
				System.out.println(" �Ǧ�      ��");
				System.out.println("  ��      ��");
				System.out.println("         ��");
				System.out.println("         ��");
				System.out.println("         ��");
				break; 
			case 4:
				System.out.println("  ��      ��");
				System.out.println(" �Ǧ���     ��");
				System.out.println("  ��      ��");
				System.out.println("         ��");
				System.out.println("         ��");
				System.out.println("         ��");
				break; 
			case 5:
				System.out.println("  ��      ��");
				System.out.println(" �Ǧ���     ��");
				System.out.println("  ��      ��");
				System.out.println(" �Ǧ�      ��");
				System.out.println(" ��       ��");
				System.out.println("         ��");
				break; 
			case 6:
				System.out.println("  ��      ��");
				System.out.println(" �Ǧ���     ��");
				System.out.println("  ��      ��");
				System.out.println(" �Ǧզ�     ��");
				System.out.println(" �� ��     ��");
				System.out.println("         ��");
				break; 
		}
	}

	
}