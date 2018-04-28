package cn.li.dao;

import cn.li.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
    public int addUser(@Param("student")Student student);
}