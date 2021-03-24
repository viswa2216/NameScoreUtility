/**
 * 
 */
package com.namescore.implservices;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.namescore.interfaces.INameScore;
import com.namescore.util.NameScoreAlphabetEnum;

/**
 * @author Kashi This class provides implementation to fetch names from given
 *         file and calculates scores for for each names and finally gives total
 *         score
 */
public class NameScoreImplService implements INameScore {

	/* Get actual class name to be printed on */
	static Logger log = Logger.getLogger(NameScoreImplService.class.getName());

	/**
	 * This is method used to fetch names from files and sorted to a list
	 * 
	 * @param fileName
	 *            of type String
	 * @return wordList of type List
	 * @throws Exception 
	 */
	@Override
	public List<String> getNamesFromFile(String fileName) throws IOException {
		log.info("Entry into getNamesFromFile method of " + NameScoreImplService.class.getName());
		List<String> wordList = null;
		Stream<String> stream = null;
		try {
			if (fileName == null || "".equals(fileName)) {
				log.info(" No file path found. Please provide file path with file name.");
				return null;
			}
			File file = new File(fileName);
			if (!(file.exists())) {
				log.info(" File Not Found ");
				return null;
			}
			stream = Files.lines(Paths.get(fileName));

			wordList = stream.flatMap(line -> Stream.of(line.split(","))).collect(Collectors.toList());
			// sorts the word list in alphabetical order
			Collections.sort(wordList);

		} catch (IOException e) {
			e.printStackTrace();
		}

		log.info("Exit getNamesFromFile method of " + NameScoreImplService.class.getName());
		return wordList;
	}

	/**
	 * This is method used to get final score of names
	 * 
	 * @param wordList
	 *            of type List
	 * @return finalScore of type long
	 */
	@Override
	public long getNameScore(List<String> wordList) {
		log.info("Entry into getNameScore method of " + NameScoreImplService.class.getName());
		int index = 0; // index is initialized and assigned value
		long score = 0L; // score is initialized and assigned value
		long finalScore = 0L; // finalScore is initialized and assigned value
		if (!(wordList.isEmpty())) {
			// Looping list to get names of string type
			for (String str : wordList) {
				index++;
				str = str.replace("\"", "");
				str = str.toUpperCase();
				score = 0L;
				int sum = 0;
				char[] ch = str.toCharArray();
				// Looping char array to get char of each string
				for (char c : ch) {
					String cValue = String.valueOf(c).trim();
					if (!(cValue.isEmpty())) {
						sum = sum + NameScoreAlphabetEnum.valueOf(cValue.trim()).getValue();
					} else {
						log.info("The score of each name in file::" + score);
						return score;
					}
				}
				score = sum * index;
				log.info("The score of each name in file::" + score);
				finalScore = finalScore + score;
				log.info("The final score of all names in file ::" + finalScore);
			}
		}

		log.info("Exit getNameScore method of " + NameScoreImplService.class.getName());
		return finalScore;
	}
}
