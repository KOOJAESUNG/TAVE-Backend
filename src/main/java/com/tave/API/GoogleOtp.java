package com.tave.api;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base32;

public class GoogleOtp {

    public static void main(String[] args) { //OTP 작동여부 확인 메소드, 나중에 삭제 예정
        GoogleOtp otp = new GoogleOtp();
        HashMap<String, String> map = otp.generate("name", "host");
        String otpkey = map.get("encodedKey");
        String url = map.get("url");
        System.out.println(otpkey); // otp key 출력

        Scanner sc = new Scanner(System.in);
        String usercode = sc.nextLine();
        // 생성된 키/url을 otp 앱에 등록 후 표시되는 번호와 생성된 키를 넣어주면 true
        boolean check = otp.checkCode(usercode, otpkey);
        System.out.println(check); // 키 일치여부 출력
    }

    public HashMap<String, String> generate(String userName, String hostName) {
        HashMap<String, String> map = new HashMap<>();
        byte[] buffer = new byte[5 + 5 * 5];
        new Random().nextBytes(buffer);
        Base32 codec = new Base32();
        byte[] secretKey = Arrays.copyOf(buffer, 10);
        byte[] bEncodedKey = codec.encode(secretKey);

        String encodedKey = new String(bEncodedKey); // 생성된 키
        String url = getQRBarcodeURL(userName, hostName, encodedKey); // 생성된 QR코드
        // Google OTP 앱에 userName@hostName 으로 저장됨
        // key를 입력하거나 생성된 QR코드를 바코드 스캔하여 등록

        map.put("encodedKey", encodedKey);
        map.put("url", url);
        return map;
    }

    public boolean checkCode(String userCode, String otpkey) { // 키, 코드, 시간으로 일회용 비밀번호가 맞는지 확인
        long otpnum = Integer.parseInt(userCode); // Google OTP 앱에 표시되는 6자리 숫자
        long wave = new Date().getTime() / 30000; // Google OTP의 주기는 30초
        boolean result = false;
        try {
            Base32 codec = new Base32();
            byte[] decodedKey = codec.decode(otpkey);
            int window = 3;
            for (int i = -window; i <= window; ++i) {
                long hash = verify_code(decodedKey, wave + i);
                if (hash == otpnum) result = true;
            }
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result; // 일치하면 true 반환
    }

    private static int verify_code(byte[] key, long t) throws NoSuchAlgorithmException, InvalidKeyException { // 키 진위여부 확인
        byte[] data = new byte[8];
        long value = t;
        for (int i = 8; i-- > 0; value >>>= 8) {
            data[i] = (byte) value;
        }

        SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1"); //공유하는 secret key가 있을 때 정보의 유효성 검증 및 응답
        mac.init(signKey);
        byte[] hash = mac.doFinal(data);

        int offset = hash[20 - 1] & 0xF;

        long truncatedHash = 0;
        for (int i = 0; i < 4; ++i) { //양수의 byte가 나오기 위한 처리과정, 8번씩 4번 -->총 32번 밀어버리므로 다시 원점
            truncatedHash <<= 8;
            truncatedHash |= (hash[offset + i] & 0xFF);
        }

        truncatedHash &= 0x7FFFFFFF;
        truncatedHash %= 1000000;

        return (int) truncatedHash;
    }

    public static String getQRBarcodeURL(String user, String host, String secret) {
        // QR코드 주소 생성
        String format2 = "http://chart.apis.google.com/chart?cht=qr&chs=200x200&chl=otpauth://totp/%s@%s%%3Fsecret%%3D%s&chld=H|0";
        return String.format(format2, user, host, secret);
    }
}