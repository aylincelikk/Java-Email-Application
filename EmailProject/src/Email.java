import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternateEmail;
    private String companySuffix = "aylcompany.com";
    private int mailboxCapacity = 700;
    private int passwordLength = 10;

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();
        System.out.println("Your department is: " + department);

        this.password = randomPassword(10);

        this.email = email;

        System.out.println(showInfo());
    }

    protected String setDepartment() {
        Scanner input = new Scanner(System.in);

        System.out.printf("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");

        int choice = input.nextInt();

        String department;
        String password;
        String email;

        switch (choice) {
            case 0:
                System.out.println("You have not selected any departments. Check again.");
                department = "None";
                password = "No password generated";
                email = "";
                break;
            case 1:
                department = "Sales";
                password = randomPassword(passwordLength);
                email = generateEmail(firstName, lastName, department);
                break;
            case 2:
                department = "Development";
                password = randomPassword(passwordLength);
                email = generateEmail(firstName, lastName, department);
                break;
            case 3:
                department = "Accounting";
                password = randomPassword(passwordLength);
                email = generateEmail(firstName, lastName, department);
                break;
            default:
                department = "Invalid value";
                password = "No password generated";
                email = "";
                break;
        }

        System.out.println("Your department is: " + department);
        System.out.println("Your password is: " + password);
        System.out.println("Your email is: " + email);

        this.email = email; // email'i sınıf düzeyindeki alana ata

        return department;
    }

    private String generateEmail(String firstName, String lastName, String department) {
        String companySuffix = "aylcompany.com";
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
    }

    private String randomPassword(int passwordLength){
        String passwordSet = "ABCDEFGHIJKLMNOPRSTUVYZQW0123456789!@#$%";
        char[] password = new char[passwordLength];
        for(int i = 0; i<passwordLength; i++){
            int randomNumber = (int) (Math.random() *
                    (Math.random() * passwordSet.length()));
            password[i] = passwordSet.charAt(randomNumber);
        }
        return new String(password).toLowerCase();

    }

    public void setMailboxCapacity(int mailboxCapacity){
        this.mailboxCapacity = mailboxCapacity;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                " COMPANY EMAIL: " + email +
                " MAILBOX CAPACITY: " + mailboxCapacity + " mail";
    }
}
