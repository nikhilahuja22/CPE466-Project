package Project466;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Project {
	static ArrayList<IncomePerson> data = new ArrayList<>();
	static ArrayList<IncomePerson> filteredData;
	static DataParser dp = new DataParser();
	static InputManager im = new InputManager();
	
	public static void main(String args[]){
		data = dp.parseData();
		IncomePerson inputPerson = im.getInputPerson();
		IncomePerson filter = im.getFilter();
		System.out.println(getDistance(data.get(0), data.get(1)));
                
                List<IncomePerson> nearestNeighbors = findKNN(inputPerson, 50);
                
                for(IncomePerson ip : nearestNeighbors) {
                    System.out.println(ip.toString());
                }
		filteredData = filterData(data, filter);
	}
	
	public static ArrayList<IncomePerson> filterData(ArrayList<IncomePerson> al, IncomePerson filter){
		ArrayList<IncomePerson> fal = new ArrayList<>();
		for(int i=0; i<al.size(); i++){
			if(filter.matches(al.get(i))){
				fal.add(al.get(i));
			}
		}
		System.out.println("Filter run. "+(al.size()-fal.size())+" tuples removed.");
		return fal;
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
        
        
        public static List<IncomePerson> findKNN(IncomePerson key, int k) {
            
            
            ArrayList<IncomePerson> ipsWithDist= new ArrayList<>();
            for(IncomePerson ip : data) {
                ip.getDistance(key);
                ipsWithDist.add(ip);
            }
            
            Collections.sort(ipsWithDist);
            
            return  ipsWithDist.subList(0, k);
            

        }
}
