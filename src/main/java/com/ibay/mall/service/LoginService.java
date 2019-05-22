package com.ibay.mall.service;


import com.ibay.mall.pojo.front.Member;

public interface LoginService {

    Member userLogin(String username, String password);

    Member getUserByToken(String token);

    int logout(String token);
}
