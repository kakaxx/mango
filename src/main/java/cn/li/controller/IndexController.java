package cn.li.controller;

import cn.li.dto.ResponseData;
import cn.li.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/mango")
public class IndexController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData register(@RequestBody Map<String,String > map, HttpSession httpSession){
        return studentService.checkNum(map.get("studentNum"),map.get("name"),httpSession);
    }
}
