package Project466;

import java.util.Scanner;

public class IncomePerson implements Comparable{
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
	
        public IncomePerson inputPerson;
        public double distanceToIIP;
        
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
        
        public String getValueFor(String attribute) {
            
            if (attribute.equals("marital")) {
                return marital;
            }
            else if (attribute.equals("race")) {
                return race;
            }
            else if (attribute.equals("country")) {
                return country;
            }
            else if (attribute.equals("occupation")) {
                return occupation;
            }
            else if (attribute.equals("sex")) {
                return sex;
            }
            else if (attribute.equals("workclass")) {
                return workclass;
            }
            else if (attribute.equals("income")) {
                return income;
            }
           
            throw new IllegalArgumentException("Invalid day of the week: " + attribute);
            
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
        
        
        /* get 3d distance between 2 people */
	public void getDistance( IncomePerson inIP){
		double ageWgt = 1, eduWgt = 1, hoursWgt = 1;
		double res =
				Math.sqrt(
						ageWgt * Math.pow( (double)this.age - (double)inIP.age, 2 )
						+ eduWgt * Math.pow( (double)this.edu - (double)inIP.edu, 2 )
						+ hoursWgt * Math.pow( (double)this.hours - (double)inIP.hours, 2 )
				);
		distanceToIIP = res;
	}

    @Override
    public int compareTo(Object o) {
        IncomePerson ip = (IncomePerson) o;
        
        if(this.distanceToIIP > ip.distanceToIIP) {
            return 1;
        }
        else if(this.distanceToIIP == ip.distanceToIIP) {
            return 0;
        }
        
        return -1;
    }
    
    @Override
    public String toString() {
        return " age: " + age.intValue()
               +" workclass: " + workclass
               +" edu: " + edu
               +" marital: " + marital
               +" relationship: " + relationship
               +" race: " + race
               +" sex: " + sex
               +" hours: " +hours.intValue()
               +" country: " + country
               +" income: " + income ;
    }
}
