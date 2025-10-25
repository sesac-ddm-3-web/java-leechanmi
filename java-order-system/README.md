# 음식 주문 관리 시스템 (Food Order Management System)

## 📋 프로젝트 개요

레스토랑의 음식 주문을 관리하는 콘솔 기반 프로그램을 구현합니다.
이 프로젝트를 통해 객체지향 프로그래밍의 핵심 개념(상속, 다형성, 추상화, 캡슐화)을 학습하고,
향후 웹 애플리케이션으로 확장 가능한 구조를 설계합니다.

---

## 🎯 학습 목표

- **Enum 활용**: 메뉴 카테고리, 주문 상태, 결제 방식 등을 열거형으로 관리
- **상속과 다형성**: 추상 클래스를 상속받아 다양한 메뉴 아이템 구현
- **추상 메서드**: 각 메뉴 타입별로 다른 동작 정의
- **인터페이스**: 결제 처리 로직의 다형성 구현
- **컬렉션 활용**: List, Map을 사용한 데이터 관리
- **예외 처리**: 잘못된 입력, 재고 부족 등 예외 상황 처리

---

## 📌 필수 구현 기능 (Core Features)

> **목표**: 기본적인 주문 시스템의 핵심 기능을 구현하며 **상속, 다형성, 추상 클래스, 인터페이스**의 개념을 학습합니다.

### 1. 메뉴 관리 (MenuItem 다형성)
- [ ] MenuItem 추상 클래스 작성
- [ ] 4가지 메뉴 타입 클래스 구현 (MainDish, SideDish, Beverage, Dessert)
- [ ] 메뉴 전체 조회 (카테고리별)
- [ ] 메뉴 상세 정보 확인
    - [ ] 각 메뉴 타입별로 다른 설명 표시 (getDescription() 활용)
    - [ ] 메인 요리: 조리 난이도, 칼로리
    - [ ] 사이드: 크기 옵션
    - [ ] 음료: 용량, 온도
    - [ ] 디저트: 당도, 알레르기 정보
- [ ] 메뉴별 조리 시간 표시 (getPreparationTime() 활용)
- [ ] 재고 기반 주문 가능 여부 확인 (isAvailable() 활용)

### 2. 주문 관리
- [ ] 장바구니에 메뉴 추가/삭제
- [ ] 주문 총액 계산
- [ ] 주문 내역 조회

### 3. 결제 처리 (PaymentMethod 다형성)
- [ ] PaymentMethod 인터페이스 작성
- [ ] 3가지 결제 수단 구현 (CardPayment, CashPayment, PointPayment)
- [ ] 결제 수단별 정보 표시 (getPaymentInfo() 활용)
- [ ] 결제 처리 (processPayment() 활용)
    - [ ] 카드 결제: 카드 번호 유효성 검증 (16자리)
    - [ ] 현금 결제: 거스름돈 계산
    - [ ] 포인트 결제: 잔여 포인트 확인
- [ ] 간단한 영수증 출력

---

## 🏗️ 클래스 설계 가이드

### 1. Enum 클래스

#### MenuCategory (메뉴 카테고리)
```java
public enum MenuCategory {
    MAIN_DISH("메인 요리"),
    SIDE_DISH("사이드 메뉴"),
    BEVERAGE("음료"),
    DESSERT("디저트");

    private String displayName;

    MenuCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
```

#### OrderStatus (주문 상태)
- PENDING: 주문 대기
- CONFIRMED: 주문 확정
- PREPARING: 조리 중
- READY: 준비 완료
- DELIVERED: 배달 완료
- CANCELLED: 주문 취소

#### PaymentType (결제 방식)
- CARD: 카드 결제
- CASH: 현금 결제
- POINT: 포인트 결제

---

### 2. 추상 클래스

