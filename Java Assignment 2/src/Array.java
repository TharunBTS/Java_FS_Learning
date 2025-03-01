import java.util.*;
class Arr
{
    int [] arr = {1,2,3,4,5,6,7,8,9,10};
    public void Check()
    {
        ArrayList<Integer> l = new ArrayList<Integer>();
        {
            for (int i = 0; i < arr.length; i++)
            {
                if(arr[i]%2!=0)
                    l.add(arr[i]);
            }
            for (int i = 0; i < arr.length; i++)
            {
                if(arr[i]%2==0)
                    l.add(arr[i]);
            }
        }
        System.out.println(l);
    }

}
public class Array {
    public static void main(String[] args) {
        Arr a = new Arr();
        a.Check();
    }
}
