/**
 * 
 */
package com.namescore.factory;


import org.apache.log4j.Logger;

import com.namescore.implservices.NameScoreImplService;
import com.namescore.interfaces.INameScore;

/**
 * @author Kashi
 * This class is a factory class which provides instance for corresponding 
 * implementation classes when it is requested
 */
public class NameScoreFactory {

	/* Get actual class name to be printed on */
	static Logger log = Logger.getLogger(NameScoreImplService.class.getName());
	/**
	 * This is method used to get object of type INameScore
	 * @param nameScoreType
	 * @return INameScore
	 */
	public INameScore getINameScore(String nameScoreType) {
		log.info("Entry into getINameScore method of " +NameScoreImplService.class.getName());
		if (nameScoreType == null) {
			return null;
		}
		if (nameScoreType.equalsIgnoreCase("NAMESCORE")) {
			return new NameScoreImplService();
		} else if (nameScoreType.equalsIgnoreCase("EMPLOYEENAMESCORE")) {
			return null;
		} else if (nameScoreType.equalsIgnoreCase("FIRSTLASTNAMESCORE")) {
			return null;
		}
		log.info("Exit getINameScore method of " +NameScoreImplService.class.getName());
		return null;		
	}
} //end of NameScoreFactory class
