package com.namescore.implservices;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NameScoreImplServiceTest {

	@Test
	public void testGetNamesFromFileCase1() {
		NameScoreImplService implService = new NameScoreImplService();
		String fileName = "C:\\Users\\Deekshi\\Desktop\\Kashi\\OCC Take Home Coding namesNew.txt";
		List<String> nameList = null;
		try {
			nameList = implService.getNamesFromFile(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> l1 = new ArrayList<String>();
		l1.add("BARBARA");
		l1.add("ELIZABETH");
		l1.add("JENNIFER");
		l1.add("LINDA");
		l1.add("MARIA");
		l1.add("MARY");
		l1.add("PATRICIA");
		l1.add("SUSAN");

		assertEquals(l1.size(), nameList.size());
		
	}
	/**
	 * File path is empty 
	 */
	@Test
	public void testGetNamesFromFileCase2() {
		NameScoreImplService implService = new NameScoreImplService();
		String fileName = "";
		List<String> nameList = null;
		try {
			nameList = implService.getNamesFromFile(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		assertEquals(nameList, null);
		
	}
	/**
	 * File path is null returns null object
	 */
	@Test
	public void testGetNamesFromFileCase3() {
		NameScoreImplService implService = new NameScoreImplService();
		String fileName = null;
		List<String> nameList = null;
		try {
			nameList = implService.getNamesFromFile(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(nameList, null);

	}
	/**
	 * Invalid File path returns null object
	 */
	@Test
	public void testGetNamesFromFileCase4() {
		NameScoreImplService implService = new NameScoreImplService();
		String fileName = "C:\\Users\\Deekshi\\Desktop\\Kashi\\OCC Take Home Coding namesNew1.txt";
		List<String> nameList = null;
		try {
			nameList = implService.getNamesFromFile(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(nameList, null);

	}

	private void assertTrue() {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testGetNameScoreCase1() {
		NameScoreImplService implService = new NameScoreImplService();
		List<String> l1 = new ArrayList<String>();
		l1.add("BARBARA");
		l1.add("ELIZABETH");
		l1.add("JENNIFER");
		l1.add("LINDA");
		l1.add("MARIA");
		l1.add("MARY");
		l1.add("PATRICIA");
		l1.add("SUSAN");
		long actualscore = implService.getNameScore(l1);
		long expectedScore = 2305;
		assertEquals(expectedScore, actualscore);		
		  
	}
	/**
	 * Empty nameList returns score 0
	 */
	@Test
	public void testGetNameScoreCase2() {
		NameScoreImplService implService = new NameScoreImplService();
		List<String> l1 = new ArrayList<String>();		
		long actualscore = implService.getNameScore(l1);
		
		assertEquals(actualscore, 0);		
		  
	}

}
