package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Stack;

//仅用递归函数和栈操作逆序一个栈 不能用其他数据结构
//先设计一个递归函数将栈的栈底元素返回并移除
public class Client2 {
    public static void sortStack(Stack<Integer>stack)
    {
        Stack<Integer>help=new Stack<Integer>();
        while(!stack.empty())
        {
            int a =stack.pop();
            while(!help.empty() && help.peek()<a)
                stack.push(help.pop());
            help.push(a);//其他情况都推入help
            while(!help.empty())
                stack.push(help.pop());//最后把help的元素都推入原stack

            }

    }
    public static void main(String[] args) throws IOException {

    }
}

