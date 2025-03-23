import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class QuestionBank {
    final int TOTAL_QUESTION = 5;
    Question[] questions = new Question[TOTAL_QUESTION];
    String selection[] = new String[TOTAL_QUESTION];

    public QuestionBank(String filePath) {
        loadQuestionFromCSV(filePath);
    }

    public void loadQuestionFromCSV(String filePath) {
        try {
            File obj = new File(filePath);
            Scanner myReader = new Scanner(obj);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] questionFromText = data.split(",");
                String[] opt = Arrays.copyOfRange(questionFromText, 2, 6);
                questions[i] = new Question(Integer.parseInt(questionFromText[0]), questionFromText[1], opt,
                        questionFromText[6]);
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void playQuiz() {
        int i = 0;
        for (Question question : questions) {
            System.out.println("Question no.: " + question.getId());
            System.out.println(question.getQuestion());
            String[] opt = question.getOpt();
            for (String option : opt) {
                System.out.println(option);
            }
            Scanner sc = new Scanner(System.in);
            selection[i] = sc.nextLine();
            i++;
        }
    }

    public void showScore(){
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            String answer = questions[i].getAnswer();
            String userAnswer = selection[i];
            if(answer.equals(userAnswer)){
                score++;
            }
        }

        System.out.println("Your score is: " + score);
    }
}
