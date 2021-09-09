package Day16;

import java.util.Scanner;

public class NumberGame {
	static Scanner sc = new Scanner(System.in);
	int numberOfChance;
	public static void main(String[] args) {
		
		System.out.print("Enter a number :");
		int n = sc.nextInt();

		int chance =(int)Math.ceil(Math.sqrt(n));
		
		NumberGame game = new NumberGame();
		game.findNumber(chance,n);
		
	}
	private void findNumber(int chance, int n) {
		this.numberOfChance = chance;
		int[] array = new int[n];
		for(int i=0;i<array.length-1;i++) {
			array[i] = i+1;
		}
		System.out.println("\nThink a number between "+array[0]+" to "+(n-1));
		binarySearch(array,0,n-1);
	}
	public void binarySearch(int[] array,int low, int max) {
		boolean flag = true;
		while(numberOfChance>0 && low<=max) {
		
			int mid = (low + max) / 2;

			if (flag)
				System.out.println("\nPlease press 1 if your number is equal to " + array[mid]
						+ "\n\nOtherwise press 2 if your number is greater than " + array[mid]
						+ "\n\nOtherwise press 3 if your number is less than " + array[mid]);
			int n = sc.nextInt();

			switch (n) {
			case 2:
				low = mid + 1;
				binarySearch(array, low, max);
				numberOfChance--;
				break;

			case 3:
				max = mid - 1;
				binarySearch(array, low, max);
				numberOfChance--;
				break;
			case 1:
				System.out.println("\nCongratulation!!! Your number is :" + array[mid]);
				numberOfChance--;
				flag = false;
				break;
			}
		}	
	}
}