package test.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by ZhangPei on 2018/9/19.
 */
@WebServlet(name = "FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行文件上传servlet开始");
        ServletInputStream inputStream = request.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("测试.txt"));
        while (true) {
            int read = inputStream.read();
            if (read > -1) {
                fileOutputStream.write(read);
            }else {
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
