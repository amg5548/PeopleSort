
public class People {

    private final String lastName;
    private final String firstName;
    private final String gender;
    private final String dateOfBirth;
    private final String favoriteColor;

    public People(String lastName, String firstName, String gender, String dateOfBirth, String favoriteColor) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.favoriteColor = favoriteColor;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }
}
