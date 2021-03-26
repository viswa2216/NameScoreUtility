/**
 * 
 */
package main.java.com.namescore.factory;


import org.apache.log4j.Logger;

import main.java.com.namescore.implservices.NameScoreImplService;
import main.java.com.namescore.interfaces.INameScore;
import main.java.com.namescore.util.NameScoreConstansts;

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
		if (nameScoreType.equalsIgnoreCase(NameScoreConstansts.NAME_SCORE)) {
			return new NameScoreImplService();
		} else if (nameScoreType.equalsIgnoreCase(NameScoreConstansts.EMPLOYEE_NAME_SCORE)) {
			return null;
		} else if (nameScoreType.equalsIgnoreCase(NameScoreConstansts.FIRST_LAST_NAME_SCORE)) {
			return null;
		}
		log.info("Exit getINameScore method of " +NameScoreImplService.class.getName());
		return null;		
	}
} //end of NameScoreFactory class
