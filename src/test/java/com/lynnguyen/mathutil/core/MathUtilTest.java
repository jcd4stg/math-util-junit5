package com.lynnguyen.mathutil.core;

import static com.lynnguyen.mathutil.core.MathUtil.*;
//import static là dành riêng cho những hàm static
//gọi hàm mà bỏ qa tên class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MathUtilTest {

    //chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hoá data này
    //vào trong câu lệnh kiểm thử
    
    //chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][] {
                                    {1, 1},
                                    {2, 2},
                                    {5, 120},
                                    {6, 220}     
                                };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") //tên hàm cung cấp data, ngầm định thứ tự 
            //của các phần tử của mảng, map vào tham số hàm
    public void testGetFactorialGivenRightArgumentReturnWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
    
//    @Test
//    public void testGetFactorialGivenRightArgumentReturnWell() {
//        assertEquals(120, getFactorial(5));
//    }
    //bắt ngoại lệ khi đưa data cà chớn

    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        //xài biểu thức lambda
        //hàm nhận tham số thứ 2 là 1 cái object có code implement cái 
        //functional interface tên là Excecutable - có 1 hàm duy nhất ko code

//       Executable excObject = new Executable() {
//           @Override
//           public void execute() throws Throwable {
//               getFactorial(-5);
//           }
//       };
        //Executable exObject = () -> getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }
}
