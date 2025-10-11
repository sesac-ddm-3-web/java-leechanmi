package org.example.cp.cp07;

import org.example.common.BaseClass;

public class P01_ShippingMain extends BaseClass {

    abstract class Item {
        protected final int baseDeliveryFee = 3000;

        protected String name;
        protected int price;
        protected int deliveryFee;
        protected int finalPrice;

        protected Item(String name, int price) {
            this.name = name;
            this.price = price;
        }

        protected abstract int calculateDeliveryFee();
        protected abstract int calculateFinalPrice();

        public void displayInfo() {
            System.out.printf("상품명: %s, 가격: %,d원%n", this.name, this.price);
        }

        public int getFinalPrice() {
            return finalPrice;
        }
    }

    class NormalItem extends Item {
        public NormalItem(String name, int price) {
            super(name, price);
            this.deliveryFee = calculateDeliveryFee();
            this.finalPrice = calculateFinalPrice();
        }

        @Override
        protected int calculateDeliveryFee() {
            return baseDeliveryFee;
        }

        @Override
        protected int calculateFinalPrice() {
            return this.price + this.deliveryFee;
        }
    }

    class Furniture extends Item {
        public Furniture(String name, int price) {
            super(name, price);
            this.deliveryFee = calculateDeliveryFee();
            this.finalPrice = calculateFinalPrice();
        }

        @Override
        protected int calculateDeliveryFee() {
            return baseDeliveryFee + (int)(price * 0.05);
        }

        @Override
        protected int calculateFinalPrice() {
            return this.price + this.deliveryFee;
        }
    }

    class Grocery extends Item {
        protected int groceryDeliveryFee = 5000;

        public Grocery(String name, int price) {
            super(name, price);
            this.deliveryFee = calculateDeliveryFee();
            this.finalPrice = calculateFinalPrice();
        }

        @Override
        protected int calculateDeliveryFee() {
            return groceryDeliveryFee;
        }

        @Override
        protected int calculateFinalPrice() {
            return this.price + this.deliveryFee;
        }
    }

    @Override
    public void main() {
        // 다양한 종류의 상품 객체 생성
        Item book = new NormalItem("자바의 정석", 30000);
        Furniture chair = new Furniture("편한 의자", 100000);
        Grocery apple = new Grocery("유기농 사과", 15000);

        // Item 타입 배열에 모든 상품을 담아 다형성 활용
        Item[] cart = {book, chair, apple};

        int totalPayment = 0;

        System.out.println("## 장바구니 ##");
        // 반복문을 돌면서 각 상품의 정보를 출력하고 최종 결제 금액을 계산
        for (Item item : cart) {
            item.displayInfo();
            int finalPrice = item.getFinalPrice();
            System.out.printf("최종 결제 금액: %,d원%n", finalPrice);
            totalPayment += finalPrice;
            System.out.println("--------------------");
        }

        System.out.printf(">> 총 결제 예정 금액: %,d원%n", totalPayment);
    }
}
