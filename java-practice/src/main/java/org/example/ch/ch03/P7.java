package org.example.ch.ch03;

import org.example.common.BaseClass;

public class P7 extends BaseClass {
    @Override
    public void main() {
        System.out.print("첫 번째 수: ");
        int num1 = in.nextInt();

        System.out.print("두 번째 수: ");
        int num2 = in.nextInt();

        String bin1 = Integer.toBinaryString(num1);
        String bin2 = Integer.toBinaryString(num2);

        int andResult = num1 & num2;
        System.out.println(num1 + " (" + bin1 + ") & " + num2 + " (" + bin2 + ") = " + andResult + " (" + Integer.toBinaryString(andResult) + ")");

        int orResult = num1 | num2;
        System.out.println(num1 + " (" + bin1 + ") | " + num2 + " (" + bin2 + ") = " + orResult + " (" + Integer.toBinaryString(orResult) + ")");

        int xorResult = num1 ^ num2;
        System.out.println(num1 + " (" + bin1 + ") ^ " + num2 + " (" + bin2 + ") = " + xorResult + " (" + Integer.toBinaryString(xorResult) + ")");

        int notResult = ~num1;
        System.out.println("~" + num1 + " = " + notResult);

        int leftShift = num1 << 1;
        System.out.println(num1 + " << 1 = " + leftShift + " (" + Integer.toBinaryString(leftShift) + ")");

        int rightShift = num1 >> 1;
        System.out.println(num1 + " >> 1 = " + rightShift + " (" + Integer.toBinaryString(rightShift) + ")");
    }
}
