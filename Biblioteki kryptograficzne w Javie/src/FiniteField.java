import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import org.bouncycastle.crypto.generators.DHParametersGenerator;
import org.bouncycastle.crypto.params.DHParameters;
public class FiniteField {
    static String lineSeparator = "------------------------------------------------------------------";

    public static int scanner1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj pierwszy element ciała.");
        int element1 = sc.nextInt();
        return element1;
    }

    public static int scanner2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj drugi element ciała.");
        int element2 = sc.nextInt();
        return element2;
    }

    public static int scannerElementOdwrotny() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj wybrany element ciała w celu znalezienia jego elementu odwrotnego.");
        int element = sc.nextInt();
        return element;
    }

    public static BigInteger scanner3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj pierwszy element ciała.");
        BigInteger element11 = sc.nextBigInteger();
        return element11;
    }

    public static BigInteger scanner4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj drugi element ciała.");
        BigInteger element21 = sc.nextBigInteger();
        return element21;
    }

    public static BigInteger scannerElementOdwrotny1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj wybrany element ciała w celu znalezienia jego elementu odwrotnego.");
        BigInteger element = sc.nextBigInteger();
        return element;
    }

    public static  int dodawanie(int element1, int element2, int prime){
        int wynik;
        wynik = (element1 + element2) % prime;
        return wynik;
    }

    public static  int odejmowanie(int element1, int element2, int prime){
        int wynik;
        if(element1 > element2){
            wynik = (element1 - element2) % prime;
        }
        else{
            wynik = (element2 - element1) % prime;
        }
        return wynik;
    }

    public static  int mnozenie(int element1, int element2, int prime){
        int wynik;
        wynik = (element1 * element2) % prime;
        return wynik;
    }

    public static int elementOdwrotny(int element, int prime) {
        int a = element % prime;
        int b = prime;
        int x = 0, y = 1, ostatniX = 1, ostatniY = 0;

        while (b != 0) {
            int iloraz = a / b;
            int tempA = a;
            a = b;
            b = tempA % b;
            int tempX = x;
            x = ostatniX - iloraz * x;
            ostatniX = tempX;
            int tempY = y;
            y = ostatniY - iloraz * y;
            ostatniY = tempY;
        }
        if (a != 1) {
            throw new ArithmeticException("Element nie posiada odwrotności w tym polu.");
        }
        return (ostatniX + prime) % prime;
    }

    public static  BigInteger dodawanie1(BigInteger element11, BigInteger element21, BigInteger prime1){
        BigInteger wynik;
        wynik = (element11.add(element21)).mod(prime1);
        return wynik;
    }

    public static  BigInteger odejmowanie1(BigInteger element11, BigInteger element21, BigInteger prime1){
        BigInteger wynik;
        if(element11.compareTo(element21) == 1){
            wynik = (element11.subtract(element21)).mod(prime1);
        }
        else{
            wynik = wynik = (element21.subtract(element11)).mod(prime1);
        }
        return wynik;
    }

    public static  BigInteger mnozenie1(BigInteger element11, BigInteger element21, BigInteger prime1){
        BigInteger wynik;
        wynik = (element11.multiply(element21)).mod(prime1);
        return wynik;
    }

    public static BigInteger elementOdwrotny1(BigInteger element1, BigInteger prime1) {
        BigInteger a = element1.mod(prime1);
        BigInteger b = prime1;
        BigInteger x = BigInteger.valueOf(0), y = BigInteger.valueOf(1), ostatniX = BigInteger.valueOf(1), ostatniY = BigInteger.valueOf(0);

        while (b.compareTo(BigInteger.valueOf(0)) == -1 || b.compareTo(BigInteger.valueOf(0)) == 1) {
            BigInteger iloraz = a.divide(b);
            BigInteger tempA = a;
            a = b;
            b = tempA.mod(b);
            BigInteger tempX = x;
            x = ostatniX.subtract(iloraz.multiply(x));
            ostatniX = tempX;
            BigInteger tempY = y;
            y = ostatniY.subtract(iloraz.multiply(y));
            ostatniY = tempY;
        }
        if (a.compareTo(BigInteger.valueOf(1)) == -1 || a.compareTo(BigInteger.valueOf(1)) == 1) {
            throw new ArithmeticException("Element nie posiada odwrotności w tym polu.");
        }
        return (ostatniX.add(prime1)).mod(prime1);
    }

    public static void SmallPrimeNumbers() {
        Random random = new Random();
        BigInteger prime = BigInteger.probablePrime(7, random);
        while (prime.compareTo(BigInteger.TEN) < 0 || prime.compareTo(BigInteger.valueOf(100)) > 0) {
            prime = BigInteger.probablePrime(7, random);
        }
        System.out.println("Wygenerowana liczba pierwsza z zakresu od 10 do 100: " + prime);
        int[] GF = new int[prime.intValue()];
        for (int i = 0; i < prime.intValue(); i++) {
            GF[i] = i;
        }
        System.out.println("Elementy ciała to:");
        System.out.println(Arrays.toString(GF));

        int element1 = scanner1();
        int element2 = scanner2();

        if (element1 < prime.intValue() && element2 < prime.intValue()) {
            System.out.println("Wynik dodawania to: " + dodawanie(element1, element2, prime.intValue()));
            System.out.println("Wynik odejmowania to: " + odejmowanie(element1, element2, prime.intValue()));
            System.out.println("Wynik mnożenia to: " + mnozenie(element1, element2, prime.intValue()));
        } else {
            while(element1 >= prime.intValue() || element2 >= prime.intValue()) {
                System.out.println("Podane elementy są za duże.");
                element1 = scanner1();
                element2 = scanner2();
                if(element1 < prime.intValue() && element2 < prime.intValue()) {
                    System.out.println("Wynik dodawania to: " + dodawanie(element1, element2, prime.intValue()));
                    System.out.println("Wynik odejmowania to: " + odejmowanie(element1, element2, prime.intValue()));
                    System.out.println("Wynik mnożenia to: " + mnozenie(element1, element2, prime.intValue()));
                    break;
                }
            }
        }
        int element = scannerElementOdwrotny();

        if(element < prime.intValue()){
            System.out.println("Element odwrotny do elementu " + element + " to: " + elementOdwrotny(element, prime.intValue()));
        }
        else {
            while(element >= prime.intValue()) {
                System.out.println("Podany element jest za duży.");
                element = scannerElementOdwrotny();
                if(element1 < prime.intValue() && element2 < prime.intValue()) {
                    System.out.println("Element odwrotny do elementu " + element + " to: " + elementOdwrotny(element, prime.intValue()));
                    break;
                }
            }
        }
    }

    public static void BigPrimeNumbers() {
        SecureRandom random1 = new SecureRandom(); //pakiet java.security (JCA)
        DHParametersGenerator paramsGenerator = new DHParametersGenerator(); //org.bouncycastle.crypto.generators (Bouncy Castle)
        paramsGenerator.init(1024, 100, random1);
        DHParameters params = paramsGenerator.generateParameters();
        BigInteger prime1 = params.getP();
        System.out.println(lineSeparator);
        System.out.println("Wygenerowana liczba pierwsza o długości 1024 bitów: " + prime1);
        BigInteger element11 = scanner3();
        BigInteger element21 = scanner4();

        if(element11.compareTo(prime1) == -1 && element21.compareTo(prime1) == -1) {
            System.out.println("Wynik dodawania to: " + dodawanie1(element11, element21, prime1));
            System.out.println("Wynik odejmowania to: " + odejmowanie1(element11, element21, prime1));
            System.out.println("Wynik mnożenia to: " + mnozenie1(element11, element21, prime1));
        } else {
            while(prime1.compareTo(element11) == 1 || prime1.compareTo(element11) == 0 || prime1.compareTo(element21) == 1 || prime1.compareTo(element21) == 21) {
                System.out.println("Podane elementy są za duże.");
                element11 = scanner3();
                element21 = scanner4();
                if(element11.compareTo(prime1) == -1 && element21.compareTo(prime1) == -1) {
                    System.out.println("Wynik dodawania to: " + dodawanie1(element11, element21, prime1));
                    System.out.println("Wynik odejmowania to: " + odejmowanie1(element11, element21, prime1));
                    System.out.println("Wynik mnożenia to: " + mnozenie1(element11, element21, prime1));
                    break;
                }
            }
        }

        BigInteger element = scannerElementOdwrotny1();

        if(element.compareTo(prime1) == -1) {
            System.out.println("Element odwrotny do elementu " + element + " to: " + elementOdwrotny1(element, prime1));
        } else {
            while(prime1.compareTo(element) == 1 || prime1.compareTo(element) == 0) {
                System.out.println("Podan element jest za duży.");
                element = scannerElementOdwrotny1();
                if(element11.compareTo(prime1) == -1 && element21.compareTo(prime1) == -1) {
                    System.out.println("Element odwrotny do elementu " + element + " to: " + elementOdwrotny1(element, prime1));
                    break;
                }
            }
        }
    }

    public static void presentation1() {
        SmallPrimeNumbers();
        BigPrimeNumbers();
    }

}
