package model.entity;

import constants.GenderType;

public abstract class User {
    protected final Long id;
    protected final String name;
    protected final String loginId;
    protected final String password;
    protected final String phone;
    protected final String birth;
    protected final String email;
    protected final GenderType gender;

    public User(Long id, String name, String loginId, String password, String phone, String birth, String email, GenderType gender) {
        this.id = id;
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.email = email;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public String getBirth() {
        return birth;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public GenderType getGender() {
        return gender;
    }
}
