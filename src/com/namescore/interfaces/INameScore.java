/**
 * 
 */
package com.namescore.interfaces;

import java.io.IOException;
import java.util.List;

/**
 * @author Kashi 
 * This interface contains two abstract methods getNameScore and
 * getNamesFromFile. First method read words from file and second method 
 * calculates the score of names and provides final score of all names.
 */
public interface INameScore {
	/**
	 * Reads names from file and sorts to list
	 * @param fileName
	 * @return list
	 * @throws Exception 
	 */
	public List<String> getNamesFromFile(String fileName) throws IOException;
	
	/**
	 * calculates the final score of all names in file
	 * @param list
	 * @return final score
	 */
	public long getNameScore(List<String> list);

}
