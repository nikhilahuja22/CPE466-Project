package Project466;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;
import java.util.Set;
import java.util.Iterator;

public class Project {

	static boolean debug = true;
        static final int bagSize = 50;
	static ArrayList<IncomePerson> data = new ArrayList<>();
	static DataParser dp = new DataParser();
	static InputManager im = new InputManager();

	public static void main(String args[]) {
		data = dp.parseData();
                double kNNRatio = 0.25;
		IncomePerson inputPerson = im.getInputPerson();
		IncomePerson filter = im.getFilter();

		System.out.println("Filter: "+filter);
		data = filterData(data, filter);
		
		List<IncomePerson> nearestNeighbors = findKNN(data, inputPerson, 50,kNNRatio);

		for (IncomePerson ip : nearestNeighbors) {
			System.out.println(ip.toString());
		}
                //printBaggingResult(bagging(data, "income", .33));
		System.out.println("Most probable category: "+ mostProbableCategory("income", nearestNeighbors));
                printBaggingResult(bagging(data, inputPerson, "income", .33));
	}

	public static ArrayList<IncomePerson> filterData(ArrayList<IncomePerson> al, IncomePerson filter) {
		ArrayList<IncomePerson> fal = new ArrayList<>();
		for (int i = 0; i < al.size(); i++) {
			//System.out.println(al.get(i).race);
			if (filter.matches(al.get(i))) {
				fal.add(al.get(i));
			}
		}
		System.out.println("Filter run. " + (al.size() - fal.size()) + " tuples removed.");
		return fal;

	}

	/* get 3d distance between 2 people */
	public static double getDistance(IncomePerson a, IncomePerson b) {
		double ageWgt = 1, eduWgt = 1, hoursWgt = 1;
		double res
				= Math.sqrt(
						ageWgt * Math.pow((double) a.age - (double) b.age, 2)
						+ eduWgt * Math.pow((double) a.edu - (double) b.edu, 2)
						+ hoursWgt * Math.pow((double) a.hours - (double) b.hours, 2)
				);
		return res;
	}


	public static List<IncomePerson> findKNN(ArrayList<IncomePerson> dataSet, 
         IncomePerson key, int k, double kNNRatio) {
                //System.out.println("kNNfunction");

		ArrayList<IncomePerson> ipsWithDist = new ArrayList<>();
		for (IncomePerson ip : dataSet) {
			ip.getDistance(key);
			ipsWithDist.add(ip);
		}

		Collections.sort(ipsWithDist);

		return ipsWithDist.subList(0, k);

	}
        
        public static ArrayList<String> bagging(ArrayList<IncomePerson> data, 
         IncomePerson person, String category, double ratio) {
        
            ArrayList<IncomePerson> dataSet = new ArrayList<IncomePerson>();
            ArrayList<String> result = new ArrayList<String>();
            Random randomGenerator = new Random();
            
            for(int i = 0; i < bagSize; i++) {
                //System.out.println("bag");
                for(int j = 0; j < (int)(ratio * data.size()); j++) {
                    //System.out.println("here");
                    dataSet.add(data.get(randomGenerator.nextInt(data.size())));
                }
                //System.out.println("kNN");
                List<IncomePerson> kNN = findKNN(dataSet, person, 50, 0.25);
                result.add(mostProbableCategory(category, kNN));
                dataSet.clear();
                //System.out.println("this");
            }
            System.out.println(result);
            return result;
        }
        
        public static void printBaggingResult(ArrayList<String> result) {
            
           HashMap<String, Integer> filteredResults = new HashMap<String, Integer>();
           Set<String> keys;
           Iterator it;
           String majorityFilter = "";
           int majority = 0;
           for(int i = 0; i < result.size(); i++) {
               if(!(filteredResults.containsKey(result.get(i)))) {
                   filteredResults.put(result.get(i), 1);
               }
               else {
                   filteredResults.put(result.get(i), filteredResults.get(result.get(i)) + 1);
               }
           }
           keys = filteredResults.keySet();
           it = keys.iterator();
           while(it.hasNext()) {
               String current = ((String)it.next());
               if(filteredResults.get(current) > majority) {
                   majority = filteredResults.get(current);
                   majorityFilter = current;
               }
           }
           System.out.println("Bagging Result: Majority Class: " + majorityFilter 
            + " Accuracy: " + majority + "/" + result.size());
        }

	public static String mostProbableCategory(String filter, List<IncomePerson> listNN) {
		HashSet<String> valuesForFilter = findValueForFilter(filter, listNN);
		HashMap<String, Integer> probTable = new HashMap();

		for (String text : valuesForFilter) {
			probTable.put(text, new Integer(0));
		}

		for (IncomePerson ip : listNN) {
			String valueForIP = ip.getValueFor(filter);
			probTable.put(valueForIP, probTable.get(valueForIP).intValue() + 1);
		}

		int highestProb = 0;
		String highestFilter = "";
		for (Map.Entry<String, Integer> entry : probTable.entrySet()) {
			if (entry.getValue().intValue() > highestProb) {
				highestProb = entry.getValue().intValue();
				highestFilter = entry.getKey();
			}
		}
		return highestFilter;

	}

	public static HashSet<String> findValueForFilter(String filter, List<IncomePerson> listNN) {
		HashSet<String> values = new HashSet<>();
		for (IncomePerson ip : listNN) {
			values.add(ip.getValueFor(filter));
		}

		return values;

	}
}
