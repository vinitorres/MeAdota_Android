package app.vini.com.meadota.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by uriel on 24/07/17.
 */

public class User implements Parcelable {

    protected String name;
    protected String email;
    protected String password;
    protected String cpf;
    protected String street;
    protected String number;
    protected String cep;
    protected String city;
    protected String state;
    protected String telephoneNumber;
    protected String mobileNumber;

    public User(){

    }

    protected User(Parcel in) {
        name = in.readString();
        email = in.readString();
        password = in.readString();
        cpf = in.readString();
        street = in.readString();
        number = in.readString();
        cep = in.readString();
        city = in.readString();
        state = in.readString();
        telephoneNumber = in.readString();
        mobileNumber = in.readString();
    }


    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(password);
        parcel.writeString(cpf);
        parcel.writeString(street);
        parcel.writeString(number);
        parcel.writeString(cep);
        parcel.writeString(city);
        parcel.writeString(state);
        parcel.writeString(telephoneNumber);
        parcel.writeString(mobileNumber);
    }
}
