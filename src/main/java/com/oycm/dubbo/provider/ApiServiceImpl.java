package com.oycm.dubbo.provider;

import com.oycm.dubbo.api.ApiService;

public class ApiServiceImpl implements ApiService {

    @Override
    public String hello(String name) {
        return "hello, " + name;
    }
}
