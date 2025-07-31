package org.example.projectname.service;

import lombok.RequiredArgsConstructor;
import org.example.projectname.dto.MemoRequest;
import org.example.projectname.dto.MemoResponse;
import org.example.projectname.entity.Memo;
import org.example.projectname.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponse save(MemoRequest memoRequest){
        Memo savedMemo = memoRepository.save(new Memo(memoRequest.getContent()));
        return new MemoResponse(savedMemo.getId(), savedMemo.getContent());
    }

    @Transactional(readOnly = true)
    public List<MemoResponse> findMemos(){
        List<Memo> memos = memoRepository.findAll();
        List<MemoResponse> dtos = new ArrayList<>();

        for (Memo memo : memos) {
            MemoResponse memoResponse = new MemoResponse(
                    memo.getId(),
                    memo.getContent()
            );
            dtos.add(memoResponse);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public MemoResponse findMemo(Long memoId){
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 memoID가 없습니다.")
        );
        return new MemoResponse(memo.getId(), memo.getContent());
    }

    @Transactional
    public MemoResponse update(Long memoId, MemoRequest memoRequest) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 memoID가 없습니다.")
        );
        memo.updateContent(memoRequest.getContent());
        return new MemoResponse(
                memo.getId(),
                memo.getContent()
        );
    }

    @Transactional
    public void deleteMemo(Long memoId){
        boolean exists = memoRepository.existsById(memoId);
        if (!exists){
            throw new IllegalArgumentException("해당하는 memoID가 없습니다.");
        }
        memoRepository.deleteById(memoId);
    }
}
