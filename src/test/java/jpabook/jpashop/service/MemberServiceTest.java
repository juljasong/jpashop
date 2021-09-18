package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    //@Autowired EntityManager em;

    @Test
    public void join() throws Exception {
        //given
        Member member = new Member();
        member.setName("Song Youllia");

        //when
        Long savedId = memberService.join(member);

        //then
        //em.flush();
        Assertions.assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test //@@Test(expected = IllegalStateException.class)
    public void validateDuplicateMember() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("Song Youllia");

        Member member2 = new Member();
        member2.setName("Song Youllia");

        //when
        Long savedId1 = memberService.join(member1);

        try {
            Long savedId2 = memberService.join(member2);
        } catch (IllegalStateException e) {
            return;
        }

        //then
        Assertions.fail("예외가 발생해야 한다.");

    }


}