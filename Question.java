public class Question {

    private int id;
    private String question;
    private String[] opt = new String[4];
    private String answer;

    public Question(int id, String question, String[] opt, String answer) {
        this.id = id;
        this.question = question;
        this.opt = opt;
        this.answer = answer;
    }

    public void displayQuestion(){
        System.out.println(this.id);
        System.out.println(this.question);
        for (String string : opt) {
            System.out.println(string);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOpt() {
        return opt;
    }

    public void setOpt(String[] opt) {
        this.opt = opt;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
