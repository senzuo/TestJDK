//package nio;
//
//import java.io.RandomAccessFile;
//import java.nio.channels.FileChannel;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.util.Iterator;
//import java.util.Set;
//
///**
// * Created by 申卓 on 2017/8/10.
// */
//public class TestSelector {
//    public static void main(String[] args) throws Exception{
//
//        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
//
//        FileChannel inChannel = aFile.getChannel();
//
//        Selector selector = Selector.open();
//
//        channel.configureBlocking(false);
//
//        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
//
//
//        while(true) {
//
//            int readyChannels = selector.select();
//
//            if(readyChannels == 0) continue;
//
//
//            Set<SelectionKey> selectedKeys = selector.selectedKeys();
//
//            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
//
//            while(keyIterator.hasNext()) {
//
//                SelectionKey key = keyIterator.next();
//
//                if(key.isAcceptable()) {
//                    // a connection was accepted by a ServerSocketChannel.
//
//                } else if (key.isConnectable()) {
//                    // a connection was established with a remote server.
//
//                } else if (key.isReadable()) {
//                    // a channel is ready for reading
//
//                } else if (key.isWritable()) {
//                    // a channel is ready for writing
//                }
//
//                keyIterator.remove();
//            }
//        }
//
//    }
//}
