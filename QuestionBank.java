import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class QuestionBank {
    Question[] questions = new Question[5];

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
                        questionFromText[5]);
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void displayQuestions() {
        for (Question question : questions) {
            if(question != null){
                question.displayQuestion();
            }
        }
    }
}
