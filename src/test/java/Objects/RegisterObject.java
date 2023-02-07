package Objects;

import java.util.HashMap;

public class RegisterObject {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String skills;
    private String year;
    private String language;
    private String country;
    private String month;
    private String day;
    private String firstPassword;
    private String confirmPassword;

    public RegisterObject(HashMap<String, String> TestData) {
        populateObject(TestData);

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFirstPassword() {
        return firstPassword;
    }

    public void setFirstPassword(String firstPassword) {
        this.firstPassword = firstPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    private void populateObject(HashMap<String, String> TestData) {
        for (String Key : TestData.keySet()) {
            switch (Key) {
                case "firstName":
                    setFirstName(TestData.get(Key));
                    break;
                case "secondName":
                    setLastName(TestData.get(Key));
                    break;
                case "address":
                    setAddress(TestData.get(Key));
                    break;
                case "email":
                    setEmail(TestData.get(Key));
                    break;
                case "phone":
                    setPhone(TestData.get(Key));
                    break;
                case "skills":
                    setSkills(TestData.get(Key));
                    break;
                case "year":
                    setYear(TestData.get(Key));
                    break;
                case "language":
                    setLanguage(TestData.get(Key));
                    break;
                case "country":
                    setCountry(TestData.get(Key));
                    break;
                case "month":
                    setMonth(TestData.get(Key));
                    break;
                case "lastName":
                    setLastName(TestData.get(Key));
                    break;
                case "day":
                    setDay(TestData.get(Key));
                    break;
                case "firstPassword":
                    setFirstPassword(TestData.get(Key));
                    break;
                case "confirmPassword":
                    setConfirmPassword(TestData.get(Key));
                    break;
            }
        }
    }

}