#### MenuItem (메뉴 아이템 - 추상 클래스)
```java
public abstract class MenuItem {
    protected String id;
    protected String name;
    protected int price;
    protected MenuCategory category;
    protected int stock;

    // 추상 메서드: 각 메뉴 타입별로 다르게 구현
    public abstract String getDescription();
    public abstract int getPreparationTime(); // 조리 시간(분)
    public abstract boolean isAvailable(); // 주문 가능 여부

    // 공통 메서드
    public void reduceStock(int quantity) {
        // 재고 감소 로직
    }
}
```

#### 구현 클래스
- **MainDish**: 메인 요리 (예: 스테이크, 파스타)
    - 추가 속성: 조리 난이도, 칼로리
- **SideDish**: 사이드 메뉴 (예: 샐러드, 감자튀김)
    - 추가 속성: 크기 옵션(Small, Medium, Large)
- **Beverage**: 음료 (예: 콜라, 주스)
    - 추가 속성: 용량(ml), 온도 옵션(HOT/COLD)
- **Dessert**: 디저트 (예: 케이크, 아이스크림)
    - 추가 속성: 당도, 알레르기 정보

---

### 3. 인터페이스

#### PaymentMethod (결제 수단 인터페이스)
```java
public interface PaymentMethod {
    boolean processPayment(int amount);
    String getPaymentInfo();
}
```

#### 구현 클래스
- **CardPayment**: 카드 결제
    - 카드 번호, 유효기간 검증
- **CashPayment**: 현금 결제
    - 거스름돈 계산
- **PointPayment**: 포인트 결제
    - 잔여 포인트 확인 및 차감

---

### 4. 주요 클래스

#### Order (주문)
```java
public class Order {
    private String orderId;
    private List<OrderItem> items;
    private OrderStatus status;
    private LocalDateTime orderTime;
    private int totalAmount;

    public void addItem(MenuItem menuItem, int quantity) { }
    public void removeItem(String menuItemId) { }
    public int calculateTotal() { }
    public void updateStatus(OrderStatus status) { }
}
```

#### OrderItem (주문 항목)
```java
public class OrderItem {
    private MenuItem menuItem;
    private int quantity;
    private int subtotal;
}
```

#### Restaurant (레스토랑 - 메인 관리 클래스)
```java
public class Restaurant {
    private String name;
    private List<MenuItem> menu;
    private List<Order> orders;

    public void displayMenu(MenuCategory category) { }
    public Order createOrder() { }
    public void processOrder(Order order, PaymentMethod payment) { }
}
```

---

## 💻 구현 단계

### 🎯 Phase 1: 필수 구현 (Core Implementation)

#### Step 1: 기본 구조 설계
1. 기본 Enum 클래스 작성
    - MenuCategory (displayName만)
    - OrderStatus (displayName만)
    - PaymentType (displayName만)
2. MenuItem 추상 클래스 작성
    - 추상 메서드: getDescription(), getPreparationTime(), isAvailable()
3. PaymentMethod 인터페이스 작성
    - 추상 메서드: processPayment(), getPaymentInfo()

#### Step 2: MenuItem 상속 구현
1. MenuItem을 상속받는 4개 클래스 구현
    - MainDish (난이도, 칼로리)
    - SideDish (크기 옵션)
    - Beverage (용량, 온도)
    - Dessert (당도, 알레르기 정보)
2. 각 클래스별 추상 메서드 구현
3. 재고 기반 isAvailable() 구현 (stock > 0)

#### Step 3: 결제 시스템 구현
1. PaymentMethod 인터페이스 구현
    - CardPayment: 카드 번호 16자리 검증
    - CashPayment: 거스름돈 계산
    - PointPayment: 포인트 잔액 확인
2. 각 결제 수단별 processPayment() 구현

#### Step 4: 주문 시스템 구현
1. Order, OrderItem 클래스 구현
2. 장바구니 추가/삭제 로직
3. 주문 총액 계산

