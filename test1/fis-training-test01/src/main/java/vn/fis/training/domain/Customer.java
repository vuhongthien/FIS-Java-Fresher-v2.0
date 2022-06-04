package vn.fis.training.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {

    /** ID cua Customer la duy nhat trong toan bo he thong
       Su dung @java.util.UUID de tao id gan cho tung customer
    */
    private String id;
    public static int createID() {
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;
        int uid=str.hashCode();
        String filterStr=""+uid;
        return Integer.parseInt(filterStr);
    }

    /** Constraints:
        1. Khong duoc trong (NOT NULL OR BLANK)
        2. Do dai tu tu 5 den 50 ky tu, chi bao gom ky tu a->z, A->Z va khong trang (Blank).
        3. Truoc khi cap nhat vao he thong truong ten phai duoc chuan hoa.
            Qui tac chuan hoa:
                *. Bo cac ky tu trang o dau va cuoi
                *. Upper case chu cai dau tien truoc cac tu
                   VD: nGuyen van    BinH      -> Nguyen Van Binh
    **/

    private String name;
    public int checkName(String name){
        Pattern letter = Pattern.compile("[a-zA-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasLetter = letter.matcher(name);
        Matcher hasDigit = digit.matcher(name);
        Matcher hasSpecial = special.matcher(name);
        boolean bLetter = hasLetter.find();
        boolean bDigit = hasDigit.find();
        boolean bSpecial = hasSpecial.find();
        boolean checkAll = (bLetter==true && bDigit==false && bSpecial == false) ? true : false;

        if(name.isEmpty() || name.trim().isEmpty() || name.length() <5 || name.length() >50 || checkAll == false){
            return 0;
        }
        return 1;

    }

    /** Constraints:
        1. Khong duoc trong
        2. Tinh toan de khong cho phep nhap Customer nho hon 10 tuoi so voi thoi diem hien tai
     **/
    private LocalDate birthDay;
    public static int calculateAge(LocalDate birthDay, LocalDate currentDate) {
        if ((birthDay != null) && (currentDate != null)) {
            return Period.between(birthDay, currentDate).getYears();
        } else {
            return 0;
        }
    }

    /** Constraints:
    *   1. Do dai 10 ky tu bat dau bang ky tu 0, chi bao gom cac so tu 0->9
     *  2. So dien thoai la duy nhat trong toan bo he thong. Duoc su dung de kiem tra duplicate khach hang
     *  3. Chuan hoa lai truong so dien thoai truoc khi cap nhat vao he thong. Bo cac ky tu trang o dau, giua va cuoi
     *     Vidu: 0921 000 008 --> 0921000008
    * */
    private String mobile;
    public int checkmobile(String mobile){

        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasDigit = digit.matcher(mobile);
        Matcher hasSpecial = special.matcher(mobile);
        boolean bDigit = hasDigit.find();
        boolean bSpecial = hasSpecial.find();
        boolean checkAll = ( bDigit==false && bSpecial == false) ? true : false;

        if(mobile.isEmpty() || mobile.trim().isEmpty() || mobile.length() <5 || mobile.length() >50 || checkAll == false){
            return 0;
        }
        return 1;

    }


    /** Constraints:
     * NOT NULL
     * */

    private CustomerStatus status;

    /**
     * Thoi gian tao doi tuong. mac dinh la thoi diem hien tai
     */

    private LocalDateTime createDateTime;

    // TODO: Implement Getters, Setters, Constructors, Equals


    public Customer(String id, String name, LocalDate birthDay, String mobile, CustomerStatus status, LocalDateTime createDateTime) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.mobile = mobile;
        this.status = status;
        this.createDateTime = createDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(birthDay, customer.birthDay) && Objects.equals(mobile, customer.mobile) && status == customer.status && Objects.equals(createDateTime, customer.createDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDay, mobile, status, createDateTime);
    }
}
