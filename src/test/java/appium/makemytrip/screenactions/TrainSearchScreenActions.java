package appium.makemytrip.screenactions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import appium.makemytrip.exceptions.JourneyDatePriorToCurrentDateException;
import appium.makemytrip.screenobjects.TrainSearchScreenObject;
import io.appium.java_client.android.AndroidDriver;

public class TrainSearchScreenActions extends CommonScreenActions{

	public TrainSearchScreenActions(AndroidDriver driver) {
		super(driver);
	}
	
	TrainSearchScreenObject trainSearchScreen = new TrainSearchScreenObject();
	
	public boolean getIsSearchButtonEnabled() throws InterruptedException {
		return isElementClickable(trainSearchScreen.searchButton);
	}
	
	public void selectDateFromCalendar(String journeyDate) throws Exception {
		LocalDate dateOfJourney;
		try {
			dateOfJourney = LocalDate.parse(journeyDate);
		} catch (Exception e) {
			throw new Exception("Invalid date is provided:" + journeyDate);
		}
		LocalDate currentDate = LocalDate.now();//YYYY-MM-DD Format
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd-MMMM-YYYY", Locale.ENGLISH);
		String formattedJourneyDate = LocalDate.parse(journeyDate).format(customFormatter);
        int comparisonResult = currentDate.compareTo(dateOfJourney);
        if(comparisonResult == 0) {
        	//do nothing as journey date is same as current date
        }else if(comparisonResult<0) {
        	//current date is before journeyDate
        	//implement logic to select date on calendar
        	clickElement(trainSearchScreen.dateField);
        	waitForTextView(" Select Date ");
        	//get month and year of journey
        	String day = formattedJourneyDate.split("-")[0];
        	String month = formattedJourneyDate.split("-")[1];
        	String year = formattedJourneyDate.split("-")[2];
        	scrollToMonthInCalendar(month, year);
        	clickDateInCalendar(month, year, day);
        }else {
        	throw new JourneyDatePriorToCurrentDateException(journeyDate +" is prior to current date:" + currentDate);
        }
	}

}
