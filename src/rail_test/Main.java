package rail_test;

import org.junit.Test;

import java.util.Arrays;

public class Main {
    @Test
    public void testBytes2Str(){
        String msg = "我爱中国共产党";
        System.out.println("转换前 ： " +msg);
        byte[] bytes = msg.getBytes();
        System.out.println("Str2Bytes" + Arrays.toString(bytes));

        String res = new String(bytes);
        System.out.println("转换后 ： " + res);

        System.out.println("Str2Bytes" + Arrays.toString(res.getBytes()));
    }

    @Test
    public void test2(){
        String structStr = new String(new Struct(16, 0).getBuf());
        System.out.println("前 structStr = " +structStr);
        System.out.println("原数组：" + Arrays.toString(new Struct(16, 0).getBuf()));

        System.out.println("后数组："+Arrays.toString(structStr.getBytes()));
        System.out.println("后 structStr = " + new String(structStr.getBytes()));

        System.out.println("前Str == 后Str  " + (structStr.equals(new String(structStr.getBytes()))));
    }
}
