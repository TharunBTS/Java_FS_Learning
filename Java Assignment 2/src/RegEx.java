import java.util.*;
import java.util.regex.Pattern;

class Validate
{
    public static boolean validName(String name)
    {
        boolean validate = Pattern.matches("[A-Z][a-z]+",name);
        return validate;
    }
    public static boolean validAge(String age)
    {
        boolean validate = Pattern.matches("[0-9]{2}",age);
        return validate;
    }
    public static boolean validEmail(String email)
    {
        boolean validate = Pattern.matches
                ("[a-zA-z0-9]+(\\.[A-Za-z0-9]*)*@[a-zA-z0-9]+([\\.A-za-z0-9]*)*"
                        ,email);
        return validate;
    }
}

public class RegEx {
    public static void main(String[] args) {
        Validate v = new Validate();
        boolean b1 = v.validName("Adhav");
        boolean b2 = v.validAge("21");
        boolean b3 = v.validEmail("adhav@gmail.com");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
