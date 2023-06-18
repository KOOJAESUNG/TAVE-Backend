package com.tave.service.admin;

import com.tave.domain.admin.AdminEntity;
import com.tave.domain.admin.NoticeEntity;
import com.tave.dto.admin.NoticeDto;
import com.tave.mapper.admin.NoticeMapper;
import com.tave.repository.admin.AdminRepository;
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

    private final AdminRepository adminRepository;

    private final NoticeMapper noticeMapper;
    @Transactional
    public NoticeDto.NoticeResponseDto createNotice(NoticeDto.NoticePostDto noticePostDto) {
        AdminEntity adminEntity = adminRepository.findById(noticePostDto.getAdminId()).orElseThrow(EntityNotFoundException::new);
        //PostDto->Entity, save, Entity->ResponseDto, return
        return noticeMapper.toResponseDto(noticeRepository.save(noticeMapper.toEntity(noticePostDto,adminEntity)));
    }

    public NoticeDto.NoticeResponseDto getNotice(Long noticeId) {
        return noticeMapper.toResponseDto(noticeRepository.findById(noticeId).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public NoticeDto.NoticeResponseDto updateNotice(NoticeDto.NoticePatchDto noticePatchDto) {
        NoticeEntity noticeEntity = noticeRepository.findById(noticePatchDto.getId()).orElseThrow(EntityNotFoundException::new);
        //update
//        noticeEntity.updateFromPatchDto(noticePatchDto);
        noticeMapper.updateFromPatchDto(noticePatchDto,noticeEntity);
        //entity->dto 후 return
        return noticeMapper.toResponseDto(noticeRepository.findById(noticePatchDto.getId()).orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void deleteNotice(Long noticeId) {
        noticeRepository.deleteById(noticeId);
        log.info("NoticeEntity Id: {} is deleted",noticeId);
    }
}


