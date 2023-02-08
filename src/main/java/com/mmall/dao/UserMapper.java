package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /*
    判断用户是否存在
     */
    int checkUsername(String username);
    /*
    判断email是否存在
     */
    int checkEmail(String email);
    /*
    判断用户账号密码输入是否正确
     */
    User selectLogin(@Param("username") String username, @Param("password") String password);

    /*
    根据用户名获取密保问题
     */
    String selectQuestionByUsername(String username);

    /*
    检查答案是否正确
     */
    int checkAnswer(@Param("username")String username, @Param("question")String question, @Param("answer")String answer);

    /*
    重置密码
     */
    int updatePasswordByUsername(@Param("username")String username, @Param("passwordNew")String passwordNew);

    /*
    验证是否是当前用户的密码
     */
    int checkPassword(@Param("password") String password, @Param("userId") int userId);

    /*
    更新用户信息时 校验email是否被使用了
     */
    int checkEmailByUserId(@Param("email") String email, @Param("userId") int userId);



}