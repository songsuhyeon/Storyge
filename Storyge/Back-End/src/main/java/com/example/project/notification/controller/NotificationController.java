package com.example.project.notification.controller;

import com.example.project.notification.model.dto.NotificationReponseDto;
import com.example.project.notification.model.service.NotificationService;
import com.example.project.user.model.jwt.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.example.project.user.model.jwt.JwtProperties.TOKEN_HEADER;
import static com.example.project.user.model.jwt.JwtProperties.TOKEN_PREFIX;

@RestController
@RequiredArgsConstructor
@Api(tags = {"알림 API"})
public class NotificationController {

    private final NotificationService notificationService;
    private static final String SUCCESS = "Success";
    private static final String FAIL = "Fail";

    private final JwtUtil jwtUtil;

    //알림 목록
    @ApiOperation(value = "알림 목록 조회", notes = "현재 로그인한 사용자의 알림을 30개 가져옴(최근 알림->오래된 알림 순서)\n"+
    "follow: 알림 보낸 사람\n"+
    "notiType: FOLLOW: 팔로우 수락, WAIT: 팔로우 신청, REVIEW: 댓글")
    @GetMapping("/notification")
    public ResponseEntity<List<NotificationReponseDto>> selectAllNotification(HttpServletRequest request){
        String token = request.getHeader(TOKEN_HEADER);
        Long userId = jwtUtil.getUserId(token);

        List<NotificationReponseDto> notificationList = notificationService.selectAllNotification(userId);
        return new ResponseEntity<>(notificationList, HttpStatus.OK);
    }




}
