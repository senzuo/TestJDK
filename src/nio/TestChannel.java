package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * a basic example that uses a FileChannel to read some data into a Buffer:
 * Created by 申卓 on 2017/8/10.
 */
public class TestChannel {
    public static void main(String[] args) throws Exception {

        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");

        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        /**
         * Reads a sequence of bytes from this channel into a subsequence of the
         * given buffers.
         */
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            /**
             * Flips this buffer.  The limit is set to the current position and then
             * the position is set to zero.  If the mark is defined then it is
             * discarded.
             * 反转  要读啦！
             */
            buf.flip();

            while (buf.hasRemaining()) {
                /**
                 * Reads the byte at this buffer's
                 * current position, and then increments the position.
                 * 读一个字节
                 */
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
