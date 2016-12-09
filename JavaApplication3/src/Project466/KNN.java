/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Project466;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nikhilahuja
 */
public class KNN {

	public KNN() {

	}

	public static List<IncomePerson> findKNN(ArrayList<IncomePerson> dataSet,
			IncomePerson key, int k) {
		ArrayList<IncomePerson> ipsWithDist = new ArrayList<>();
		for (IncomePerson ip : dataSet) {
			ip.getDistance(key);
			ipsWithDist.add(ip);
		}

		Collections.sort(ipsWithDist);

		if(ipsWithDist.size() > k){
			return ipsWithDist.subList(0, k);
		}
		return ipsWithDist;
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

	public static HashSet<String> findValueForFilter(String filter, List<IncomePerson> listNN) {
		HashSet<String> values = new HashSet<>();
		for (IncomePerson ip : listNN) {
			values.add(ip.getValueFor(filter));
		}

		return values;

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
}
