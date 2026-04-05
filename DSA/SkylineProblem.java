import java.util.Scanner;

public class SkylineProblem {

    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1)
            return encodedText;

        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder res = new StringBuilder(n);

        for (int c = 0; c < cols; c++) {
            int r = 0, j = c;
            while (r < rows && j < cols) {
                res.append(encodedText.charAt(r * cols + j));
                r++;
                j++;
            }
        }

        int end = res.length() - 1;
        while (end >= 0 && res.charAt(end) == ' ') {
            end--;
        }

        return res.substring(0, end + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the encoded text: ");
        String encodedText = scanner.nextLine();
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        SkylineProblem solution = new SkylineProblem();
        String decodedText = solution.decodeCiphertext(encodedText, rows);
        System.out.println("Decoded text: " + decodedText);

        scanner.close();
    }

}

