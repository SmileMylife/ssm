package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by ZhangPei on 2018/3/31.
 */
public class IOtest {
    //文件复制
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/smile_mylife/IdeaProjects/ssm/src/main/resources/测试账号.rtf");
        String oldName = file.getName();
        String fileExd = oldName.substring(oldName.lastIndexOf("."));
        String newName = UUID.randomUUID().toString() + fileExd;
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(new File(newName));
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
