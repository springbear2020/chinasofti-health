package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.MemberService;
import cn.edu.whut.binary.health.common.pojo.Member;
import cn.edu.whut.binary.health.provider.mapper.MemberMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 11:28 Monday
 */
@Service(interfaceClass = MemberService.class)
@org.springframework.stereotype.Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member getMemberByIdCard(String idCard) {
        return memberMapper.getMemberByIdCard(idCard);
    }

    @Override
    public boolean saveMember(Member member) {
        return memberMapper.saveMember(member) == 1;
    }
}
