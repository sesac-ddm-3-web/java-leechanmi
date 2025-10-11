package org.example.ch.ch11;

import org.example.ch.ch11.exception.InsufficientBalanceException;
import org.example.ch.ch11.exception.OrderException;
import org.example.ch.ch11.exception.OutOfStockException;
import org.example.common.BaseClass;

// 상품 정보를 저장하는 클래스
class Product {
    String id;
    String name;
    int price;
    int stock;

    public Product(String id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

// 사용자 정보를 저장하는 클래스
class User {
    String id;
    String name;
    int balance;

    public User(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
}

// 핵심 로직을 처리하는 서비스 클래스
class OrderService {
    // 인메모리 데이터베이스 (파일 대신 사용)
    private String[] productDb = {"P101:MacBook:2500000:10", "P102:iPhone:1500000:0", "P103:iPad:1000a00:20"};
    private String[] userDb = {"U001:김자바:5000000", "U002:박씨샵:1000000"};

    // 주문 처리 로직
    public void processOrder(String userId, String productId, int quantity) throws OrderException {
        // 1. 상품 찾기 및 파싱
        Product product = null;
        for (String data : productDb) {
            if (data.startsWith(productId + ":")) {
                try {
                    String[] parts = data.split(":");
                    product = new Product(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    // 가격/재고 파싱 오류
                    throw new IllegalArgumentException("오류: 상품 데이터에 문제가 있어 처리할 수 없습니다.", e);
                }
                break;
            }
        }
        if (product == null)
            throw new IllegalArgumentException("오류: 해당하는 상품을 찾을 수 없습니다."); // 상품 없음

        // 2. 사용자 찾기
        User user = null;
        for (String data : userDb) {
            if (data.startsWith(userId + ":")) {
                String[] parts = data.split(":");
                user = new User(parts[0], parts[1], Integer.parseInt(parts[2]));
                break;
            }
        }
        if (user == null) {
            // 사용자 없음
            throw new IllegalArgumentException("오류: 해당하는 사용자를 찾을 수 없습니다.");
        }

        // 3. 비즈니스 규칙 검사
        if (product.stock < quantity) throw new OutOfStockException(); // 재고 부족
        if (user.balance < product.price * quantity) throw new InsufficientBalanceException(); // 잔고 부족

        // 4. 주문 성공
        product.stock -= quantity;
        user.balance -= product.price * quantity;

        System.out.printf("주문 성공! [%s]님이 [%s] %d개를 구매했습니다. 남은 잔고: %d\n", user.name, product.name, quantity, user.balance);
    }
}

public class P01_ShoppingMallV1 extends BaseClass {
    @Override
    public void main() {
        OrderService service = new OrderService();

        // 시나리오: 김자바(U001)가 MacBook(P101) 1개를 주문한다.

        try {
            System.out.println("---[ CASE 1: 정상 주문 ]---");
            service.processOrder("U001", "P101", 1);
        } catch (OrderException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());

            if (e.getCause() != null) {
                System.out.println("detail: " + e.getCause().getMessage());
            }
        }
        finally {
            System.out.println("주문 시도를 종료합니다.");
        }

        try {
            System.out.println("\n---[ CASE 2: 재고 부족 ]---");
            service.processOrder("U001", "P102", 1);
        } catch (OrderException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());

            if (e.getCause() != null) {
                System.out.println("detail: " + e.getCause().getMessage());
            }
        } finally {
            System.out.println("주문 시도를 종료합니다.");
        }

        try {
            System.out.println("\n---[ CASE 3: 데이터 형식 오류 ]---");
            service.processOrder("U001", "P103", 1);
        } catch (OrderException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());

            if (e.getCause() != null) {
                System.out.println("detail: " + e.getCause().getMessage());
            }
        } finally {
            System.out.println("주문 시도를 종료합니다.");
        }

        try {
            System.out.println("\n---[ CASE 4: 잔고 부족 ]---");
            service.processOrder("U002", "P101", 1);
        } catch (OrderException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());

            if (e.getCause() != null) {
                System.out.println("detail: " + e.getCause().getMessage());
            }
        } finally {
            System.out.println("주문 시도를 종료합니다.");
        }
    }
}
