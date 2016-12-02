package Project466;

import java.util.Scanner;

public class IncomePerson {
	public Integer age = null;
	String workclass = "";
	public Integer edu = null;
	public String marital = "";
	public String occupation = "";
	public String relationship = "";
	public String race = "";
	public String sex = "";
	public Integer hours = null;
	public String country = "";
	public String income = "";
	
	public IncomePerson(){}
	
	public IncomePerson(String infoLine){
		infoLine = infoLine.replace(',', ' ');
		Scanner scan = new Scanner(infoLine);
		
		age = scan.nextInt();
		workclass = scan.next();
		scan.next();
		scan.next();
		edu = scan.nextInt();
		marital = scan.next();
		occupation = scan.next();
		relationship = scan.next();
		race = scan.next();
		sex = scan.next();
		scan.next();
		scan.next();
		hours = scan.nextInt();
		country = scan.next();
		//under50k = scan.next().equals("<=50k");
		income = scan.next();
	}
	public IncomePerson(int age, int edu, int hours){
		this.age = age;
		this.edu = edu;
		this.hours = hours;
	}
	
	public boolean matches(IncomePerson subject){
		if(age != null && age != subject.age)
			return false;
		if(!workclass.isEmpty() && !workclass.equals(subject.workclass))
			return false;
		if(edu != null && edu != subject.edu)
			return false;
		if(!marital.isEmpty() && !marital.equals(subject.marital))
			return false;
		if(!occupation.isEmpty() && !occupation.equals(subject.occupation))
			return false;
		if(!relationship.isEmpty() && !relationship.equals(subject.relationship))
			return false;
		if(!race.isEmpty() && !race.equals(subject.race))
			return false;
		if(!sex.isEmpty() && !sex.equals(subject.sex))
			return false;
		if(hours != null && hours != subject.hours)
			return false;
		if(!country.isEmpty() && !country.equals(subject.country))
			return false;
		if(!income.isEmpty() && !income.equals(subject.income))
			return false;
		return true;
	}
}
