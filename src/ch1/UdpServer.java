package ch1;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UdpServer {

public byte[]getTime(){
    Date d = new Date();
    return d.toString().getBytes(StandardCharsets.UTF_8);
}
public void go() throws IOException{

    DatagramPacket inDataPacket;
    DatagramPacket outDataPacket;
    DatagramSocket datagramSocket;
    InetAddress clientAdress;
    int clientPort;
    byte[]msg = new byte[10];//Incoming data buffer.ignored
    byte[]time;
    datagramSocket = new DatagramSocket(8000);//allocate a socket to man port 8000 for requests
    System.out.println("UDPserver :"+datagramSocket.getPort()+"local is:"+datagramSocket.getLocalPort());
    System.out.println("udpserver active on port 8000");
    while (true)
    {
        inDataPacket = new DatagramPacket(msg,msg.length);
        datagramSocket.receive(inDataPacket);//get the message
        clientAdress = inDataPacket.getAddress();
        clientPort = inDataPacket.getPort();
        time=getTime();
        outDataPacket = new DatagramPacket(time,time.length,clientAdress,clientPort);
        datagramSocket.send(outDataPacket);//send the packet

    }
}
    public List<List<Integer>> threeSum(int[] nums) {
    int num = nums.length;
        Arrays.sort(nums);
        List<List<Integer>>res = new ArrayList<>();

        for(int first = 0;first < num;++first)
        {
            if(first > 0 && nums[first] == nums[first-1]) continue;
            int c = -nums[first];
            int third = num-1;
            for(int second = first+1;second < num;second++)
            {
                if(second > first+1 && nums[second] == nums[second-1]) continue;
                while (third > second && nums[third] + nums[second] > c) --third;
                if(second == third) break;
                if(nums[first]+nums[second] == c) {
                    List<Integer> newin = new ArrayList<>();
                    newin.add(nums[first]);
                    newin.add(nums[second]);
                    newin.add(nums[third]);
                    res.add(newin);

                }
            }
        }
        return res;




    }
    public static void main(String[]args) throws ClassNotFoundException {
//获得类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }

}