package Phonebook;

import javax.swing.JOptionPane;

public class ProgramFiles
{
	private person persArray[]=new person[0];
	
	void addPerson()
	{
		String input = JOptionPane.showInputDialog("Please input a record");
		String tempStr="";
	    person pers1 = new person();
		int i;
		int j;
		int k;
		int count=0;
		
		for(i=0;i<input.length();i++)
		{			
			if(input.charAt(i)==44)
			{
				pers1.setFullName(tempStr);
				break;
			}
			tempStr+=input.charAt(i);		
		}
		
		tempStr="";
		for(j=i+2;j<input.length();j++)
		{
			if(input.charAt(j)==44)
			{
				count++;
				if(count==4)
				{
					pers1.setAddr(tempStr);
					break;
				}
			}
			tempStr+=input.charAt(j);
		}
		
		tempStr="";
		for(k=j+2;k<input.length();k++)
			tempStr+=input.charAt(k);
		
		pers1.setPhone(tempStr);
					
		persArray = addToArray(persArray, pers1);
		
	}
	
	void printArray(person array[])
	{
		for(int i=0;i<array.length;i++)
			array[i].printPers();
	}
	
    person[] addToArray(person oldArray[], person newPers) 
	{	
		person newArray[]= new person[oldArray.length+1];	
		
		for(int i=0;i<oldArray.length; i++) 
			newArray[i] = oldArray[i];
		
		newArray[newArray.length - 1] = newPers;	
		
		return newArray; 
	}
    
    person[] searchFirstName()
    {
    	String input = JOptionPane.showInputDialog("Who are you trying to find?");
    	person tempArray[] = new person[0];
    	
    	for(int i=0;i<persArray.length;i++)
    		if(persArray[i].getFirstName().contentEquals(input)==true)
    			tempArray=addToArray(tempArray, persArray[i]);
	
    	return tempArray;
    }
    
    person[] searchLastName()
    {
    	String input = JOptionPane.showInputDialog("Who are you trying to find?");
    	person tempArray[] = new person[0];
    	
    	for(int i=0;i<persArray.length;i++)
    		if(persArray[i].getLastName().contentEquals(input)==true)
    			tempArray=addToArray(tempArray, persArray[i]);
 	
    	return tempArray;
    }
    
    person[] searchFullName()
    {
    	String input = JOptionPane.showInputDialog("Who are you trying to find?");
    	person tempArray[] = new person[0];
    	
    	for(int i=0;i<persArray.length;i++)
    		if(persArray[i].getFullName().contentEquals(input)==true)
    			tempArray=addToArray(tempArray, persArray[i]);
	
    	return tempArray;
    }
    
    person[] searchCity()
    {
    	String input = JOptionPane.showInputDialog("Enter a city");
    	person tempArray[] = new person[0];
    	
    	for(int i=0;i<persArray.length;i++)
    		if(persArray[i].getAddr().getCity().contentEquals(input)==true)
    			tempArray=addToArray(tempArray, persArray[i]);
	
    	return tempArray;
    }
    
    person[] searchState()
    {
    	String input = JOptionPane.showInputDialog("Enter a state");
    	person tempArray[] = new person[0];
    	
    	for(int i=0;i<persArray.length;i++)
    		if(persArray[i].getAddr().getState().contentEquals(input)==true)
    			tempArray=addToArray(tempArray, persArray[i]);
	
    	return tempArray;
    }
    
    person searchTelephone()
    {
    	String input = JOptionPane.showInputDialog("Please enter a phone number");
    	
    	for(int i=0;i<persArray.length;i++)
    		if(persArray[i].getPhoneNum().contentEquals(input)==true)
    			return persArray[i];
		return null;
    }
    
    person[] getPersArray()
    {
    	return persArray;
    }
    
    void updatePerson()
    {
    	deletePers(searchTelephone());
    	addPerson();
    	System.out.print("Record has been updated for");
    	persArray[persArray.length-1].printPers();
    }
    
    void deletePers(person kill)
    {
    	person newArray[]= new person[persArray.length-1];
    	for(int i=0;i<newArray.length; i++) 
    		if(persArray[i]!=kill)
				newArray[i] = persArray[i];
    	
    	persArray=newArray; 
    	System.out.println(kill.getFullName()+"'s records have been deleted");
    }
    
    void sortData()
    {
    	System.out.println();
    	for(int i=0; i<persArray.length;i++)
    		for(int j=0; j<persArray.length-1;j++)
    			if(persArray[j].getFullName().compareTo(persArray[j+1].getFullName())>0)
    			{
    				person holder=persArray[j];
					persArray[j]=persArray[j+1];
					persArray[j+1]=holder;
    			}
    				
    	System.out.print("Your data has been sorted");
    }
}

