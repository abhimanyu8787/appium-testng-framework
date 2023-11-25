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
	
	public enum MakeMytripTrainAndBusOptions{
		BOOK_TRAIN_TICKETS("Book Trains Tickets"),BOOK_BUS_TICKETS("Book Bus Tickets"),TRIP_GURANTEE("Trip Guarantee"),CHECK_PNR_STATUS("Check PNR Status"),
		LIVE_TRAIN_STATUS("Live Train Status"),FOOD_IN_TRAIN("Food in Train"), TRAIN_SCHEDULE("Train Schedule"),TRAIN_AVAILABILITY("Train Availability"),
		LIVE_STATION("Live Station"), COACH_POSITION("Coach Position"), VACANT_CHART("Vacant Chart");
		
		String option;
		MakeMytripTrainAndBusOptions(String text){
			this.option = text;
		}
		public String getOption() {
			return option;
		}
	}
	
	public enum NykaaBottomMenu{
		BEAUTY("Beauty"), OFFERS("Offers"), CATEGORIES("Categories"), STREAM("Stream"), ACCOUNT("Account");
		String option;
		NykaaBottomMenu(String text){
			this.option = text;
		}
		public String getOption() {
			return option;
		}
	}
	
	public enum NykaaStoresTitle{
		STORE_SELECTOR_TITLE("Select a store"),NYKAA("Your One-Stop Beauty Shop"), NYKAA_LUXE("Indulge In Luxury Beauty "), NYKAA_CROSSBORDER("Bringing international brands closer to you"), NYKAA_PRO("Go-to Place for Your Business Needs"), NYKAA_PRO_HEADING("FOR BEAUTY PROFESSIONALS");
		String option;
		
		NykaaStoresTitle(String text){
			this.option = text;
		}
		public String getOption() {
			return option;
		}
	}
	
	public enum NykaaSearchBoxPlaceholders{
		NYKAA("Search on Nykaa"), NYKAA_LUXE("Search on Nykaa LUXE"), NYKAA_CROSSBORDER("Search on Cross-Border"), NYKAA_PRO("Nykaa Pro");
		String option;
		
		NykaaSearchBoxPlaceholders(String text){
			this.option = text;
		}
		public String getOption() {
			return option;
		}
	}
	
	public enum AndroidDeviceButtons{
		BACK("Back"), RECENT_APP("Recent Apps"), SEARCH("Search"), ENTER("Enter");
		String option;
		AndroidDeviceButtons(String text){
			this.option = text;
		}
		public String getOption() {
			return option;
		}
	}
	
	public enum NykaaAccountsMenu{
		ORDERS("Orders"), MY_COUPONS("My Coupons"), WALLET("Wallet"), NYKAA_MEMBER_SECTION("Nykaa Privé")
		, BEAUTY_PORTFOLIO("Beauty Portfolio"), WISHLIST("Wishlist"), HELP("Help and Support"), ADDRESS("Addresses")
		, PAYMENT_METHODS("Payment Methods"), PROFILE("Profile");
		String option;
		NykaaAccountsMenu(String text){
			this.option = text;
		}
		public String getOption() {
			return option;
		}
	}

}
