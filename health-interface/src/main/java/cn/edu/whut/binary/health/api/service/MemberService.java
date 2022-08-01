package cn.edu.whut.binary.health.api.service;

import cn.edu.whut.binary.health.common.pojo.Member;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 11:28 Monday
 */
public interface MemberService {
    /**
     * 根据身份证号查询会员
     */
    Member getMemberByIdCard(String idCard);

    /**
     * 保存会员
     */
    boolean saveMember(Member member);
}
