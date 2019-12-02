package Phonebook;

public class person
{

	private String firstName;
	private String lastName;
	private String fullName;
	private String phoneNum;
	private address theAddress = new address();
	
	String getFullName()
	{
		return fullName;
	}
	
	String getLastName()
	{
		return lastName;
	}
	
	String getFirstName()
	{
		return firstName;
	}
	
	address getAddr()
	{
		return theAddress;
	}
	
	String getPhoneNum()
	{
		return phoneNum;
	}
	
	String printPhoneNum()
	{
		String str=phoneNum;
		String str2=str.substring(10)+"("+str.substring(0,3)+")"+str.substring(3,6)+"-"+str.substring(6);
		return str2;
	}
	
	void setFullName(String name)
	{
		int count=0;
		fullName = name;
		for(int i=0;i<fullName.length();i++)
				if(fullName.charAt(i)==32)
					count++;
		String[] arrOfStr = fullName.split(" ", count+1); 
		firstName = arrOfStr[0];
		lastName = arrOfStr[arrOfStr.length-1];
		System.out.println(lastName);
	}
	
	void setAddr(String toBeSet)
	{
		theAddress.setAddress(toBeSet);
	}
	
	void setPhone (String num)
	{
		phoneNum=num;
	}
	
	void printPers()
	{
		System.out.println();
		System.out.print(fullName+" lives at ");theAddress.printAddr();
		System.out.print(" and their phone number is: "+printPhoneNum());
	}
	
}
