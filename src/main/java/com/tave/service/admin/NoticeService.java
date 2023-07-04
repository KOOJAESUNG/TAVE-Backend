package com.tave.service.admin;
import com.tave.api.sse.SseService;
import com.tave.domain.admin.AdminEntity;
import com.tave.domain.admin.NoticeEntity;
import com.tave.dto.admin.NoticeDto;
import com.tave.mapper.admin.NoticeMapper;
import com.tave.repository.admin.AdminRepository;
import com.tave.repository.admin.NoticeRepository;
import com.tave.api.aws.S3Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class NoticeService {

    private final NoticeRepository noticeRepository;

    private final AdminRepository adminRepository;
    private final NoticeMapper noticeMapper;

    private final S3Service s3Service;

    private final SseService sseService;



    @Transactional
    public NoticeDto.NoticeResponseDto createNotice(Long adminId, NoticeDto.NoticePostDto noticePostDto) {
        AdminEntity adminEntity = adminRepository.findById(adminId).orElseThrow(EntityNotFoundException::new);
        //PostDto->Entity, save, Entity->ResponseDto, return
        NoticeEntity savedNotice = noticeRepository.save(noticeMapper.toEntity(noticePostDto, adminEntity));
        NoticeDto.NoticeResponseDto responseDto = noticeMapper.toResponseDto(savedNotice);

        // 생성된 공지사항에 대한 SSE 이벤트 전송
        sseService.sendEventToAll("create", responseDto);

        return responseDto;
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
    public List<String> updateNoticeImages(Long noticeId, List<MultipartFile> imageList) {
        NoticeEntity noticeEntity = noticeRepository.findById(noticeId).orElseThrow(EntityNotFoundException::new);
        noticeEntity.getImages().forEach(s3Service::deleteFile);
        noticeEntity.updateNoticeImages(s3Service.uploadFileList(imageList));
        return noticeRepository.findById(noticeId).orElseThrow(EntityNotFoundException::new).getImages();
    }

    @Transactional
    public void deleteNotice(Long noticeId) {
        noticeRepository.deleteById(noticeId);
        log.info("NoticeEntity Id: {} is deleted", noticeId);
    }

    @Transactional
    public List<NoticeDto.NoticeResponseDto> getAllNotice(){

        List<NoticeEntity> noticeEntities = noticeRepository.getAllNotice();
        List<NoticeDto.NoticeResponseDto> noticeResponseDtos = new ArrayList<>();

        for (NoticeEntity noticeEntity : noticeEntities) {
            NoticeDto.NoticeResponseDto noticeResponseDto = noticeMapper.toResponseDto(noticeEntity);
            noticeResponseDtos.add(noticeResponseDto);
        }

        return noticeResponseDtos;
    }

}


