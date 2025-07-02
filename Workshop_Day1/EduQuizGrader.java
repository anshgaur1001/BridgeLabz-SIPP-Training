public class EduQuizGrader {

    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(student[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
                score++;
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
        return score;
    }

    public static void main(String[] args) {
        String[] correctAnswers = {
                "A", "B", "C", "D", "B", "A", "C", "D", "A", "B"
        };

        String[] studentAnswers = {
                "a", "b", "d", "D", "b", "c", "c", "d", "A", "b"
        };

        int finalScore = calculateScore(correctAnswers, studentAnswers);
        System.out.println("\nTotal Score: " + finalScore + " out of " + correctAnswers.length);
    }
}
