
package Project466;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataParser {
	
	String fname = "income.csv";
	
	public DataParser(){}
	
	/* read file, save into data arraylist */
	public ArrayList<IncomePerson> parseData(){
		ArrayList<IncomePerson> data = new ArrayList<>();
		
		try{
			Scanner fscan = new Scanner(new File(fname));

			fscan.nextLine();
			while(fscan.hasNextLine()){
				IncomePerson p = new IncomePerson(fscan.nextLine());
				data.add(p);
			}
			System.out.println("Read "+data.size()+" tuples.");
			
			/*for(int i=0; i<5; i++){
				System.out.println(data.get(i).age);
			}*/
		}catch(Exception e){
			//File not found
			System.out.print("File not found");

		}
		
		return data;
	}
	
}
