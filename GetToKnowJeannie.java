public class GetToKnowJeannie {
    
    public static void main(String[] args) {
        // variables
        String animal = "Dog";
        String name = "Jeannie Faye Trofeo";
        String nickname = "Bebe";
        String bday = "January 8, 2007";
        String address = "Brgy. Bagacay, Tigbauan, Iloilo";
        String favsong = "Folded by Kehlani";
        String motivation = "My motivation is to create a better future for myself,\n"
                          + "to grow as a person, and to support my parents as my payback.";
        String support = "To make this semester more comfortable, I suggest\n"
                       + "that the PPTs used in discussion use simpler words and larger, more readable fonts\n "
                       + "so that all students can understand and see the content clearly.";

        // Print profile
        if (animal.equalsIgnoreCase("Dog")) {
            System.out.println("🐶 🐶 🐶");
        } else {
            System.out.println("🐱 🐱 🐱");
        }
        System.out.println("Name       : " + name + " / " + nickname);
        System.out.println("Birthday   : " + bday);
        System.out.println("Address    : " + address);
        System.out.println("Fav Song   : " + favsong);
        System.out.println("Motivation : " + motivation);
        System.out.println("Support    : " + support);
    }
}
