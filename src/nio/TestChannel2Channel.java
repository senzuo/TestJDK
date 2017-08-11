package nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by 申卓 on 2017/8/10.
 */
public class TestChannel2Channel {
    public static void main(String[] args) throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("data/toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        toChannel.transferFrom(fromChannel, position, count);

    }
}
