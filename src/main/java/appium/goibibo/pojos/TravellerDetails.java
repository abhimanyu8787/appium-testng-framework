package appium.goibibo.pojos;

import java.util.List;

public class TravellerDetails {
    
    private Integer numberOfPassengers;
    private List<PassengerDetails> passengerDetails;
    
    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }
    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
    public List<PassengerDetails> getPassengerDetails() {
        return passengerDetails;
    }
    public void setPassengerDetails(List<PassengerDetails> passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

}
