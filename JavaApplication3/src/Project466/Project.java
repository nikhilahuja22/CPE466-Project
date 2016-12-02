package Project466;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Project {
	static ArrayList<IncomePerson> data = new ArrayList<>();
	static DataParser dp = new DataParser();
	static InputManager im = new InputManager();
	
	public static void main(String args[]){
		data = dp.parseData();
		IncomePerson inputPerson = im.getInputPerson();
		IncomePerson filter = im.getFilter();
		System.out.println(getDistance(data.get(0), data.get(1)));
	}
	
	/* get 3d distance between 2 people */
	public static double getDistance(IncomePerson a, IncomePerson b){
		double ageWgt = 1, eduWgt = 1, hoursWgt = 1;
		double res =
				Math.sqrt(
						ageWgt * Math.pow( (double)a.age - (double)b.age, 2 )
						+ eduWgt * Math.pow( (double)a.edu - (double)b.edu, 2 )
						+ hoursWgt * Math.pow( (double)a.hours - (double)b.hours, 2 )
				);
		return res;
	}
}
