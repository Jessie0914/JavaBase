package p4_5;

import java.io.*;

/**
 * @program: Test
 * @description: 字符操作
 * @author: shishi
 * @create: 2019-10-17 16:52
 **/

public class CharacterOperation {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\shijiaxin\\Desktop\\淘宝买的各种账号.txt";
        readFileContent(path);
    }

    private static void readFileContent(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter("C:\\Users\\shijiaxin\\Desktop\\淘宝买的各种账号_copy.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = "";
        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
            bufferedWriter.write(line);
            // 没有成功，明天再看
            bufferedWriter.write("\n");
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
