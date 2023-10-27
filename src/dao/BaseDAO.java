package dao;

import java.io.*;

public class BaseDAO {
    //此为文档注释
    /**
     *
     * @param path 序列化文件的路径 类型：字符串
     * @param object 序列化的对象 类型：Object
     * @return 返回 boolean
     */
    //保存对象到文件中（序列化）
    public  boolean writeObject(String path,Object object )
    {//写文件到user.bin
        boolean flag = false;
        OutputStream os;
        try {
            os = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(object);//再将集合存到文件中
            oos.close();
            os.close();
            flag = true;
        } catch (FileNotFoundException e) {
            flag = false;
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    /**
     *
     * @param path 反序列化文件的路径 参数类型：字符串
     * @return 返回序列化文件中写入的文件内容  返回类型：Object
     */
    //读：反序列化（写进什么，读取什么）
    public  Object readObject(String path)
    {
        Object object=null;
        InputStream is;
        try {
            is = new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(is);
            //读文件返回数据
            object= ois.readObject();
            ois.close();
            is.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return object;
    }




}
