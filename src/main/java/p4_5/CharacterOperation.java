package p4_5;

import java.io.*;

/**
 * @program: Test
 * @description: Java I/O部分——字符操作
 * @author: shishi
 * @create: 2019-10-17 16:52
 **/

public class CharacterOperation {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\89467\\Desktop\\1.txt";
        readFileContent(path);
    }

    // 实现复制文件到一个新的文件的功能
    private static void readFileContent(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        // 装饰功能，为FileReader对象添加一个缓存功能
        // BufferedReader对象可以直接用readLine()方法
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // 添加一个输出字符流FileWriter，并且在外面装饰好缓存功能
        FileWriter fileWriter = new FileWriter("C:\\Users\\89467\\Desktop\\1_copy.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // 读取内容
        String line = "";
        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
            bufferedWriter.write(line);
            // 要多输出一行换行符，否则文件中的内容都在一行之内
            bufferedWriter.write("\n");
        }

        // 关闭流
        bufferedReader.close();
        bufferedWriter.close();
    }
}
