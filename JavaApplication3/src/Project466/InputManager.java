/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project466;

import java.util.Scanner;
import java.util.StringJoiner;

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
		Scanner in = new Scanner(System.in);
		System.out.println("  Filter: Work class/sector");
		System.out.println(
				"  1) Private"
					+"  2) Self-emp-not-inc"
					+"  3) Self-emp-inc"
					+"  4) Federal-gov"
					+"  5) Local-gov"
					+"  6) State-gov"
					+"  7) Without-pay"
					+"  8) Never-worked"
		);
		int input = in.nextInt();
		String workClass = "";
		switch(input) {
			case 1:
				workClass = "Private";
				break;
			case 2:
				workClass = "Self-emp-not-inc";
				break;
			case 3:
				workClass = "Self-emp-inc";
				break;
			case 4:
				workClass = "Federal-gov";
				break;
			case 5:
				workClass = "Local-gov";
				break;
			case 6:
				workClass = "State-gov";
				break;
			case 7:
				workClass = "Without-pay";
				break;
			case 8:
				workClass = "Never-Worked";
				break;
			default:
				break;
		}
		ip.workclass = workClass;
		return ip;
	}
	public IncomePerson filterMarital(IncomePerson ip){
		Scanner in = new Scanner(System.in);
		System.out.println("  Filter: Marital status");
		System.out.println(
				"  1) Married-civ-spouse"
				+"  2) Divorced"
				+"  3) Never-married"
				+"  4) Separated"
				+"  5) Widowed"
				+"  6) Married-spouse-absent"
				+"  7) Married-AF-spouse"

		);
		int input = in.nextInt();
		String martialStatus = "";
		switch(input) {
			case 1:
				martialStatus = "Married-civ-spouse";
				break;
			case 2:
				martialStatus = "Divorced";
				break;
			case 3:
				martialStatus = "Never-married";
				break;
			case 4:
				martialStatus = "Separated";
				break;
			case 5:
				martialStatus = "Widowed";
				break;
			case 6:
				martialStatus = "Married-spouse-absent";
				break;
			case 7:
				martialStatus = "Married-AF-spouse";
				break;
			default:
				break;
		}
		ip.marital = martialStatus;
		return ip;
	}
	public IncomePerson filterRace(IncomePerson ip){
		Scanner in = new Scanner(System.in);
		System.out.println("  Filter: Race");
		System.out.println(
				"  1) White"
				+"  2) Black"
				+"  3) Asian / Pacific Islander"
				+"  4) American-Indian / Eskimo"
				+"  5) Other"
		);
		
		int input = in.nextInt();
		String race = "";
		switch(input){
			case 1:
				race = "White";
				break;
			case 2:
				race = "Black";
				break;
			case 3:
				race = "Asian-Pac-Islander";
				break;
			case 4:
				race = "Amer-Indian-Eskimo";
				break;
			case 5:
				race = "Other";
				break;
			default:
				break;
		}
		ip.race = race;
		return ip;
	}
	public IncomePerson filterSex(IncomePerson ip){
		Scanner in = new Scanner(System.in);
		System.out.println("  Filter: Sex");
		System.out.println(
				"  1) Female"
				+"  2) Male"
		);
		int input = in.nextInt();
		String gender = "";
		switch (input) {
			case 1:
				gender = "female";
				break;
			case 2:
				gender = "male";
				break;
			default:
				break;
		}
		ip.sex = gender;
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
