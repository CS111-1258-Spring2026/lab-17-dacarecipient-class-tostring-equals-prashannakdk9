/**
 * Represents one person receiving deferred action for childhood arrivals (DACA).
 * @version 1.1
 **/

/* UML CLASS DIAGRAM:
-----------------------------------------
          DACArecipient
-----------------------------------------
- surname : String
- givenName : String
- uscisNumber : String
- countryOfOrigin : String
- birthday : int
- validFromDate : int
- expirationDate : int
- sex : char
-----------------------------------------
+ getSurname() : String
+ getGivenName() : String
+ getUscisNumber() : String
+ getCountyOfOrigin() : String
+ getBirthDay() : int
+ getValidFromDate() : int
+ getExpirationDate() : int
+ getSex() : char
+ setSurname(surname : String) : void
+ setGivenName(givenName : String) : void
+ setUscisNumber(uscisNumber : String) : void
+ setCountryOfOrigin(countryOfOrigin : String) : void
+ setBirthday(birthday : int) : void
+ setValidFromDate(validFromDate : int) : void
+ setExpirationDate(expirationDate : int) : void
+ setSex(sex : char) : void
+ setAll(surname:String, givenName:String, uscisNumber:String, countryOfOrigin:String, birthday:int, validFromDate:int, expirationDate:int, sex:char) : void
+ toString() : String
+ equals(obj:Object) : boolean
+ printCard() : String
+ jdnToDate(J:int) : String
-----------------------------------------
*/

public class DACArecipient {
    // Constants
    private static final String ASCII_ART_0 ="    .----.    .----.  ", ASCII_ART_1 = "   (  --  \\  /  --  )",
        ASCII_ART_2 = "          |  |        ", ASCII_ART_3 = "         _/  \\_      ",
        ASCII_ART_4 = "        (_    _)      ", ASCII_ART_5 = "     ,    `--`    ,   ",
        ASCII_ART_6 = "     \\'-.______.-'/  ", ASCII_ART_7 = "      \\          /   ",
        ASCII_ART_8 = "       '.--..--.'     ", ASCII_ART_9 = "         `\"\"\"\"\"` ",
        ASCII_CREDIT ="   ascii art by: jgs    ";
    private static final String TITLE_USA = "UNITED STATES OF AMERICA", TITLE_EAC = "EMPLOYMENT AUTHORIZATION CARD";
    private static final String LABEL_SURNAME = "Surname", LABEL_GIVEN_NAME = "Given Name", LABEL_USCIS_NUM = "USCIS#",
        LABEL_BIRTH_COUNTRY = "Country of Birth", LABEL_BIRTH_DATE = "Date of Birth",
        LABEL_SEX = "Sex", LABEL_VALID_DATE = "Valid From:", LABEL_EXPIRE_DATE = "Card Expires:",
        LABEL_REENTRY_DISCLAIMER = "NOT VALID FOR REENTRY TO U.S.";

    // Instance Variables
    private String surname, givenName, uscisNumber, countryOfOrigin;
    private int birthday, validFromDate, expirationDate;
    private char sex;

    // Accessors & Mutators (Keep your existing ones here)
    public void setAll(String surname, String givenName, String uscisNumber, String countryOfOrigin, int birthday, int validFromDate, int expirationDate, char sex) {
        this.surname = surname; this.givenName = givenName; this.uscisNumber = uscisNumber;
        this.countryOfOrigin = countryOfOrigin; this.birthday = birthday;
        this.validFromDate = validFromDate; this.expirationDate = expirationDate; this.sex = sex;
    }

    // Part 1: toString
    @Override
    public String toString() {
        return String.format("Surname: %s, Given Name: %s, USCIS Number: %s, Country of Origin: %s, Birthday: %d, Valid From Date: %d, Expiration Date: %d, Sex: %c",
            surname, givenName, uscisNumber, countryOfOrigin, birthday, validFromDate, expirationDate, sex);
    }

    // Part 2: equals
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DACArecipient)) return false;
        DACArecipient other = (DACArecipient) obj;
        return this.birthday == other.birthday && this.validFromDate == other.validFromDate &&
               this.expirationDate == other.expirationDate && this.sex == other.sex &&
               this.surname.equals(other.surname) && this.givenName.equals(other.givenName) &&
               this.uscisNumber.equals(other.uscisNumber) && this.countryOfOrigin.equals(other.countryOfOrigin);
    }

    // Part 4: printCard (FIXED)
    public void printCard() {
        String card = String.format("╔══════════════════════════════════════════════════════════════════════╗%n");
        card += String.format("║%35s%35s║%n", TITLE_USA, "");
        card += String.format("║%60s%10s║%n", TITLE_EAC, "");
        card += String.format("║%-25s%-45S║%n", "", LABEL_SURNAME);
        card += String.format("║%-25s%-45s║%n", ASCII_ART_0, surname);
        card += String.format("║%-25s%-45S║%n", ASCII_ART_1, LABEL_GIVEN_NAME);
        card += String.format("║%-25s%-45s║%n", ASCII_ART_2, givenName);
        card += String.format("║%-25s%-45S║%n", ASCII_ART_3, LABEL_USCIS_NUM);
        card += String.format("║%-25s%-45s║%n", ASCII_ART_4, uscisNumber);
        card += String.format("║%-25s%-45S║%n", ASCII_ART_5, LABEL_BIRTH_COUNTRY);
        card += String.format("║%-25s%-45s║%n", ASCII_ART_6, countryOfOrigin);
        card += String.format("║%-25s%-15S%-30S║%n", ASCII_ART_7, LABEL_BIRTH_DATE, LABEL_SEX);
        card += String.format("║%-25s%-15s%-30s║%n", ASCII_ART_8, jdnToDate(birthday), sex);
        card += String.format("║%-25s%-15S%-30s║%n", ASCII_ART_9, LABEL_VALID_DATE, jdnToDate(validFromDate));
        card += String.format("║%-25s%-15S%-30s║%n", "", LABEL_EXPIRE_DATE, jdnToDate(expirationDate));
        card += String.format("║%-25s%-45s║%n", ASCII_CREDIT, LABEL_REENTRY_DISCLAIMER);
        card += String.format("╚══════════════════════════════════════════════════════════════════════╝%n");

        System.out.println(card);
    }

    public static String jdnToDate(int J) {
        int B=274277, C=-38, f=J+1401+(((4*J+B)/146097)*3)/4+C;
        int e=4*f+3, g=(e%1461)/4, h=5*g+2;
        int D=((h%153)/5)+1, M=((h/153)+2)%12+1, Y=(e/1461)-4716+(12+2-M)/12;
        return String.format("%02d/%02d/%04d", M, D, Y);
    }
}