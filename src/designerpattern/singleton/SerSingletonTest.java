package designerpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerSingletonTest {
 
	public static void main(String[] args) throws Exception {
		 SerSingleton s1 = null;
         SerSingleton s = SerSingleton.getInstance();

         FileOutputStream fos = new FileOutputStream("c://test.txt");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(s);
         oos.flush();
         oos.close();

         FileInputStream fis = new FileInputStream("c://test.txt");
         ObjectInputStream ois = new ObjectInputStream(fis);
         s1 = (SerSingleton) ois.readObject();

         System.out.println(s);
         System.out.println(s1);
	}
}
