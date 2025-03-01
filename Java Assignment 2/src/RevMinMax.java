import java.net.StandardSocketOptions;

class Rev
{
    int [] arr={11,76,24,85,55,77};
    public void reverse()
    {
        int left=0,right=arr.length-1;
        while(left<right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public void display()
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public void max()
    {
        int a = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
            a=Math.max(a,arr[i]);
        System.out.println("MAXIMUM VALUE : " + a);
    }
    public void min()
    {
        int a = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
            a=Math.min(a,arr[i]);
        System.out.println("MINIMUM VALUE : " + a);
    }
}


public class RevMinMax {
    public static void main(String[] args) {
        Rev r = new Rev();
        r.reverse();
        r.display();
        r.max();
        r.min();
    }
}
