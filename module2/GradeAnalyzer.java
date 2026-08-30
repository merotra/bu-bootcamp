import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GradeAnalyzer {

    // Step 1: Read scores from file
    public static ArrayList<Integer> readScores(String inputFile) {

        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(inputFile))) {

            String line;

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                // Skip blank lines
                if (line.isEmpty()) {
                    continue;
                }

                try {
                    int score = Integer.parseInt(line);

                    // Only accept scores from 0 to 100
                    if (score >= 0 && score <= 100) {
                        scores.add(score);
                    } else {
                        System.out.println(
                                "Warning: Score out of range skipped: " + score
                        );
                    }

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Warning: Invalid score skipped: " + line
                    );
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error reading file: " + e.getMessage()
            );
        }

        return scores;
    }

    // Step 4: Calculate average
    public static double calculateAverage(ArrayList<Integer> scores) {

        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }

    // Step 7: Write report
    public static void writeReport(
            String outputFile,
            double avg,
            int high,
            int low,
            int countA,
            int countB,
            int countC,
            int countD,
            int countF) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(outputFile))) {

            writer.write(
                    String.format("Average score: %.2f%n", avg)
            );

            writer.write(
                    String.format("Highest score: %d%n", high)
            );

            writer.write(
                    String.format("Lowest score: %d%n", low)
            );

            writer.write(System.lineSeparator());

            writer.write(
                    String.format("A grades: %d%n", countA)
            );

            writer.write(
                    String.format("B grades: %d%n", countB)
            );

            writer.write(
                    String.format("C grades: %d%n", countC)
            );

            writer.write(
                    String.format("D grades: %d%n", countD)
            );

            writer.write(
                    String.format("F grades: %d%n", countF)
            );

        } catch (IOException e) {

            System.out.println(
                    "Error writing report: " + e.getMessage()
            );
        }

        // Print same report to terminal
        System.out.printf("Average score: %.2f%n", avg);
        System.out.printf("Highest score: %d%n", high);
        System.out.printf("Lowest score: %d%n", low);

        System.out.println();

        System.out.printf("A grades: %d%n", countA);
        System.out.printf("B grades: %d%n", countB);
        System.out.printf("C grades: %d%n", countC);
        System.out.printf("D grades: %d%n", countD);
        System.out.printf("F grades: %d%n", countF);
    }

    public static void main(String[] args) {

        // Step 1: Read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");

        // Make sure scores were found
        if (scores.isEmpty()) {

            System.out.println("No valid scores found.");
            return;
        }

        // Step 4: Calculate average
        double average = calculateAverage(scores);

        // Step 5: Find highest and lowest scores
        int highest = scores.get(0);
        int lowest = scores.get(0);

        for (int score : scores) {

            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }
        }

        // Step 6: Count letter grades
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {

            if (score >= 90) {

                countA++;

            } else if (score >= 80) {

                countB++;

            } else if (score >= 70) {

                countC++;

            } else if (score >= 60) {

                countD++;

            } else {

                countF++;
            }
        }

        // Step 7: Write and print report
        writeReport(
                "report.txt",
                average,
                highest,
                lowest,
                countA,
                countB,
                countC,
                countD,
                countF
        );
    }
}