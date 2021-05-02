package acme.components.spamValidator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.spamConfig.BlackList;

@Service
public class SpamValidatorService {
	
	@Autowired
	SpamValidatorRepository repository;
	
	
	public int wordCount(final String message) {
	    final Pattern pattern = Pattern.compile("[\\w-]+");
	    final Matcher  matcher = pattern.matcher(message);
	    int count = 0;
	    while (matcher.find())
	        count++;
	    return count;
	}
	
	
	public boolean spamValidate(final String message) {
		
		final Integer wordsNumber = this.wordCount(message);
		Integer blackMatches = 0;
		final List<String> blackList = this.repository.findWordList().stream().map(BlackList::getWord).collect(Collectors.toList());
		for(final String blackword: blackList) {
	
			final int literalSize = this.wordCount(blackword);

			final Pattern pattern = Pattern.compile(blackword,Pattern.CASE_INSENSITIVE);
			final Matcher matcher = pattern.matcher(message);
			
			while(matcher.find())
				blackMatches+=literalSize;
		}
		
		final Float spamPercentage = ((float) blackMatches) / ((float)wordsNumber)*100;
		
		if(spamPercentage > this.repository.findThreshold())
			return false;
		else
			return true;
		
	}

}
