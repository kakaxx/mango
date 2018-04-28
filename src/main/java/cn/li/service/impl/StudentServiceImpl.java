package cn.li.service.impl;

import cn.li.dto.ResponseData;
import cn.li.entity.Student;
import cn.li.service.StudentService;
import cn.li.util.HttpUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService{
    @Override
    public ResponseData checkNum(String studentNum, String name, HttpSession httpSession) {
        if(studentNum != null && name != null){//输入的内容非法
            String result = HttpUtils.sendGet(studentNum);
            System.out.println(result);
            //Map<String,Object> allData = JSON.parseObject(result,Map.class);
            JSONObject jsonObject = JSON.parseObject(result);
            if(jsonObject.getInteger("status") != 200 || result == null){//请求失败
                return new ResponseData(-1,"网络请求异常");
            }else {
                //Map<String,Object> temp = JSON.parseObject(allData.get("data").toString(),Map.class);
                //Map<String,String> data = JSON.parseObject(temp.get("rows").toString(),Map.class);
                JSONObject data = jsonObject.getJSONObject("data");
                JSONArray jsonArray = data.getJSONArray("rows");
                JSONObject student = jsonArray.getJSONObject(0);
                Map<String,Object> map = student;
                if(!name.equals(map.get("xm"))){//请求学号对应名字与请求名字不符合
                    return new ResponseData(0,"信息错误");
                }else {//正确绑定情况
                    httpSession.setAttribute("student",map);
                    return new ResponseData(1,"正确");
                }
            }
        }else {
            return new ResponseData(-1,"信息不完整");
        }
    }
}
