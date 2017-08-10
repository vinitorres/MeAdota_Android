package app.vini.com.meadota.Model.DataEvent;


public class UserContactDataEvent {

    public final String telephoneNumber;
    public final String mobileNumber;
    public final String officeNumber;
    public final String contactEmail;

    public UserContactDataEvent(String telephoneNumber, String mobileNumber, String officeNumber, String contactEmail) {
        this.telephoneNumber = telephoneNumber;
        this.mobileNumber = mobileNumber;
        this.officeNumber = officeNumber;
        this.contactEmail = contactEmail;
    }
}
