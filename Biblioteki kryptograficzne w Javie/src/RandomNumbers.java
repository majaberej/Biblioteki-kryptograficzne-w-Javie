import java.util.Random;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumbers {
    static String lineSeparator = "------------------------------------------------------------------";
    private static void writeGen1(int upperBound){
        Random generator1 = new Random();
        int x = generator1.nextInt(upperBound);
        double y = generator1.nextDouble(upperBound);
        double z = generator1.nextDouble(upperBound);
        writeOut(upperBound, x,y,z,"Random class from java.util.Random");
    }

    private static void writeGen2(int upperBound){
        int x2 = (int)Math.floor((Math.random() * (upperBound + 1)));
        double y2 = Math.random() * (upperBound + 1);
        double z2 = Math.random() * (upperBound + 1);
        writeOut(upperBound,x2,y2,z2,"Math.random() method from java.lang.Math");
    }
    private static void writeGen3(int upperBound){
        int x3 = ThreadLocalRandom.current().nextInt(0, upperBound + 1);
        double y3 = ThreadLocalRandom.current().nextDouble(0, upperBound + 1);
        double z3 = ThreadLocalRandom.current().nextDouble(0, upperBound + 1);
        writeOut(upperBound,x3,y3,z3,"class ThreadLocalRandom from java.util.concurrent.ThreadLocalRandom");
    }
    private static void writeGen4(int upperBound){
        SecureRandom generator4 = new SecureRandom();
        int x4 = generator4.nextInt(upperBound);
        double y4 = generator4.nextDouble(upperBound);
        double z4 = generator4.nextDouble(upperBound);
        writeOut(upperBound, x4,y4,z4,"SecureRandom class from java.util.SecureRandom");
    }

    private static void writeOut(int upperBound, int x, double y, double z, String using){
        System.out.println("Results of using the " + using);
        System.out.println("Random integer value from 0 to " + (upperBound-1) + ": " + x);
        System.out.println("Random double  value from 0 to " + (upperBound-1) + ": " + y);
        System.out.println("Random double  value from 0 to " + (upperBound-1) + ": " + z);
        System.out.println(lineSeparator);
    }

    public static void presentation(int upperBound){
        writeGen1(upperBound);
        writeGen2(upperBound);
        writeGen3(upperBound);
        writeGen4(upperBound);
    }

}
