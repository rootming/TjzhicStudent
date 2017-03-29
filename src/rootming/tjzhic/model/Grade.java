package rootming.tjzhic.model;

import java.util.LinkedHashMap;

/**
 * Created by rootming on 2017/2/27.
 */
public class Grade extends Model {

    private String cardNumber;          //准考证号码
    private String courseCode;          //课程代码
    private Integer score;              //分数
    private String note;                //备注
    private boolean status;             //成绩是否可以修改

    @Override
    protected void init() {
        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        fields.put("grade_number", "key");
        fields.put("grade_code", null);
        fields.put("grade_score", null);
        fields.put("grade_note", null);
        fields.put("grade_status", null);
        setTableName("`grade`");
        setFieldsList(fields);
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
