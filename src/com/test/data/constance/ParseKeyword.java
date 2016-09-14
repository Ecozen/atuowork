package com.test.data.constance;

import java.util.List;

import com.test.utils.RegExp;

public class ParseKeyword {
    public List<String> getKeywords(String p){
        String reg = "(?<=(?<!\\\\)\\$\\{)(.*?)(?=(?<!\\\\)\\})";    
        RegExp re = new RegExp();
        List<String> list = re.find(reg, p);
        return list;
    }
}
