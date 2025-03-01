
interface In {

    void setter();

    void getter(int id, String name);
}
class In1 implements In
{

    int id;
    String name;

    @Override
    public void getter(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public void setter() {
        System.out.println("ID : "+id+ "\n"+"Name : " +name);
    }

}
public class Inf {
    public static void main(String[] args) {
        In1 i = new In1();
        i.getter(1,"Adhav");
        i.setter();
    }
}
