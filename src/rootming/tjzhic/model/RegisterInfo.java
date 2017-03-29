package rootming.tjzhic.model;

import java.util.LinkedHashMap;

/**
 * Created by rootming on 2017/2/27.
 */
public class RegisterInfo extends Model {

    private Integer userID;
    private String name;
    private String username;
    private String idCode;
    private String sex;
    private String nation;
    private String political;
    private String birthday;
    private String homeAddress;
    private String source;
    private String school;
    private String gradeTime;
    private String isNew;
    private String aos;
    private String major;
    private String cet;
    private String majorName;
    private String picLocation;
    private String mobile;
    private String telephone;
    private String zip;
    private String conAddress;
    private String receiver;
    private boolean isConfirm;
    private String testcardNumber;
    private String examRoom;
    private Integer searNumber;

    @Override
    protected void init() {
        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        fields.put("reg_id", "key");
        fields.put("reg_name", null);
        fields.put("reg_username", null);
        fields.put("reg_idcode", null);
        fields.put("reg_sex", null);
        fields.put("reg_nation", null);
        fields.put("reg_political", null);
        fields.put("reg_birthday", null);
        fields.put("reg_homeaddr", null);
        fields.put("reg_source", null);
        fields.put("reg_school", null);
        fields.put("reg_new", null);
        fields.put("reg_aos", null);
        fields.put("reg_major", null);
        fields.put("reg_cet", null);
        fields.put("reg_majorname", null);
        fields.put("reg_piclocation", null);
        fields.put("reg_mobile", null);
        fields.put("reg_telephone", null);
        fields.put("reg_zip", null);
        fields.put("reg_conaddr", null);
        fields.put("reg_confirm", null);
        fields.put("reg_testcardnum", null);
        fields.put("reg_examroom", null);
        fields.put("reg_searnum", null);
        setTableName("`major`");
        setFieldsList(fields);

    }
    

    public RegisterInfo(int userID, String name, String username, String idCode, String sex, String nation, String political, String birthday, String homeAddress, String source, String school, String gradeTime, String isNew, String aos, String major, String cet, String majorName, String picLocation, String mobile, String telephone, String zip, String conAddress, String receiver, boolean isConfirm, String testcardNumber, String examRoom, int searNumber) {
        this.userID = userID;
        this.name = name;
        this.username = username;
        this.idCode = idCode;
        this.sex = sex;
        this.nation = nation;
        this.political = political;
        this.birthday = birthday;
        this.homeAddress = homeAddress;
        this.source = source;
        this.school = school;
        this.gradeTime = gradeTime;
        this.isNew = isNew;
        this.aos = aos;
        this.major = major;
        this.cet = cet;
        this.majorName = majorName;
        this.picLocation = picLocation;
        this.mobile = mobile;
        this.telephone = telephone;
        this.zip = zip;
        this.conAddress = conAddress;
        this.receiver = receiver;
        this.isConfirm = isConfirm;
        this.testcardNumber = testcardNumber;
        this.examRoom = examRoom;
        this.searNumber = searNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGradeTime() {
        return gradeTime;
    }

    public void setGradeTime(String gradeTime) {
        this.gradeTime = gradeTime;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getAos() {
        return aos;
    }

    public void setAos(String aos) {
        this.aos = aos;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCet() {
        return cet;
    }

    public void setCet(String cet) {
        this.cet = cet;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getPicLocation() {
        return picLocation;
    }

    public void setPicLocation(String picLocation) {
        this.picLocation = picLocation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getConAddress() {
        return conAddress;
    }

    public void setConAddress(String conAddress) {
        this.conAddress = conAddress;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public boolean isConfirm() {
        return isConfirm;
    }

    public void setConfirm(boolean confirm) {
        isConfirm = confirm;
    }

    public String getTestcardNumber() {
        return testcardNumber;
    }

    public void setTestcardNumber(String testcardNumber) {
        this.testcardNumber = testcardNumber;
    }

    public String getExamRoom() {
        return examRoom;
    }

    public void setExamRoom(String examRoom) {
        this.examRoom = examRoom;
    }

    public int getSearNumber() {
        return searNumber;
    }

    public void setSearNumber(int searNumber) {
        this.searNumber = searNumber;
    }
}
