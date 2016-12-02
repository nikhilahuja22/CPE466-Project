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
public class IncomePerson {
	public int age;
	String workclass;
	public int edu;
	public String marital = "";
	public String occupation = "";
	public String relationship = "";
	public String race = "";
	public String sex = "";
	public int hours;
	public String country = "";
	public boolean under50k;
	
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
		under50k = scan.next().equals("<=50k");
	}
	public IncomePerson(int age, int edu, int hours){
		this.age = age;
		this.edu = edu;
		this.hours = hours;
	}
}
