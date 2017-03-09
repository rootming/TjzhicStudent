package rootming.tjzhic.model;

/**
 * Created by rootming on 2017/2/27.
 */
public class Major extends Model {

    private String name;            //专业名称
    private int planNumber;         //计划招生人数
    private int applyNumber;        //实际录取的人数
    private int passScore;          //录取分数线
    private int passNumber;         //录取人数

    @Override
    protected void init() {

    }

    public Major(String name, int planNumber, int applyNumber, int passScore, int passNumber) {
        this.name = name;
        this.planNumber = planNumber;
        this.applyNumber = applyNumber;
        this.passScore = passScore;
        this.passNumber = passNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(int planNumber) {
        this.planNumber = planNumber;
    }

    public int getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(int applyNumber) {
        this.applyNumber = applyNumber;
    }

    public int getPassScore() {
        return passScore;
    }

    public void setPassScore(int passScore) {
        this.passScore = passScore;
    }

    public int getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }
}
