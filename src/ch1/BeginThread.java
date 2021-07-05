package ch1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//多线程实现socket
public class BeginThread implements Runnable{

private static int num=0;
    private Socket socket;
    public BeginThread(Socket socket)
    {

        super();
        this.socket = socket;
        num++;
    }
    @Override
    public void run(){
        try{
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            char[] charArr = new char[1000];
            int readLen = -1;
            while((readLen = (inputStreamReader.read(charArr))) != -1)
            {
                String newString = new String(charArr,0,readLen);
                System.out.println(newString+this.num);
            }

            inputStreamReader.close();
            inputStream.close();//关闭两个流
            socket.close();//关闭socket
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
