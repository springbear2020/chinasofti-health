package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 11:24 Monday
 */
public interface MemberMapper {
    /**
     * 根据身份证号查询会员
     */
    @Select("select * from t_member where idCard = #{idCard}")
    Member getMemberByIdCard(@Param("idCard") String idCard);

    /**
     * 保存会员
     */
    @Insert("insert into t_member(fileNumber, name, sex, idCard, phoneNumber, regTime, password, email, birthday, remark) " +
            "values (#{fileNumber},#{name},#{sex},#{idCard},#{phoneNumber},#{regTime},#{password},#{email},#{birthday},#{remark})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int saveMember(Member member);
}
