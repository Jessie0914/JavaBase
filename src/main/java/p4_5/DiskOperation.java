package p4_5;

import java.io.File;

/**
 * @program: Test
 * @description: 磁盘操作
 * @author: shishi
 * @create: 2019-10-17 16:19
 **/

// Java IO——磁盘操作
public class DiskOperation {
    public static void main(String[] args) {
        // 这里用的是File类，也可以替换成Files和Path类
        // Files和Path类好像没有构造方法
        String path = "C:\\Users\\shijiaxin\\Desktop\\签证";
        File file = new File(path);
        copyFile(file);
    }

    // 列出所有的文件夹名字
    private static void copyFile(File file) {
        if (file==null)
            return;

        if (file.isFile()){
            System.out.println(file.getName());
        }else {
            File[] files = file.listFiles();
            for (File f : files)
                copyFile(f);
        }

    }
}
