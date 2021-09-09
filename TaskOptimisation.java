package Day16;


import java.util.Scanner;

public class TaskOptimisation {

	int[] deadlineArray, timeArray;
	int count;
	
	public static void main(String[] args) {
		
		TaskOptimisation optimisation = new TaskOptimisation();
		optimisation.start();
	}
	
	

	void start() {
		
		Scanner scanner = new Scanner(System.in);	
		
		System.out.print("Enter Number of tasks: ");
		count = scanner.nextInt();	
		
		deadlineArray = new int[count];
		timeArray = new int[count];	
		
		
		for(int i = 0; i < count; i++) {
			System.out.print("Enter deadline and time required for the task number :" + (i+1) + " ");;
			deadlineArray[i] = scanner.nextInt();
			timeArray[i] = scanner.nextInt();
		}
		scanner.close();
		
		insertionSortAsc();
		
		
		for(int i = 0; i < count; i++) {
			System.out.print("Enter deadline and time required for the task number :" + (i+1) +" ");;
			System.out.print(deadlineArray[i] + "\t");
			System.out.print(timeArray[i]);
			System.out.println();
		}
		
		doTask();
	}
	
	
	void insertionSortAsc() {
		for(int i = 1; i < deadlineArray.length; i++) {
			int deadlineKey = deadlineArray[i];
			int timeKey = timeArray[i];
			int j = i - 1;
			while((j > -1) && (deadlineArray[j] > deadlineKey)) {				
				deadlineArray[j+1] = deadlineArray[j];
				timeArray[j+1] = timeArray[j];
				j--;
			}
			deadlineArray[j+1] = deadlineKey;
			timeArray[j+1] = timeKey;
		}
	}
	
	
	
	void doTask() {
		for(int i = 0; i < count; i++) {
			System.out.println("Task " + (i+1) + ":" + timeArray[i]);
		}
	}
}