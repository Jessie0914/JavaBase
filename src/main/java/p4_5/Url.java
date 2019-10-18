package p4_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @program: Test
 * @description: 网络编程-统一资源定位符
 * @author: shishi
 * @create: 2019-10-17 13:33
 **/

public class Url {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader br = new BufferedReader(isr);

        String line = "";
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }
}
