package com.tave.domain;

import com.tave.constant.Role;

// Spring Security를 위한 Entity입니다!! 수정하지 말아주세요
public interface UserEntity {

    public Long getId();
    public String getUsername();

    public Role getRole();

    public String getPassword();

    public void setUsername(String username);


    public void setPassword(String password);

}
