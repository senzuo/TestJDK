package nio;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by 申卓 on 2017/8/10.
 */
public class TestFiles {
    public static void main(String[] args) {
        Path path = Paths.get("data/nio-data.txt");
        boolean pathExists = Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        System.out.println(pathExists);
    }
}
