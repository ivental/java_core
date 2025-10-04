package variables;

public class PersonalCard {
    public static void main(String[] args) {
        String name = "ILIA";
        String surname = "IUKIN";
        String city = "Saint-Petersburg";
        int age = 135;
        int height = 280;
        double weight = 183.2d;
        boolean isStudent = true;
        char firstLetterName = name.charAt(0);
        System.out.println("===== PERSONAL INFO =====");
        System.out.println("First Name: " + name);
        System.out.println("Second Name: " + surname);
        System.out.println("City: " + city );
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Student: " + isStudent);
        System.out.println("First Letter Name: " + firstLetterName);
        System.out.println("==========================");
    }
}
