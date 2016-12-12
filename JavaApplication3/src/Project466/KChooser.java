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
	static double queryRatio = 1;	//speed up, 1 = full run
	static int kmin = 50, kmax = 75, increment = 25;
	static int V = 10;
	static boolean testIncome = true;
	static boolean testMarital = false;
	
	static KNN knn = new KNN();
	static DataParser dp = new DataParser();
	
	static ArrayList<IncomePerson> fdata = new ArrayList<>();
	static ArrayList<ArrayList<IncomePerson>> folds = new ArrayList<>();
	static HashMap<Integer, Double> kErrorRates = new HashMap<>();

	public static void main(String args[]) {
		fdata = dp.parseData();
		
		ArrayList<Double> errRates = new ArrayList<>();
		for(int i=kmin; i<=kmax; i += increment){
			double res = getKErrorRate(i);
			errRates.add(res);
		}
	}
	
	/* get average error rate for k */
	private static double getKErrorRate(int k){
		/* divide data into V folds */
		ArrayList<IncomePerson> data = fdata;
		Collections.shuffle(data);
		folds = getFolds(data);
		
		double errorSum = 0;
		double res = 0;
		
		//System.out.println("error rate for K="+k+"...");
		for(int i=0; i<V; i++){
			double err = getVErrorRate(i, k);
			//System.out.println("   error rate of v="+i+": "+err);
			errorSum += err;
			
			double prev = res;
			res = errorSum / (double)i;
		}
		
		System.out.println(k+"\t"+res);
		return res;
	}
	
	/* get error rate for fold v */
	private static double getVErrorRate(int foldIdx, int k){
		/* get testing and training data */
		ArrayList<IncomePerson> testing = folds.get(foldIdx);
		ArrayList<IncomePerson> training = getTrainingData(foldIdx, folds);
		
		/* for every ip in fold, run KNN and get errors */
		double correctSum = 0;
		
		int i;
		for(i=0; i<testing.size(); i++){
			int queryRes = runKNNQuery(testing.get(i), training, k);
			correctSum += queryRes;
			if(queryRatio != 1 && i >= testing.size() * queryRatio){
				break;
			}
		}
		
		/* get error rate */
		//sum of squared error
		double res = (double)(i - correctSum) / (double)i;
		return res;
	}
	
	/*  */
	private static int runKNNQuery(IncomePerson ip, ArrayList<IncomePerson> training, int k){
		IncomePerson resIp;
		int correct = 0;
		
		ArrayList<IncomePerson> neighbors = new ArrayList<>( KNN.findKNN(training, ip, k) );
		
		if(testIncome && isOutputCorrect("income", ip, neighbors)){
			correct++;
		}
		if(testMarital && isOutputCorrect("marital", ip, neighbors)){
			correct++;
		}
		
		return correct;
	}
	private static boolean isOutputCorrect(String attr, IncomePerson ip, ArrayList<IncomePerson> neighbors){
		if(ip.getValueFor(attr).equals(KNN.mostProbableCategory(attr, neighbors))){
			return true;
		}
		return false;
	}
	
	private static ArrayList<ArrayList<IncomePerson>> getFolds(ArrayList<IncomePerson> data){
		ArrayList<ArrayList<IncomePerson>> folds = new ArrayList<>();
		for(int i=0; i<V; i++){
			folds.add(new ArrayList<IncomePerson>());
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
