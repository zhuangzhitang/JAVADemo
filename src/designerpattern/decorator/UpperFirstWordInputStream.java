package designerpattern.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpperFirstWordInputStream extends FilterInputStream{

	private int cBeffore;
	protected UpperFirstWordInputStream(InputStream inputstream) {
		super(inputstream);
	}
	@Override
	public int read() throws IOException {
		   //根据前一个字符是否是空格来判断是否要大写
        int c = super.read();
        if(cBeffore == 32)
        {
        	cBeffore = c;
            return (c == -1 ? c: Character.toUpperCase((char) c));
        }else{
        	cBeffore = c;
            return c;
        }
	}
    
}
