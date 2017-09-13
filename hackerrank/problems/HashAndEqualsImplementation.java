package hackerrank.problems;

import java.util.HashSet;

/*
 * Sample code to showcase how equals and hashCode can be 
 * implemented together.
 */
public class HashAndEqualsImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Employee> empHashSet = new HashSet<Employee>();
		empHashSet.add(new Employee("101", "Karan Murthy"));
		empHashSet.add(new Employee("101", "Karan Murthy"));
		empHashSet.add(new Employee("101", "Karan Murthy"));
		empHashSet.add(new Employee("101", "Karan Murthy"));
		
		for(Employee emp: empHashSet){
			System.out.println("Emp Id: " + emp.getId() + " Emp name: " + emp.getName() + " hash code: " + emp.hashCode());
		}
		
	}

}

class Employee{
	private String id;
	private String name;
	
	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Employee)){
			return false;
		}
		if(obj == this)
			return true;
		return this.id == ((Employee)obj).id && this.name == ((Employee)obj).name;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + id==null ? 0 : id.hashCode();
		return result;
	}
	
}