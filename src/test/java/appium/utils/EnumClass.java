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
		HOTELS("hotels"), FLIGHTS("flights"), TRAINS("trains"), Bus("bus");
		
		String option;
		
		BookCategory(String button){
			this.option = button;
		}
		
		public String getOption() {
			return option;
		}
	}

}
