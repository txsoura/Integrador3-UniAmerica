package com.Model.bean;

import com.Enum.UserRole;
import com.Enum.UserStatus;

public class Merchant extends User{
    private String name;
    private int cpf_cnpj,cellphone;


    public Merchant() {
	}

	public Merchant(int id,String email, String password, UserRole role, UserStatus status,String name, int cpf_cnpj, int cellphone) {
        super(id,email, password, role, status);
        this.name = name;
        this.cpf_cnpj = cpf_cnpj;
        this.cellphone = cellphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(int cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "name=" + name +
                ", cpf_cnpj=" + cpf_cnpj +
                ", cellphone=" + cellphone +
                '}';
    }
}