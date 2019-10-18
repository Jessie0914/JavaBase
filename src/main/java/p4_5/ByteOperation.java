package p4_5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: Test
 * @description: 文件复制
 * @author: shishi
 * @create: 2019-10-16 20:02
 **/

public class ByteOperation {
    public static void main(String[] args) throws IOException {
        String src = "C:\\Users\\shijiaxin\\Pictures\\1.png";
        String dist = "C:\\Users\\shijiaxin\\Pictures\\1_copy.png";
        // 有中文字符，也没有报错
        // 字节流，一般用来传输更原始的数据“图片”“视频”等等
        copyFiles(src,dist);
    }

    private static void copyFiles(String src, String dist) throws IOException {
        // 创建一个输入输出流
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        // 创建一个缓存数组
        byte[] buffer = new byte[20*1024];
        int cnt;

        while ((cnt = in.read(buffer,0,buffer.length))!=-1){
            out.write(buffer,0,cnt);
        }
        in.close();
        out.close();
    }
}
