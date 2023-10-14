package appium.utils;

public class EnumClass {
	
	public enum Button{
		CONTINUE("CONTINUE"), SIGNUPLATER("DO IT LATER"), SIGNUPNOW("SIGN UP NOW");
		
		String option;
		Button(String button){
			this.option = button;
		}
		
		public String getOption() {
			return option;
		}
	}
	
	public enum BookCategory{
		HOTELS("Hotels"), FLIGHTS("Flights"), TRAINS("Trains"), BUS("Bus");
		
		String option;
		
		BookCategory(String button){
			this.option = button;
		}
		
		public String getOption() {
			return option;
		}
	}
	
	public enum LoginTexts{
		SIGNIN_MESSAGE("What's your number?"), NUMBER_FIELD_PLACEHOLDER("Enter Mobile Number"), TERMS_AND_CONDITIONS("By continuing, I confirm that I have read the Cancellation Policy, User Agreement, Terms of Services and Privacy Policy of Goibibo"),
		SIGNUP_OFFER("Sign-up and get new user benefits");
		
		String option;
		
		LoginTexts(String text){
			this.option = text;
		}
		public String getOption() {
			return option;
		}
	}
	
	public enum MakeMyTripCategoriesMajor{
		FLIGHTS("Flights"), HOTELS("Hotels"), HOLIDAY_PACKAGES("Holiday Packages"), TRAIN_BUS("Trains/ Bus");
		String option;
		MakeMyTripCategoriesMajor(String text){
			this.option = text;
		}
		public String getOption() {
			return option;
		}
	}

}
