import java.util.Scanner;

public class TriangleArea02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int aX=s.nextInt();
        int aY=s.nextInt();
        s.nextLine();
        int bX=s.nextInt();
        int bY=s.nextInt();
        s.nextLine();
        int cX=s.nextInt();
        int cY=s.nextInt();
        s.nextLine();

        int area=(aX*(bY-cY)+bX*(cY-aY)+cX*(aY-bY))/2;

        if(area<0){
            area=area*(-1);
        }
        System.out.println(area);
    }
}
