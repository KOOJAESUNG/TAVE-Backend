package com.tave.api;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class CoolSms {

    public static void main(String[] args){ // 작동여부 판단 메소드, 추후 삭제 예정
        Scanner sc = new Scanner(System.in);

        boolean authentication = false;

        HashMap<String, String> verfication= new HashMap<>();

        System.out.println("전화번호를 입력해주세요.");
        String phoneNumber = sc.nextLine();
        String numStr = sendSMS(phoneNumber);
        sendOne(phoneNumber, numStr);

        if(!verfication.containsKey(phoneNumber)) //같은 번호의 인증번호 중복 방지
            verfication.put(phoneNumber, numStr);
        else
            verfication.replace(phoneNumber,numStr);

        String pass = sc.nextLine();

        if(Objects.equals(verfication.get(phoneNumber), pass)) // 번호, numstr과 일치하면 true 반환
            authentication = true;

        System.out.println(authentication);

    }

    public static String sendSMS(String phoneNumber) {
        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10)); //네자리 숫자 생성, 0으로 시작하여 인증번호가 세자리가 되는 것 방지
            numStr+=ran;
        }

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        return numStr;
    }

    public static SingleMessageSentResponse sendOne(String phoneNumber, String numStr) {
        Message message = new Message();
        // 발신번호 및 수신번호는 01012345678 형태로 입력되어야 합니다.
        message.setFrom(phoneNumber); // 발신번호
        message.setTo(phoneNumber); //수신번호
        message.setText("[TAVE] 인증번호는 ["+numStr+"]입니다."); //메세지 양식

        DefaultMessageService messageService = NurigoApp.INSTANCE.initialize("apiKey", "apiSecretKey", "https://api.coolsms.co.kr");
        SingleMessageSentResponse response = messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);
        return response;
    }
}
