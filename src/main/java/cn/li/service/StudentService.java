package cn.li.service;

import cn.li.dto.ResponseData;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface StudentService {

    public ResponseData checkNum(String studentNum, String name, HttpSession httpSession);


}
