import java.text.DecimalFormat;
import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        double b = s.nextDouble();
        double c = s.nextDouble();

        String hexa = Integer.toHexString(a).toUpperCase();
        String binary = Integer.toBinaryString(a);

        String decimamTwoPoint = String.format("%.2f",b);
        String decimamThreePoint = String.format("%.3f",c);

        //hexadecimal, left aligned
        String outputHexa = "|" + hexa;
        int hexaLength = 10 - outputHexa.length();
        for (int i = 0; i <= hexaLength; i++) {
            outputHexa += " ";
        }
        outputHexa = outputHexa + "|";

        //binary form, padded with zeroes
        int binaryLenght = 10 - binary.length();
        String outputBinary = "";
        for (int i = 0; i < binaryLenght; i++) {
            outputBinary+="0";
        }
        outputBinary=outputBinary+binary+"|";

        //2 digits after the decimal point, right aligned
         int twoDigitsAfterPointLenght=10-decimamTwoPoint.length();
         String outputTwoDigit="";
        for (int i = 0; i < twoDigitsAfterPointLenght; i++) {
            outputTwoDigit+=" ";
        }
        outputTwoDigit+=decimamTwoPoint+"|";

        //printed with 3 digits after the decimal point, left aligned
        int threeDigitsAfterPointLenght=10-decimamThreePoint.length();
        String outputThreeDigits=decimamThreePoint;
        for (int i = 0; i < threeDigitsAfterPointLenght; i++) {
            outputThreeDigits+=" ";
        }
        outputThreeDigits+="|";

        System.out.print(outputHexa);
        System.out.print(outputBinary);
        System.out.print(outputTwoDigit);
        System.out.println(outputThreeDigits);

    }
}
