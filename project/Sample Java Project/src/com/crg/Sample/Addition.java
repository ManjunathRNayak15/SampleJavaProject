package com.crg.Sample;

import java.util.Scanner;

public class Addition {

	public static void main(String[] args) {
		Scanner scanInput  = new Scanner(System.in);
		System.out.print("Enter the First Number : ");
		int firstNum = scanInput.nextInt();
		System.out.print("Enter the Second Number : ");
		int secondNum = scanInput.nextInt();
		int sum = firstNum + secondNum;
		System.out.println("The Sum of the Two Numbers is : "+sum);
	}
}
