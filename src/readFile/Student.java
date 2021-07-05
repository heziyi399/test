package readFile;

import com.sun.org.glassfish.gmbal.Description;
import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.*;
import java.util.function.Supplier;

class goods implements Comparable<goods>{
    private String Itemnumber;
    private int Quatity;
    private String Supplier;
    private String Description;

    public String getItemnumber() {
        return Itemnumber;
    }
public void update(int num)
{
    this.Quatity = this.Quatity+num;//修改总库存的函数
}
    public void setItemnumber(String itemnumber) {
        Itemnumber = itemnumber;
    }

    public int getQuatity() {
        return Quatity;
    }

    public void setQuatity(int quatity) {
        Quatity = quatity;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
public void less(int num)
{
    //发货时数量减少的函数
    this.Quatity = this.Quatity-num;
}
    public goods(String itemnumber, int quatity, String supplier, String description) {
        Itemnumber = itemnumber;
        Quatity = quatity;
        Supplier = supplier;
        Description = description;
    }


    @Override
    public int compareTo(goods o) {//重载排序函数，按照升序进行排序
       if(Integer.parseInt(Itemnumber)>Integer.parseInt(o.Itemnumber))
           return 1;
        if(Integer.parseInt(Itemnumber)<Integer.parseInt(o.Itemnumber))
            return -1;

            return 0;
    }
}
class Fagood{
    private String operaion;
    private String Item;
    private int total;
    private String receiver;

    public String getOperaion() {
        return operaion;
    }

    public void setOperaion(String operaion) {
        this.operaion = operaion;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Fagood(String operaion, String item, int total, String receiver) {
        this.operaion = operaion;
        Item = item;
        this.total = total;
        this.receiver = receiver;
    }

    public Fagood(String operaion, String item) {
        this.operaion = operaion;
        Item = item;
    }

    public Fagood(String operaion, String item, int total) {
        this.operaion = operaion;
        Item = item;
        this.total = total;
    }
}
public class Student {

