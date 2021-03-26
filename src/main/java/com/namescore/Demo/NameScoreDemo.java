package main.java.com.namescore.Demo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import main.java.com.namescore.factory.NameScoreFactory;
import main.java.com.namescore.interfaces.INameScore;
import main.java.com.namescore.util.NameScoreConstansts;

/**
 * This class is used to create instance of factory method and call sequence of required
 * methods by using factory instance
 * @author Kashi
 *
 */
public class NameScoreDemo {
	
	/* Get actual class name to be printed on */
	   static Logger log = Logger.getLogger(NameScoreDemo.class.getName());

	public static void main(String[] args) {
		BasicConfigurator.configure();		
		log.info("Entry into main method of "+NameScoreDemo.class.getName());
		
		//Creating factory instance 
		NameScoreFactory nameScoreFactory = new NameScoreFactory();
		//Creating class instance by using factory method
		INameScore  nameScoreInterf = nameScoreFactory.getINameScore(NameScoreConstansts.NAME_SCORE);
		//Creating scanner object for input
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter file Path :");		
		List<String> namesList = null;
		//Returns list of names in sorted order from input file
		try {
			namesList = nameScoreInterf.getNamesFromFile(myObj.nextLine());
			// Returns final score of all names
			if(namesList != null)
			{
				long finalScore = nameScoreInterf.getNameScore(namesList);
				log.info("final score of names from main method :: "+finalScore);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		myObj.close();
		log.info("Exit main method of "+NameScoreDemo.class.getName());
		
	}

}
