import java.util.ArrayList;

public class CompanyAddress {
    String country;
    String city;
    String street;
    Integer house;


    public long stringToInt(String str) {
        long resolute = 0L;
        if (str == null) {
            return 0L;
        }
        for (int i = 0; i < str.length(); i++) {
            resolute += str.charAt(i);
        }
        return resolute;
    }


    public long classToInt() {
        return (stringToInt(country) * 3) + (stringToInt(city) * 5) + (stringToInt(street) * 7) + house * 13L;
    }


    @Override
    public String toString() {
        return country  + " " + city + " " + street + " " + house + " ";
    }
}