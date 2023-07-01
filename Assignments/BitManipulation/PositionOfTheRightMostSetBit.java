package com.ak.BitManipulation;

public class PositionOfTheRightMostSetBit {
//    The approach of using N & (-N) to find the position of the rightmost set bit in an integer is based on the properties of two's complement representation.
//    When we perform the bitwise AND operation between the input number N and its two's complement -N, the result is a number that has only the rightmost set bit of N set to 1, and all other bits set to 0.
//    This works because the rightmost set bit in binary representation represents the lowest significant bit that is 1. By performing N & (-N), all bits except the rightmost set bit are zeroed out, effectively isolating the rightmost set bit.
//    The position of the rightmost set bit can then be determined using the Integer.numberOfTrailingZeros() method, which counts the number of trailing zeros in the binary representation of the result. This approach provides an efficient way to find the position of the rightmost set bit without the need for loops or additional bitwise operations."

    int number = 25;

    int rightmostSetBit = number & (-number);
    int position = Integer.numberOfTrailingZeros(rightmostSetBit);

    public static void main(String[] args) {
        int number = 7;

        System.out.println(Integer.toBinaryString(number));
        int rightmostSetBit = number & (-number);
        int position = Integer.numberOfTrailingZeros(rightmostSetBit);

        System.out.println(position);
    }
}
