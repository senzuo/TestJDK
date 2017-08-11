package nio;

/**
 * Created by 申卓 on 2017/8/10.
 */
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPath {

    public static void main(String[] args) {

//        Path path = Paths.get("c:\\data\\myfile.txt");
        Path path = Paths.get("data/nio-data.txt");
        System.out.println(path.isAbsolute());
        System.out.println(path.getParent());
        System.out.println(path.getFileName());
        System.out.println(path.toAbsolutePath());

        Path path2 = Paths.get(".");
        System.out.println(path2.toAbsolutePath());
    }
}