#### Step 5: 메인 프로그램 작성
1. Restaurant 클래스 구현
2. 메뉴 데이터 초기화 (최소 5-6개)
3. 콘솔 UI 작성 (Scanner 활용)
    - 메뉴 조회
    - 주문하기
    - 결제하기

#### Step 6: 테스트
1. 메뉴 조회 기능 테스트
2. 주문 및 결제 플로우 테스트
3. 영수증 출력 확인

---

## 🖥️ 실행 예시

### 📌 필수 구현 실행 예시

#### 예시 1: 기본 메뉴 조회 (MenuItem 다형성)

```
===== 🍽️ 레스토랑 주문 시스템 =====

1. 메뉴 보기
2. 주문하기
3. 결제하기
4. 종료
선택: 1

===== 메뉴 상세 정보 =====
[메인 요리]
1. 스테이크 - 25,000원
   설명: 메인 요리 - 스테이크 (난이도: HIGH, 800kcal)
   조리시간: 30분
   재고: 5개
   주문가능: ⭕

2. 파스타 - 15,000원
   설명: 메인 요리 - 파스타 (난이도: MEDIUM, 600kcal)
   조리시간: 20분
   재고: 8개
   주문가능: ⭕

[사이드 메뉴]
3. 감자튀김 - 5,000원
   설명: 사이드 메뉴 - 감자튀김 (사이즈: MEDIUM)
   조리시간: 10분
   재고: 15개
   주문가능: ⭕

4. 샐러드 - 7,000원
   설명: 사이드 메뉴 - 샐러드 (사이즈: LARGE)
   조리시간: 5분
   재고: 10개
   주문가능: ⭕

[음료]
5. 콜라 - 3,000원
   설명: 음료 - 콜라 (500ml, COLD)
   조리시간: 2분
   재고: 25개
   주문가능: ⭕

[디저트]
6. 초코케이크 - 7,000원
   설명: 디저트 - 초코케이크 (당도: MEDIUM, 알레르기: 밀, 우유, 계란)
   조리시간: 3분
   재고: 8개
   주문가능: ⭕

7. 티라미수 - 8,000원
   설명: 디저트 - 티라미수 (당도: LOW, 알레르기: 밀, 우유, 계란)
   조리시간: 3분
   재고: 0개
   주문가능: ❌ (재고 부족)
```

---

#### 예시 2: 기본 주문 플로우

```
선택: 2

===== 주문하기 =====
메뉴 번호 입력: 1
수량 입력: 1

✅ '스테이크' 1개가 장바구니에 추가되었습니다.

계속 주문하시겠습니까? (y/n): y

메뉴 번호 입력: 5
수량 입력: 2

✅ '콜라' 2개가 장바구니에 추가되었습니다.

계속 주문하시겠습니까? (y/n): y

메뉴 번호 입력: 6
수량 입력: 1

✅ '초코케이크' 1개가 장바구니에 추가되었습니다.

계속 주문하시겠습니까? (y/n): n

===== 장바구니 =====
1. 스테이크 x1: 25,000원
2. 콜라 x2: 6,000원
3. 초코케이크 x1: 7,000원
─────────────────────────
총 금액: 38,000원
예상 조리 시간: 30분
```

---

#### 예시 3: 결제 처리 (PaymentMethod 다형성)

```
선택: 3

===== 결제 수단 선택 =====
1. 카드 결제
2. 현금 결제
3. 포인트 결제

선택: 2

===== 현금 결제 =====
결제 정보: 현금 결제
결제 금액: 38,000원

받으신 금액을 입력하세요: 50000

💰 받은 금액: 50,000원
💰 거스름돈: 12,000원

✅ 결제가 완료되었습니다!

===== 영수증 =====
주문번호: ORD-20250105-001
주문시간: 2025-01-05 14:30
─────────────────────────
스테이크 x1        25,000원
콜라 x2             6,000원
초코케이크 x1       7,000원
─────────────────────────
총 금액           38,000원
결제방법          현금
받은금액          50,000원
거스름돈          12,000원
─────────────────────────
```