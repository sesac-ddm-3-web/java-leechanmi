package org.example.ui.actions;

import java.util.Map;

import org.example.core.Restaurant;
import org.example.core.customer.Orderer;
import org.example.core.order.Order;
import org.example.core.order.exception.InvalidOrderException;
import org.example.core.payment.PaymentHistory;
import org.example.core.payment.PaymentMethod;
import org.example.core.payment.PaymentMethodImpl;
import org.example.ui.MenuAction;
import org.example.ui.MenuContext;

public class PaymentMenuAction implements MenuAction {
    Map<Integer, PaymentMethod> menuMap = Map.of(
        1, PaymentMethodImpl.CARD,
        2, PaymentMethodImpl.CASH,
        3, PaymentMethodImpl.POINT
    );

    @Override
    public boolean execute(MenuContext context) {
        System.out.println();
        System.out.println("""
            ===== 결제 수단 선택 =====
            1. 카드 결제
            2. 현금 결제
            3. 포인트 결제
            """
        );

        System.out.print("선택: ");
        int menuNumber = context.in.nextInt();

        Restaurant restaurant = context.restaurant;
        Orderer orderer = context.orderer;

        Order order;
        try {
            order = restaurant.createOrder(orderer);
        } catch (InvalidOrderException e) {
            System.out.println(e.getMessage());
            return true;
        }

        PaymentMethod payment = menuMap.get(menuNumber);
        System.out.println(payment.getPaymentInfo(orderer.getWallet(), order.getTotalAmount()));

        int receivedAmount = order.getTotalAmount();
        if (PaymentMethodImpl.CASH.equals(payment)) {
            System.out.print("받으신 금액을 입력하세요: ");
            receivedAmount = context.in.nextInt();
        }
        PaymentHistory history = restaurant.processOrder(order, payment, receivedAmount);

        System.out.printf("""
            💰 받은 금액: %,d원
            💰 거스름돈: %,d원%n
            """
            , history.getReceivedAmount(), history.getChangeAmount()
        );
        System.out.println("✅ 결제가 완료되었습니다!");
        System.out.println();

        System.out.println(history);
        System.out.println();
        return true;
    }
}
