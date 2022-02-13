import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s = "prospects.txt";
        ArrayList<Prospect> customers = readFile(s);
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("**********************************************************************");
            System.out.println("Prospect " + (i + 1) + ": " + customers.get(i).getName() + " wants to borrow " + customers.get(i).getLoan() + "€ for a period of " +
                    customers.get(i).getYears() + " years and pay " + String.format("%.2f", customers.get(i).calculateMonthlyPayment()) + "€ each month");
        }


    }

    /**
     *Method for reading a file with customers data
     * @param s The path of the file
     * @return An ArrayList<Customer> where every element in the ArrayList represent a row from the file that was red
     */
    public static ArrayList<Prospect> readFile(String s) {
        ArrayList<Prospect> customers = new ArrayList<>();
        try {
            File file = new File(s);

            Scanner scanner = new Scanner(file);
            //Skip the columns names
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (!data.contains(",")) {
                    continue;
                }

                if (data.contains("\"")) {
                    String[] rowWithQuote = data.trim().split("\"", -1);
                    rowWithQuote[1] = rowWithQuote[1].replace(",", " ");
                    String[] row = rowWithQuote[2].split(",", -1);
                    customers.add(new Prospect(rowWithQuote[1], Double.parseDouble(row[1]), Double.parseDouble(row[2]), Integer.parseInt(row[3])));
                } else {
                    String[] row = data.trim().split(",", -1);

                    customers.add(new Prospect(row[0], Double.parseDouble(row[1]), Double.parseDouble(row[2]), Integer.parseInt(row[3])));

                }

            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return customers;
    }

}
