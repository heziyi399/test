package ch1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
//socket类提供了两个方法用于得到输入流和输出流，分别是getInputStream()和getOutputStream() 可以对其进行包装
//例如：Socket socket = new Socket("localhost",8189);
//        PrintStream oStream = new PrintStream( new BufferedOutputStream(socket.getOutputStream()));
//DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

public class NewSocket {
    private BufferedReader mReader = null;
    private OutputStream mWriter = null;
    public static void main(String[] args) throws IOException {

//        ServerSocket ser  =  new ServerSocket(8189);//用于建立一个负责监控端口8189的服务器
//        Socket incoming = ser.accept();//用于告诉服务器不停地等待直到有客户端连接到这个端口
//        InputStream inStream = incoming.getInputStream();
//        Scanner in = new Scanner(inStream);
//        while(in.hasNext()){
//            String line = in.nextLine();
//            System.out.println(line);
//        }
        System.out.println("client连接准备"+System.currentTimeMillis());
        Socket socket = new Socket("localhost",8189);

        OutputStream outStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        //用printwriter将流转化为写入器
        long time=System.currentTimeMillis();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream,"UTF-8"),true);
        System.out.println("连接结束：");
        out.println("yes");
        out.println("yes898f的9");
        BufferedInputStream bufferedReader = new BufferedInputStream(inputStream);

        while (bufferedReader.read()!=-1) {
            System.out.println(bufferedReader.read());
        }
        System.out.println(System.currentTimeMillis()-time+'s');
        inputStream.close();
        socket.close();
    }
}
