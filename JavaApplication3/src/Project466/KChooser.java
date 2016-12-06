package Project466;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
for every k [kmin, kmax], compute average error rate for KNN

optimal k = lowest error rate

error rate for k =
	divide data into V folds
	for each fold v:
		run k queries
		get error rate
	average error rates
*/

public class KChooser {
	static KNN knn = new KNN();
	static DataParser dp = new DataParser();
	
	static ArrayList<IncomePerson> fdata = new ArrayList<>();
	static ArrayList<ArrayList<IncomePerson>> folds = new ArrayList<>();
	static HashMap<Integer, Double> kErrorRates = new HashMap<>();
	static int V = 100;

	public static void main(String args[]) {
		fdata = dp.parseData();
		int kmin = 10, kmax = 1000, kbest = 0;
		double bestErr = 1;
		for(int i=kmin; i<kmax; i += 50){
			double res = getKErrorRate(i);
			if(res < bestErr){
				bestErr = res;
				kbest = i;
			}
			System.out.println(i+" "+res);
		}
	}
	
	/* get average error rate for k */
	private static double getKErrorRate(int k){
		/* divide data into V folds */
		ArrayList<IncomePerson> data = fdata;
		Collections.shuffle(data);
		folds = getFolds(data);
		
		double errorSum = 0;
		
		for(int i=0; i<V; i++){
			double err = getVErrorRate(i, k);
			//System.out.println("   error rate of v="+i+": "+err);
			errorSum += err;
		}
		
		double res = errorSum / (double)V;
		return res;
	}
	
	/* get error rate for fold v */
	private static double getVErrorRate(int foldIdx, int k){
		/* get training data */
		ArrayList<IncomePerson> training = getTrainingData(foldIdx, folds);
		
		/* run k queries */
		double errSum = 0;
		for(int i=0; i<k; i++){
			//...
		}
		
		/* get error rate */
		double res = errSum/k;
		return res;
	}
	
	/* run queries, return error rate */
	private static double runQueries(int foldIdx){
		
	}
	private static boolean runQuery(){
		
	}
	
	private static ArrayList<ArrayList<IncomePerson>> getFolds(ArrayList<IncomePerson> data){
		ArrayList<ArrayList<IncomePerson>> folds = new ArrayList<>();
		for(int i=0; i<V; i++){
			folds.add(new ArrayList<>());
		}
		
		/* populate each fold */
		int curFoldIdx=0, count=0;
		int thresh = (int)Math.ceil((double)data.size() / (double)V);
		for(int i=0; i<data.size(); i++){
			folds.get(curFoldIdx).add(data.get(i));
			count++;
			if(count == thresh){
				curFoldIdx++;
				count = 0;
			}
		}
		
		return folds;
	}
	
	private static ArrayList<IncomePerson> getTrainingData(int testingIdx, ArrayList<ArrayList<IncomePerson>> folds){
		ArrayList<IncomePerson> training = new ArrayList<>();
		for(int i=0; i<folds.size(); i++){
			ArrayList<IncomePerson> curFold = folds.get(i);
			if(i != testingIdx){
				for(IncomePerson ip : curFold){
					training.add(ip);
				}
			}
		}
		return training;
	}
}
