/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project466;

import java.util.Scanner;

/**
 *
 * @author Gideon
 */
public class InputManager {
	
	/**/
	public static IncomePerson getInputPerson(){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Age: ");
		int age = in.nextInt();
		System.out.println("Education: \n"
				+"  16: doctorate\n"
				+"  15: prof school\n"
				+"  14: masters\n"
				+"  13: bachelors\n"
				+"  12: assoc. acdm\n"
				+"  11: assoc. voc\n"
				+"  10: some college\n"
				+"  9: HS grad"
				+"  8: 11th grade\n"
				+"  7"
				+"  6"
				+"  5"
				+"  4: 7-8th grade\n"
				+"  3: 5-6th grade\n"
				+"  2: 1-4th grade\n"
				+"  1: preschool / none\n"
		);
		int edu = in.nextInt();
		System.out.println("Hours: ");
		int hours = in.nextInt();
		
		return new IncomePerson(age, edu, hours);
	}
	
	/**/
	public IncomePerson getFilter(){
		Scanner in = new Scanner(System.in);
		
		int input;
		IncomePerson inputPerson = new IncomePerson();
		do{
			System.out.println("FILTERS:\n"
					+"  1) work class/sector\t"
					+"  2) marital status\n"
					+"  3) race\t\t"
					+"  4) sex\n"
					+"  5) country\t\t"
					+"  6) income\n"
					+"  0) CONTINUE"
			);
			
			input = in.nextInt();
			switch(input){
				case 0:
					break;
				case 1:
					inputPerson = filterWorkclass(inputPerson);
					break;
				case 2:
					filterMarital(inputPerson);
					break;
				case 3:
					filterRace(inputPerson);
					break;
				case 4:
					filterSex(inputPerson);
					break;
				case 5:
					filterCountry(inputPerson);
					break;
				case 6:
					filterIncome(inputPerson);
					break;
				default:
					break;
			}
		}while(input != 0);
		
		return inputPerson;
	}
	
	public IncomePerson filterWorkclass(IncomePerson ip){
		System.out.println("  Filter: Work class/sector");
		return ip;
	}
	public IncomePerson filterMarital(IncomePerson ip){
		System.out.println("  Filter: Marital status");
		return ip;
	}
	public IncomePerson filterRace(IncomePerson ip){
		System.out.println("  Filter: Race");
		return ip;
	}
	public IncomePerson filterSex(IncomePerson ip){
		System.out.println("  Filter: Sex");
		return ip;
	}
	public IncomePerson filterCountry(IncomePerson ip){
		System.out.println("  Filter: Country");
		return ip;
	}
	public IncomePerson filterIncome(IncomePerson ip){
		System.out.println("  Filter: Income");
		return ip;
	}
	
}
