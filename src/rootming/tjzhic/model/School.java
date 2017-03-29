package rootming.tjzhic.model;

import java.util.LinkedHashMap;

/**
 * Created by rootming on 2017/2/25.
 */
public class School extends Model {

    private Integer id;
    private String code;        //招生代码
    private String name;        //学校名称
    private String address;     //学校地址
    private String zip;         //学校邮编
    private String tel;         //学校联系电话
    private String testName;    //招生名称
    private String year;        //招生年份


    @Override
    protected void init() {
        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        fields.put("school_code", "key");
        fields.put("school_name", null);
        fields.put("school_address", null);
        fields.put("school_zip", null);
        fields.put("school_tel", null);
        fields.put("school_testName", null);
        fields.put("school_year", null);
        setTableName("`school`");
        setFieldsList(fields);
    }

    public School() {
        super();
    }

    public School(int id, String code, String name, String address, String zip, String tel, String testName, String year) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.tel = tel;
        this.testName = testName;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
