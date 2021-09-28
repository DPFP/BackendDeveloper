import java.util.HashSet;
import java.util.Set;

public class Sept27thUniqueEmail {
    public int numUniqueEmails(String[] emails) {
        // before @ remove "." and anything after "+"
        // add to hashSet
        // return size of hashSet
        Set<String> unique = new HashSet<>();

        String temp = "";
        for (String email : emails) {
            temp = email.split("@")[0]; // get everything before @

            if (temp.indexOf('+') > -1) {
                temp = temp.split("\\+")[0]; // get everything before + (need escape)
            }

            if (temp.indexOf('.') > -1) {
                temp = temp.replaceAll("\\.", ""); // replace all "."
            }

            temp = temp + "@" + email.split("@")[1]; // put it all together again
            unique.add(temp);
        }
        return unique.size();
    }

    public static void main(String[] args) {
        Sept27thUniqueEmail sol = new Sept27thUniqueEmail();
        String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com" };
        String[] emails2 = { "a@leetcode.com", "b@leetcode.com", "c@leetcode.com" };
        String[] emails3 = { "test.emailalex@leetcode.com", "test.e.mailbob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com" };
        String[] emails4 = { "test.email+alex@leetcode.com", "test.email.leet+alex@code.com" };

        System.out.println(sol.numUniqueEmails(emails4));
        ;
    }
}