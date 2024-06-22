import java.math.BigInteger;
import java.util.Scanner;

public class DiffieHellmanExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Given values for the smaller example
//        BigInteger p = new BigInteger("107");
//        BigInteger g = new BigInteger("3");

        // Uncomment the lines below for the actual task
         BigInteger p = new BigInteger("74406850220820509198642540543");
         BigInteger g = new BigInteger("7440685022082509198642540541");

        // Prompt user for private key b
        BigInteger b = p.add(BigInteger.ONE);
        while (b.compareTo(p.subtract(BigInteger.ONE)) > 0 || b.compareTo(BigInteger.ZERO) < 0) {
            System.out.print("Bitte wählen Sie Ihren geheimen Parameter b: ");
            String bInput = scanner.nextLine();
            b = new BigInteger(bInput);
        }

//        BigInteger A = new BigInteger("19630064516685326108960632159");
//        BigInteger B = new BigInteger("17243764383965318353097666820");

        // Calculate the public key B
        BigInteger B = g.modPow(b, p);
        System.out.println("Der öffentliche Teil Ihres Schlüssels ist: " + B);

        // Get the partner's public key A
        System.out.print("Was ist der öffentliche Teil des Schlüssels Ihres Partners? ");
        String AInput = scanner.nextLine();
        BigInteger A = new BigInteger(AInput);

        // Calculate the shared secret key k_b
        BigInteger k_b = A.modPow(b, p);
        System.out.println("Ihr geheimer Schlüssel ist: " + k_b);
    }
}
