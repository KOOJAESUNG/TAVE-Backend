package com.tave.service.admin;

import com.tave.dto.admin.NoticeDto;
import com.tave.repository.admin.NoticeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public void createNotice(NoticeDto.NoticePostDto noticePostDto) {
        //dto->entity

        //update

        //entity->dto 후 return
    }

    public void getNotice(Long noticeId) {
        noticeRepository.findById(noticeId).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void updateNotice(NoticeDto.NoticePatchDto noticePatchDto) {
        //update

        //entity->dto 후 return
    }

    @Transactional
    public void deleteNotice(Long noticeId) {
        noticeRepository.deleteById(noticeId);
        log.info("Entity Id: {} is deleted",noticeId);
    }
}


