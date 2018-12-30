package com.wonder.bring.mapper;

import com.wonder.bring.dto.User;
import com.wonder.bring.model.SignUpReq;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    //로그인
    @Select("SELECT * FROM USERS WHERE id = #{id} AND passwd = #{passwd}")
    User findByIdAndPassword(@Param("id") final String id, @Param("passwd") final String password);

    //회원 고유 번호로 조회
    @Select("SELECT * FROM USERS WHERE userIdx = #{user_Idx}")
    User findByUserIdx(@Param("user_Idx") final int userIdx);

    // 회원 아이디로 회원 고유 번호 조회
    @Select("SELECT user_idx FROM USERS WHERE id = #{id}")
    int findByUserId(@Param("id") final String id);

    // 회원 가입
    @Insert("INSERT INTO USERS(id, passwd, nick) VALUES(#{signUpReq.id}, #{signUpReq.passwd}, #{signUpReq.nick})")
    @Options(useGeneratedKeys = true, keyColumn = "USERS.user_idx")
    void save(@Param("signUpReq") final SignUpReq signUpReq);

    // 프로필 사진 업로드
    @Update("UPDATE USERS SET profile_url = #{profileUrl} WHERE user_idx = #{userIdx}")
    void savePhoto(@Param("profileUrl") final String url, @Param("userIdx") final int idx);

    // 아이디 중복 검사
    @Select("SELECT COUNT(user_idx) FROM USERS WHERE id = {#id}")
    int checkId(@Param("id") final String id);

    // 닉네임 중복 검사
    @Select("SELECT COUNT(user_id) FROM USERS WHERE nick = {#nick}")
    int checkNick(@Param("nick") final String nick);

}

