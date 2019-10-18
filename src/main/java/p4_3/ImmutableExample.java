package p4_3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Test
 * @description: 不可变集合
 * @author: shishi
 * @create: 2019-10-08 21:42
 **/

public class ImmutableExample {
    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> unmodifiableMap = Collections.unmodifiableMap(hashMap);

        // 会对所有对map修改的操作抛出异常，下面这条语句就会抛异常
        unmodifiableMap.put(1,1);
    }
}
