package p4_5.seven;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NIO
 * @Description Java I/O —— NIO实例
 * @Author shishi
 * @Date 2019/10/18 15:05
 **/

// 实现利用NIO快速复制文件
public class NIO {
    public static void main(String[] args) throws IOException {
        String src = "C:\\Users\\89467\\Desktop\\测试文件\\url.txt";
        String dist = "C:\\Users\\89467\\Desktop\\测试文件\\url_copy.txt";
        fastCopy(src,dist);
    }

    private static void fastCopy(String src, String dist) throws IOException {
        // 获取源文件的输入字节流
        FileInputStream fileInputStream = new FileInputStream(src);

        // 获取输入字节流的文件通道
        FileChannel fcin_channel = fileInputStream.getChannel();

        // 获取目标文件的输出字节流
        FileOutputStream fileOutputStream = new FileOutputStream(dist);

        // 获取输出字节流的文件通道
        FileChannel fout_channel = fileOutputStream.getChannel();

        // 为缓冲区分配1024个字节
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true){
            // 从输入通道中读取数据到缓冲区中
            // 不能对通道进行直接的输入输出操作，都是通过缓冲区的
            int r = fcin_channel.read(buffer);

            // EOF
            if (r==-1)
                break;

            // 在写入到缓冲区之前，要先调用flip()函数
            // 为了切换读写
            buffer.flip();

            // 把缓冲区的内容写入到目标文件中
            fout_channel.write(buffer);

            // 最后要清空缓存区
            buffer.clear();
        }

        fcin_channel.close();
        fout_channel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
