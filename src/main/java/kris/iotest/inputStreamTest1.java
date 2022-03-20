package kris.iotest;

import java.io.*;

public class inputStreamTest1 {
        public static void main(String[]args) throws IOException {
            //创建源
            File f=new File("F:/note/a.txt");
            InputStream is =null;//提升is的作用域，避免在try中声明后，作用域
            //只在try，finally中语句无法执行
            //选择流
            try {
                is =new FileInputStream(f);
                //操作(读取)
                int temp;
                while((temp=is.read())!=-1) //temp=is.read()表达式整体的值就是temp的值
                {
                    System.out.print((char)temp);
                }

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            finally {
                try {
                    if(null!=is)//当is创建成功时才执行关闭
                    {
                        is.close();
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
