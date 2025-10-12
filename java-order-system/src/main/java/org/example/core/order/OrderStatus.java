package org.example.core.order;

public enum OrderStatus {
    PENDING("주문 대기"),
    CONFIRMED("주문 확정"),
    PREPARING("조리 중"),
    READY("준비 완료"),
    DELIVERED("배달 완료"),
    CANCELLED("주문 취소")
    ;

    private String kr;

    OrderStatus(String kr) {
        this.kr = kr;
    }
}
