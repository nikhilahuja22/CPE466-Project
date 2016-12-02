package Project466;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Project {
	static ArrayList<IncomePerson> data = new ArrayList<>();
	static String fname = "income.csv";
	static DataParser dp = new DataParser();
	
	public static void main(String args[]){
		data = dp.parseData();
		getInput();
		System.out.println(getDistance(data.get(0), data.get(1)));
	}
	
	/**/
	public static void getInput(){
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
        
        
        public static void findKNN(IncomePerson key, int k) {
            HashMap<IncomePerson, Double> distanceTable = new HashMap<>();
            
            for(IncomePerson ip : data) {
                distanceTable.put(ip, getDistance(key,ip));
            }
            
            
            
            
        }
}
