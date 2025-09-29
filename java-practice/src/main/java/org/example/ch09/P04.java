package org.example.ch09;

import org.example.common.BaseClass;

public class P04 extends BaseClass {
    interface EventListener {
        void onClick();
    }

    class Button {
        private EventListener eventListener;
        private String func;

        public Button(String func) {
            this.func = func;
        }

        public void setListener(EventListener eventListener) {
            this.eventListener = eventListener;
        }

        public void click() {
            System.out.printf("%s 버튼이 클릭되었습니다.%n", this.func);
            eventListener.onClick();
        }
    }

    @Override
    public void main() {
        // 로그인 버튼 생성 및 이벤트 리스너 설정
        Button loginButton = new Button("로그인");
        loginButton.setListener(new EventListener() {
            @Override
            public void onClick() {
                System.out.println("사용자 인증을 시작합니다...");
            }
        });

        // 저장 버튼 생성 및 이벤트 리스너 설정
        Button saveButton = new Button("저장");
        saveButton.setListener(new EventListener() {
            @Override
            public void onClick() {
                System.out.println("데이터를 저장합니다...");
            }
        });

        // 취소 버튼 생성 및 이벤트 리스너 설정
        Button cancelButton = new Button("취소");
        cancelButton.setListener(new EventListener() {
            @Override
            public void onClick() {
                System.out.println("작업을 취소합니다...");
            }
        });

        // 각 버튼 클릭 시뮬레이션
        loginButton.click();
        System.out.println();
        saveButton.click();
        System.out.println();
        cancelButton.click();
    }
}
