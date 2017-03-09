package rootming.tjzhic.model;

/**
 * Created by rootming on 2017/2/27.
 */
public class Grade extends Model {

    private String cardNumber;          //准考证号码
    private String courseCode;          //课程代码
    private int score;                  //分数
    private String note;                //备注
    private boolean status;             //成绩是否可以修改

    @Override
    protected void init() {

    }

    public Grade(String cardNumber, String courseCode, int score, String note, boolean status) {
        this.cardNumber = cardNumber;
        this.courseCode = courseCode;
        this.score = score;
        this.note = note;
        this.status = status;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
