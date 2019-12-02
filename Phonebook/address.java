package Phonebook;

public class address
{
	private int streetNum;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	void setAddress(String input)
	{
		String tempStr="";
		int i=0;
		int j=0;
		int k=0;
		int l=0;
		int m=0;
		for(i=0;i<input.length();i++)
		{			
			if(input.charAt(i)==32)
			{
				streetNum=Integer.parseInt(tempStr);
				break;
			}
			tempStr+=input.charAt(i);		
		}		
		tempStr="";
		
		for(j=i+1;j<input.length();j++)
		{
			if(input.charAt(j)==44)
			{
				street=tempStr;
				break;	
			}
			tempStr+=input.charAt(j);
		}
		tempStr="";
		
		for(k=j+2;k<input.length();k++)
		{
			if(input.charAt(k)==44)
			{
				city=tempStr;
				break;	
			}
			tempStr+=input.charAt(k);
		}
		tempStr="";
		
		for(l=k+2;l<input.length();l++)
		{
			if(input.charAt(l)==44)
			{
				state=tempStr;
				break;	
			}
			tempStr+=input.charAt(l);
		}
		tempStr="";
		
		for(m=l+2;m<input.length();m++)
			tempStr+=input.charAt(m);	
		
		zip=tempStr;
	}
	
	void printAddr()
	{
		System.out.print(streetNum+" "+street+", "+city+","+state+" "+zip);
	}
	
	int getStreetNum()
	{
		return streetNum;
	}
	
    String getStreet()
	{
		return street;
	}
    
    String getCity()
	{
		return city;
	}
    
    String getState()
	{
		return state;
	}
    
	String getZip()
	{
		return zip;
	}
}



