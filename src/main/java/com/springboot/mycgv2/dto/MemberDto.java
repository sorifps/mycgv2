package com.springboot.mycgv2.dto;

import lombok.Data;

@Data
public class MemberDto {

    String id, pass, name, gender, email1, email2, addr1, addr2, tel, phone1, phone2, phone3, intro;
    String[] hobby;

    //member ���̺� �÷� ����
    int rno;
    String email, addr, pnumber, hobbyList, mdate, grade;


    public String getId() {
        return id;
    }
    public String getGrade() {
        return grade;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPass() {
        return pass;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getEmail1() {
        return email1;
    }
    public String getEmail2() {
        return email2;
    }
    public String getAddr1() {
        return addr1;
    }
    public String getAddr2() {
        return addr2;
    }
    public String getTel() {
        return tel;
    }
    public String getPhone1() {
        return phone1;
    }
    public String getPhone2() {
        return phone2;
    }
    public String getPhone3() {
        return phone3;
    }
    public String getIntro() {
        return intro;
    }
    public String[] getHobby() {
        return hobby;
    }
    public int getRno() {
        return rno;
    }
    public String getEmail() {
        if(email1 != null) { //������ email �ּҰ� �Ѿ�� ���
            email = email1+"@"+email2;
        }
        return email;
    }
    public String getAddr() {
        if(addr1 != null) {
            addr = addr1 + addr2;
        }
        return addr;
    }
    public String getPnumber() {
        if(phone1 != null) {
            pnumber = phone1+"-"+phone2+"-"+phone3;
        }
        return pnumber;
    }
    public String getHobbyList() {
        if(hobby != null) {
            hobbyList = String.join(",", hobby);
        }
        return hobbyList;
    }
    public String getMdate() {
        return mdate;
    }




}
