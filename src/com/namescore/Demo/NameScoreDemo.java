package com.namescore.Demo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.namescore.factory.NameScoreFactory;
import com.namescore.interfaces.INameScore;

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
		//
		//FileHandler fileHandler = new FileHandler("app.log", true);        
       // ((Object) log).addHandler(fileHandler);
		log.info("Entry into main method of "+NameScoreDemo.class.getName());
		
		//Creating factory instance 
		NameScoreFactory nameScoreFactory = new NameScoreFactory();
		//Creating class instance by using factory method
		INameScore  nameScoreInterf = nameScoreFactory.getINameScore("NAMESCORE");
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