    public static void main(String[] args) throws IOException {

        String datas[][] = new String[10][10];
        String data2[][] = new String[10][10];
        Vector<goods> Good = new Vector<goods>(0);
        //    int Quantity[] = new int[1000000];//库存数量
        Vector<Fagood> FaGood = new Vector<Fagood>(0);
        PrintWriter out1 = new PrintWriter("D:\\Error.txt","UTF-8");
        FileReader mfr = new FileReader("D:\\Transactions.txt");
        BufferedReader mbffr = new BufferedReader(mfr);
        FileReader fr = new FileReader("D:\\Inventory.txt");
        PrintWriter out = new PrintWriter(new FileWriter("D:\\Shipping.txt",true));
PrintWriter newFile = new PrintWriter(new FileWriter("D:\\NewInventory.txt",true));

      out.println("客户编号 "+" "+"Item号 "+"货物数量");
        BufferedReader bffr = new BufferedReader(fr);//  BufferedReader  缓冲字符流 可以读取中文字符
        try {



            String s = null;
            int i = 0;
            while ((s = bffr.readLine()) != null) {//每次都读取一行

                datas[i] = s.split("\t");

                System.out.println("第" + i + "行" + s);
                goods agood = new goods(datas[i][0], Integer.parseInt(datas[i][1]), datas[i][2], datas[i][3]);

           //     System.out.println(agood.getDescription());
                Good.addElement(agood);//把一个商品加入到vector数组中


                i++;
            }
            bffr.close();
            fr.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println(Good.capacity());
//处理D:\Transactions.txt

        try {

            String s = null;
            int i = 0;

            while ((s = mbffr.readLine()) != null)
            {

                data2[i] = s.split("\t");

                Iterator iterator = Good.iterator();
                if (data2[i][0].matches("O"))
                {
         Fagood fagood = new Fagood(data2[i][0], data2[i][1], Integer.parseInt(data2[i][2]), data2[i][3]);
              // System.out.println(fagood.getItem());
                    //     Cliens.add(Integer.parseInt(data2[i][3]));
                    //添加发货的一件商品
                    FaGood.add(fagood);
                    for (int j = 0; j < Good.capacity()-1; j++)
                    {

                        //System.out.println(good.getQuatity());
                        if (Integer.parseInt(Good.get(j).getItemnumber()) == Integer.parseInt(fagood.getItem()))
                        {
                            int num = Good.get(j).getQuatity();
                            System.out.println(num);
                            num = num - fagood.getTotal();
                            System.out.println("减去后"+num);
                            if (num < 0) {
                                //验错，如果发货的总量超过了库存则写入error.txt
                                try
                                {
                                    File file2 = new File("D:\\Error.txt");

                                    FileWriter in = new FileWriter(file2, true);

                                    out1.println(String.valueOf(fagood.getItem()) + "发货库存量不足\n");
//

                                }
                                catch (Exception ee) {
                                    ee.printStackTrace();
                                }
                            }
                            else {
                                Good.get(j).less(fagood.getTotal());

                                //如果库存足够
                                try {
                                    File ship = new File("D:\\Shipping.txt");
                                    System.out.println("发货一次");
                                    FileWriter fw = new FileWriter(ship, true);

//                        out.println(fagood.getReceiver()+"\t"+fagood.getTotal()+"\t"+fagood.getItem());
                   out.println( fagood.getReceiver()+"\t"+fagood.getTotal()+"\t"+fagood.getItem()+"\n");



                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }


                        }

                    }
                 //   System.out.println(Good.capacity());

                }
                    if (data2[i][0].matches("D"))//删除一种商品
                    {
                        for (goods good : Good) {
                            if (Integer.parseInt(good.getItemnumber()) == Integer.parseInt(data2[i][1])) {
                                Good.remove(good);//删除该种商品
                            }
                        }

                    }
                    if (data2[i][0].matches("R")) {//到货单记录，在'R'后面是Item number和它的数量Quanlity。
                        for (goods good : Good) {
                            if (Integer.parseInt(good.getItemnumber()) == Integer.parseInt(data2[i][1])) {
                               System.out.println("是R");

                           good.update(Integer.parseInt(data2[i][2]));//增加库存
                            }
                        }
                    }


                i++;
            }
            out.flush();
            out.close();
            out1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }    finally {

        }
Collections.sort(Good);
        newFile.close();
        for (goods good : Good)
        {
System.out.println(good.getItemnumber()+" "+good.getQuatity()+" "+good.getDescription());
        }

    }


}



                 //   if (data2[i][1] != null) TransactionsItem[i] = data2[i][1];


                   // int temp;//临时存储
//                    numbers[ItemFa[i]] = Integer.parseInt(data2[i][2]);
//                    temp = Quantity[ItemFa[i]];
//                    Quantity[ItemFa[i]] = Quantity[ItemFa[i]] - numbers[ItemFa[i]];
//                    if (Quantity[ItemFa[i]] < 0) {//如果发货量不足，则写入error.txt
//                        File file2 = new File("D:\\Error.txt");
//
//
//                        try {
//                            FileWriter in = new FileWriter(file2, true);
//                            BufferedWriter writer = new BufferedWriter(in);
//                            writer.write(String.valueOf() + "发货库存量不足\n");
//                        } catch (Exception ee) {
//                            ee.printStackTrace();
//                        }
//                    }
//                    else{
//
//
//                            try {
//                                File file2 = new File("D:\\Error.txt");
//
//
//                                FileWriter in = new FileWriter(file2, true);
//                                BufferedWriter writer = new BufferedWriter(in);
//                                writer.write(String.valueOf(fa) + "发货库存量不足\n");
//                            } catch (Exception ee) {
//                                ee.printStackTrace();
//                            }
//
//                }
                //numbers[Integer.parseInt(TransactionsItem[i] )] =  numbers[Integer.parseInt(TransactionsItem[i] )] +Integer.parseInt(data2[i][2]);
//                if (ham.containsKey(TransactionsItem[i])) {
//                    int total = ham.get(TransactionsItem[i]) + numbers[i];
//                    ham.put(TransactionsItem[i], total);
//                } else
//                    ham.put(TransactionsItem[i], numbers[i]);

//if(Matter[i].matches("O")) System.out.print("YES");

                //   System.out.println("第"+i+"行"+s);

                //      System.out.println(data2[i][0]+","+data2[i][1]);
//                TotalLines++;
//                i++;
//            }
//            mbffr.close();
//            mfr.close();
//        }catch (Exception e2){
//            e2.printStackTrace();
//        }
//--------------------------------------------------------------------------------------------------
//        Vector hs = new Vector();
//        String ItemNumber[] = new String[10000];
//      int Cliens[] = new int[1000000];
//        int Quantity[] = new int[1000000];//库存数量
//        int ItemFa[] = new int[1000000];//发货编号
//        String Supplier[] = new String[10];
//        String Description[] = new String[10];
//        String opertion[] = new String[10];//操作
//        String Matter[] = new String[10];//事务类型
//        String TransactionsItem[] = new String[10];
//        int numbers[] = new int[1000000];
//
//        HashMap<String, Integer> ham = new HashMap<>();
//        int TotalLines = 0;//一共多少行
//
//
//
//        try {
//            FileReader fr = new FileReader("D:\\Inventory.txt");
//            BufferedReader bffr = new BufferedReader(fr);
//            String s = null;
//            int i = 0;
//            while ((s = bffr.readLine()) != null) {
//
//                datas[i] = s.split("\t");
//
//                System.out.println("第" + i + "行" + s);
//                //     System.out.println(datas[i][0]+","+datas[i][1]);
//                ItemNumber[i] = datas[i][0];
//                Quantity[Integer.parseInt(ItemNumber[i])] = Integer.parseInt(datas[i][1]);//某一个编号的货物对应的库存数量
//                Supplier[i] = datas[i][2];
//
//                Description[i] = datas[i][3];
//
//                i++;
//            }
//            bffr.close();
//            fr.close();
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//
//
//        try {
//
//            FileReader mfr = new FileReader("D:\\Transactions.txt");
//            BufferedReader mbffr = new BufferedReader(mfr);
//            String s = null;
//            int i = 0;
//            while ((s = mbffr.readLine()) != null) {
//
//                data2[i] = s.split("\t");
//                // System.out.println("第"+(i+1)+"行"+s);
////                System.out.println(Integer.parseInt(data2[i][2]));
//                if (data2[i][0] != null) {
//                    Matter[i] = data2[i][0];
//                    if (Matter[i].matches("O"))
//                    {
//                   //     Cliens.add(Integer.parseInt(data2[i][3]));
//                        hs.addElement(Integer.parseInt(data2[i][3]));
//                 Cliens[i] = Integer.parseInt(data2[i][3]);
//                        ItemFa[i] = Integer.parseInt(data2[i][1]);
//
//                }
//                if (data2[i][1] != null) TransactionsItem[i] = data2[i][1];
//
//
//                    int temp;//临时存储
//                    numbers[ItemFa[i]] = Integer.parseInt(data2[i][2]);
//                    temp = Quantity[ItemFa[i]];
//                    Quantity[ItemFa[i]] = Quantity[ItemFa[i]] - numbers[ItemFa[i]];
//                    if (Quantity[ItemFa[i]] < 0) {//如果发货量不足，则写入error.txt
//                        File file2 = new File("D:\\Error.txt");
//
//
//                        try {
//                            FileWriter in = new FileWriter(file2, true);
//                            BufferedWriter writer = new BufferedWriter(in);
//                            writer.write(String.valueOf(Quantity[ItemFa[i]]) + "发货库存量不足\n");
//                        } catch (Exception ee) {
//                            ee.printStackTrace();
//                        }
//                    }
//                    else{
//                        try {
//                            File file2 = new File("D:\\Shipping.txt");
//                            FileWriter fw = new FileWriter(file2, true);
//                            BufferedWriter writer = new BufferedWriter(fw);
//                            writer.write(String.valueOf(Cliens[i]));
//
//                            writer.write("\t");
//                            writer.write(String.valueOf(numbers[ItemFa[i]]));
//                            writer.write("\t");
//                            writer.write(String.valueOf(ItemFa[i]));
//                            writer.newLine();
//                            writer.close();
//                            fw.close();
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                //numbers[Integer.parseInt(TransactionsItem[i] )] =  numbers[Integer.parseInt(TransactionsItem[i] )] +Integer.parseInt(data2[i][2]);
//                if (ham.containsKey(TransactionsItem[i])) {
//                    int total = ham.get(TransactionsItem[i]) + numbers[i];
//                    ham.put(TransactionsItem[i], total);
//                } else
//                    ham.put(TransactionsItem[i], numbers[i]);
//
////if(Matter[i].matches("O")) System.out.print("YES");
//
//                //   System.out.println("第"+i+"行"+s);
//
//                //      System.out.println(data2[i][0]+","+data2[i][1]);
//                TotalLines++;
//                i++;
//            }
//            mbffr.close();
//            mfr.close();
//        }catch (Exception e2){
//            e2.printStackTrace();
//        }

//File file2 = new File("D:\\Shipping.txt");
            // FileOutputStream file2 = new FileOutputStream("D:\\Shipping.txt");
           // File file2 = new File("D:\\Shipping.txt");


            //    Arrays.sort(numbers);
            //for(int m =0;m< numbers.length;m++) System.out.print(numbers[m]+",");
//            for (int m = 0; m < Matter.length; m++) {
//                if (Matter[m].matches("O")) {
//                    //System.out.println(Cliens[m]);
//                    try {
//                        FileWriter fw = new FileWriter(file2, true);
//                        BufferedWriter writer = new BufferedWriter(fw);
//                        writer.write(String.valueOf(Cliens[m]));
//
//                        writer.write("\t");
//                        writer.write(String.valueOf(numbers[[ItemFa[i]]));
//                        writer.write("\t");
//                        writer.write(String.valueOf(ItemFa[m]));
//                        writer.newLine();
//                        writer.close();
//                        fw.close();
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
            //  for(String key:ham.keySet())
            // System.out.println(ham.get(key));
//            for (int j = 0; j < TotalLines - 1; j++) {
//                for (int z = j + 1; z < TotalLines; z++) {
//                    System.out.print(TransactionsItem[j] + ":");
//                    if (TransactionsItem[j].matches(TransactionsItem[z])) {
//                        numbers[j] = numbers[j] + numbers[z];
//
//                    }
//
//                };
//
//            }
//        }

