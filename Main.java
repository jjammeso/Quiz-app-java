public class Main{
    public static void main(String[] args) {
        QuestionBank quiz = new QuestionBank("Questions.csv");
        quiz.playQuiz();
        quiz.showScore();
    }
}