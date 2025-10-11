package org.example.cp.cp08;

import org.example.common.BaseClass;

interface Callable {
    void call(String number);

    void endCall();
}

interface Messageable {
    void sendMessage(String message, String recipient);
}

interface Connectable {
    void connectWiFi(String network);

    void disconnectWiFi();
}

class SmartPhone implements Callable, Messageable, Connectable {

    @Override
    public void call(String number) {
        System.out.printf("%s로 전화를 겁니다.%n", number);
    }

    @Override
    public void endCall() {
        System.out.println("통화를 종료합니다.");
    }

    @Override
    public void connectWiFi(String network) {
        System.out.printf("%s 네트워크에 연결되었습니다.%n", network);
    }

    @Override
    public void disconnectWiFi() {
        System.out.println("WiFi 연결을 해제했습니다.");
    }

    @Override
    public void sendMessage(String message, String recipient) {
        System.out.printf("%s 메시지를 %s에게 전송했습니다.%n", message, recipient);
    }
}

public class P02 extends BaseClass {
    @Override
    public void main() {
        SmartPhone myPhone = new SmartPhone();

        myPhone.call("010-1234-5678");
        myPhone.sendMessage("안녕하세요", "홍길동");
        myPhone.connectWiFi("HomeWiFi");

        myPhone.endCall();
        myPhone.disconnectWiFi();
    }
}
