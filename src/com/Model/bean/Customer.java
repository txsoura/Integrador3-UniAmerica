package com.Model.bean;

import java.util.Date;

import com.Enum.UserRole;
import com.Enum.UserSex;
import com.Enum.UserStatus;
public class Customer extends User{
    private UserSex sex;
    private String name;
    private int cellphone;
    private Date birthdate;

    
    public Customer() {
	}

	public Customer(int id,String email, String password, UserRole role, UserStatus status,UserSex sex, String name, int cellphone, Date birthdate) {
        super(id, email, password, role, status);
        this.sex = sex;
        this.name = name;
        this.cellphone = cellphone;
        this.birthdate = birthdate;
    }

    public UserSex getSex() {
        return sex;
    }

    public void setSex(UserSex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "sex=" + sex +
                ", name=" + name +
                ", cellphone=" + cellphone +
                ", birthdate=" + birthdate +
                '}';
    }
}