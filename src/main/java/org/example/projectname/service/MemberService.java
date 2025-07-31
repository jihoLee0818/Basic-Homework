package org.example.projectname.service;


import lombok.RequiredArgsConstructor;
import org.example.projectname.dto.MemberRequest;
import org.example.projectname.dto.MemberResponse;
import org.example.projectname.entity.Member;
import org.example.projectname.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse save(MemberRequest memberRequest) {
        Member savedMember = memberRepository.save(new Member(memberRequest.getName()));
        return new MemberResponse(savedMember.getId(), savedMember.getName());
    }

    @Transactional(readOnly = true)
    public List<MemberResponse> findMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponse> dtos = new ArrayList<>();

        for (Member member : members) {
            MemberResponse memberResponse = new MemberResponse(
                    member.getId(),
                    member.getName());
            dtos.add(memberResponse);
        }
        return dtos;
    }

    @Transactional
    public MemberResponse update(Long memberId, MemberRequest memberRequest) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 memberID가 없습니다.")
        );

        member.updateName(memberRequest.getName());

        return new MemberResponse(member.getId(), member.getName());
    }

    @Transactional
    public void deleteMember(Long memberId) {
        boolean exists = memberRepository.existsById(memberId);

        if(!exists) {
            throw new IllegalArgumentException("해당하는 memberID가 없습니다.");
        }
        memberRepository.deleteById(memberId);
    }

    @Transactional(readOnly = true)
    public MemberResponse findMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 memberID가 없습니다.")
        );
        return new MemberResponse(member.getId(), member.getName());
    }
}


