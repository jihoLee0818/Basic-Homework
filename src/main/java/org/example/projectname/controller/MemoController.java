package org.example.projectname.controller;

import lombok.RequiredArgsConstructor;
import org.example.projectname.dto.MemoRequest;
import org.example.projectname.dto.MemoResponse;
import org.example.projectname.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memos")
    public MemoResponse createMemo(@RequestBody MemoRequest memoRequest){
        return memoService.save(memoRequest);
    }

    @GetMapping("/memos")
    public List<MemoResponse> getMemos(){
        return memoService.findMemos();
    }

    @GetMapping("/memos/{memoId}")
    public MemoResponse getMemo(@PathVariable Long memoId){
        return memoService.findMemo(memoId);
    }

    @PutMapping("/memos/{memoId}")
    public MemoResponse updateMemo(
            @PathVariable Long memoId,
            @RequestBody MemoRequest memoRequest
    ) {
        return memoService.update( memoId, memoRequest);
    }

    @DeleteMapping("/memos/{memoId}")
    public void deleteMemo(@PathVariable Long memoId){
        memoService.deleteMemo(memoId);
    }
}
