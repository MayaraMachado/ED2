package ed2;

import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class Canal {

    private ByteBuffer byteBuffer;
    private File file;
    private RandomAccessFile raf;
    private FileChannel fileChannel;

    public Canal(){
        file = new File("aluno.txt");
        try {
			raf = new RandomAccessFile(file, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

    public void escreverFile(int tamanho,Persistable object){
        try{
        	fileChannel = raf.getChannel();
        	object.persist();
        	byteBuffer = ByteBuffer.allocate(tamanho);
        	fileChannel.write(byteBuffer);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void lerFile(int tamanho, Persistable object){
    	try {
    		fileChannel = raf.getChannel();
    		byteBuffer = ByteBuffer.allocate(tamanho); 
    		int bytesRead = fileChannel.read(byteBuffer);
    		byteBuffer.flip();
    		
    		object.recover();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
