package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

//1开0关其他的
public class Client {
    // 客户端要发送的数据字节长度为10
// 所以服务端只能最大取得10个数据
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        socket.connect(new InetSocketAddress("localhost", 8888));
        String newString = "我是员工";
        byte[] byteArray = newString.getBytes();
        DatagramPacket myPacket = new DatagramPacket(new byte[] {}, 0);
        myPacket.setData(byteArray);
        myPacket.setLength(2);
        socket.send(myPacket);
        socket.close();
    }
}


