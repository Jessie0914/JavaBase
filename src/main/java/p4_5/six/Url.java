package p4_5.six;

import java.io.*;
import java.net.URL;

/**
 * @program: Test
 * @description: 网络编程-利用URL统一资源定位符
 * @author: shishi
 * @create: 2019-10-17 13:33
 **/

public class Url {
    // 利用URL读取字节流数据
    public static void main(String[] args) throws IOException {
        // 建立一个URL对象，
        URL url = new URL("http://www.baidu.com");
        // 然后获取字节流
        InputStream is = url.openStream();
        // 转换成字符流，并制定编码方式
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        // 为字符流添加缓存功能
        BufferedReader br = new BufferedReader(isr);

        FileWriter fileWriter = new FileWriter("C:\\Users\\89467\\Desktop\\测试文件\\url.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // 读取并输出
        String line = "";
        while ((line = br.readLine())!=null){
            System.out.println(line);
            bufferedWriter.write(line);
            bufferedWriter.write("\n");
        }
        br.close();
        bufferedWriter.close();
    }
}
