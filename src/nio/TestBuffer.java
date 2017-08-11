package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 申卓 on 2017/8/10.
 */

/**
 * 基本用法
 * 1.   写入数据到buffer
 * 2.   filp
 * 3.   读
 * 4.   clear
 */


/** Buffer
 *  capacity position limit
 *
 */
public class TestBuffer {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        /**
         * 分配
         * create buffer with capacity of 48 bytes
         */
        ByteBuffer buf = ByteBuffer.allocate(48);

        /**
         * 写入数据
         */
        int bytesRead = inChannel.read(buf); //read into buffer.
        while (bytesRead != -1) {

            buf.flip();  //make buffer ready for read

            while (buf.hasRemaining()) {
                /**
                 * 读数据  read from buffer into channel
                 */
                System.out.print((char) buf.get()); // read 1 byte at a time
            }

            buf.clear(); //make buffer ready for writing
            buf.compact(); //make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
