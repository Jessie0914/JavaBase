package p4_5.seven;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName NIOServer
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/18 15:44
 **/

// 好难。。
public class NIOServer {
    public static void main(String[] args) throws IOException {
        // 创建选择器
        Selector selector = Selector.open();

        // 将通道注册到选择器中
        // 只有配置套接字Channel为非阻塞，并注册到选择器上，才有意义，所以建立一个套接字通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 配置套接字通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 注册
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
        serverSocket.bind(address);

        // 循环获取到达的事件
        while (true){
            // 使用select()监听到达的事件，它会一直阻塞，直到有一个事件到达
            selector.select();

            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();

            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()){
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();

                    // 服务器会为每个新连接创建一个socketChannel
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    socketChannel.configureBlocking(false);

                    //
                }
            }

        }
    }
}
