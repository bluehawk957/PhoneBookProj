package Phonebook;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

public class gui
{
	ProgramFiles brett = new ProgramFiles();
	
	public void start() 
	{
        //Creating the Frame
        JFrame frame = new JFrame("My Phonebook");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        
        // Text Area at the Center and editing where the print happens
        JTextArea ta = new JTextArea();
        PrintStream out = new PrintStream( new ChangePrint( ta ) );
        System.setOut( out );
        System.setErr( out );

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("MENU");
        JMenu m2 = new JMenu("Help"); 
        JMenu subSearch = new JMenu("Search");
        mb.add(m1);
        mb.add(m2);
        

        
        JMenuItem m11 = new JMenuItem("Add New Record");
        m11.addActionListener((event) -> brett.addPerson());  
       
        m1.add(m11);        
        JMenuItem m12 = new JMenuItem("Delete Record");
        m12.addActionListener((event) -> brett.deletePers(brett.searchTelephone()));
        m1.add(m12);
        
        m1.add(subSearch);
        
        JMenuItem m131 = new JMenuItem("Search by first name");
        m131.addActionListener((event) -> brett.printArray(brett.searchFirstName())); 
        subSearch.add(m131);
        JMenuItem m132 = new JMenuItem("Search by last name");
        m132.addActionListener((event) -> brett.printArray(brett.searchLastName())); 
        subSearch.add(m132);
        JMenuItem m133 = new JMenuItem("Search by full name");
        m133.addActionListener((event) -> brett.printArray(brett.searchFullName())); 
        subSearch.add(m133);
        JMenuItem m134 = new JMenuItem("Search by telephone number");
        m134.addActionListener((event) -> brett.searchTelephone().printPers()); 
        subSearch.add(m134);
        JMenuItem m135 = new JMenuItem("Search by city");
        m135.addActionListener((event) -> brett.printArray(brett.searchCity()));
        subSearch.add(m135);
        JMenuItem m136 = new JMenuItem("Search by state");
        m136.addActionListener((event) -> brett.printArray(brett.searchState()));
        subSearch.add(m136);
        
        JMenuItem m14 = new JMenuItem("Update phone records");
        m14.addActionListener((event) -> brett.updatePerson()); 
        m1.add(m14);
        JMenuItem m15 = new JMenuItem("Sort Records");
        m15.addActionListener((event) -> brett.sortData()); 
        m1.add(m15);
        JMenuItem m16 = new JMenuItem("Show all records");
        m16.addActionListener((event) -> brett.printArray(brett.getPersArray())); 
        m1.add(m16);
        JMenuItem m17 = new JMenuItem("Exit");
        m17.addActionListener((event) -> System.exit(0)); 
        m1.add(m17);
        JMenuItem m21 = new JMenuItem("Clear Board");
        m21.addActionListener((event) -> ta.setText(null));
        m2.add(m21);        

        
/*        Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Search:");
        JTextField tf = new JTextField(15); // accepts upto 10 characters
        JButton search = new JButton("Search");
        panel.add(label); // Components Added using Flow Layout
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(search); 
*/        
        //Adding Components to the frame.
//        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);

	}

}
