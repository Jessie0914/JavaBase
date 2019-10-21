import java.net.StandardSocketOptions;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Test
 * @description:
 * @author: shishi
 * @create: 2019-10-11 16:20
 **/

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // 添加元素
        list.add(1);
        list.add(2);
        list.add(3);

        // 遍历访问
        for (int i=0;i<list.size();i++){
            int curNum = list.get(i);
            System.out.println(curNum);
        }
    }
}

