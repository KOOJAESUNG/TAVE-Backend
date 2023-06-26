package com.tave.ApiTest;

import com.tave.api.sse.EmitterRepository;
import com.tave.controller.admin.NoticeController;
import com.tave.dto.admin.NoticeDto;
import com.tave.service.admin.NoticeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SseTest {

    private NoticeController noticeController;
    private NoticeService noticeService;
    private EmitterRepository emitterRepository;

    @BeforeEach
    public void setup() {
        noticeService = mock(NoticeService.class);
        emitterRepository = mock(EmitterRepository.class);
        noticeController = new NoticeController(noticeService, emitterRepository);
    }

    @Test //SSE 연결 테스트
    public void testSseConnect() throws Exception {
        Long clientId = 1L;

        // EmitterRepository를 모의 객체로 설정
        doAnswer(invocation -> {
            Long id = invocation.getArgument(0);
            SseEmitter emitter = invocation.getArgument(1);
            assertEquals(clientId, id);
            assertNotNull(emitter);
            return null;
        }).when(emitterRepository).addEmitter(eq(clientId), any(SseEmitter.class));

        // SSE 연결 엔드포인트를 호출
        ResponseEntity<SseEmitter> sseConnectResponse = noticeController.connectToSse(clientId);
        assertEquals(HttpStatus.OK, sseConnectResponse.getStatusCode());
        assertNotNull(sseConnectResponse.getBody());

        // EmitterRepository 동작을 확인
        verify(emitterRepository).addEmitter(eq(clientId), any(SseEmitter.class));
    }




    @Test //공지사항 생성 테스트
    public void testCreateNotice() {
        // NoticeService를 모의 객체로 설정
        NoticeDto.NoticePostDto postDto = new NoticeDto.NoticePostDto();
        NoticeDto.NoticeResponseDto responseDto = new NoticeDto.NoticeResponseDto();
        when(noticeService.createNotice(postDto)).thenReturn(responseDto);

        // createNotice 엔드포인트를 호출
        ResponseEntity<?> createNoticeResponse = noticeController.createNotice(postDto);
        assertEquals(HttpStatus.OK, createNoticeResponse.getStatusCode());
        assertEquals(responseDto, createNoticeResponse.getBody());

        // 동작 확인
        verify(noticeService).createNotice(postDto);
    }


}