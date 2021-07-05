package com.a;

import java.util.*;

public class Client {
    public static void main(String[] args) {
Student stu1=new Student();
        HashMap n1 = new HashMap<Integer, String>();
   stu1.map.put(90,"张三");
   stu1.map.put(80,"李四");
   stu1.map.put(85,"小明");
   stu1.map.put(60,"王五");
stu1.sortt();
System.out.println("60分的同学"+stu1.find(60));
    }

}

class Student{
  public   HashMap<Integer, String>map=new  HashMap<Integer, String>();
         public Vector< HashMap<Integer, String>>vector;

    String find(int grade){
        String name = "";

           if(map.containsKey(60)) name= map.get(60);

        return name;
    }

   public void sortt(){
        int a[]=new int[4];
        int i = 0;
       Set<Integer> keySets = map.keySet();
LinkedList<Integer> list=new LinkedList<Integer>();
        for (Integer key:keySets) {
            a[i] = key;
            i++;
            list.add(key);
        }
        Collections.sort(list);//用collection的方法排序
       System.out.print("用collection的方法排序：");
for(Integer num:list){
    System.out.print(num+",");

}
       System.out.println('\n');
        for(int j = 1;j<4;j++)//直接排序的方法
        {
            int temp=a[j];
            int z= j-1;
            while(a[z]>temp&&z>=0){
                a[z+1]=a[z];
                z=z-1;
                if(z==-1)break;
            }
            a[z+1]=temp;//插入元素
        }
       System.out.println("直接排序得到的序列：");
        for(int j = 0;j<4;j++)
        {
            System.out.print(a[j]+",");
        }
       System.out.println("\n");
    }
}