package nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.time.ZoneOffset;
import java.util.Formatter;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FileSamples {


    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        File root0 = File.listRoots()[0];
        Stream.of(root0.listFiles()).limit(3).forEach(file -> System.out.println(" " + file.getName()));

        System.out.println("==============");
        Stream.of(Path.of(userDir).toFile().listFiles()).filter(
                Predicate.not(File::isHidden).or(File::isFile).or(File::isDirectory)).forEach(file -> {
            var basic = Files.getFileAttributeView(file.toPath(), BasicFileAttributeView.class);
            var posix = Files.getFileAttributeView(file.toPath(), PosixFileAttributeView.class);

            try {
                var attribs = posix.readAttributes();

                var perms = attribs.permissions();

                StringBuilder d = new StringBuilder(file.isDirectory()? "d" : "-")
                .append(perms.contains(PosixFilePermission.OWNER_READ) ? "r":"-")
                .append(perms.contains(PosixFilePermission.OWNER_WRITE) ? "w":"-")
                .append(perms.contains(PosixFilePermission.OWNER_EXECUTE) ? "x":"-")
                .append(perms.contains(PosixFilePermission.GROUP_READ) ? "r":"-")
                .append(perms.contains(PosixFilePermission.GROUP_WRITE) ? "w":"-")
                .append(perms.contains(PosixFilePermission.GROUP_EXECUTE) ? "x":"-")
                .append(perms.contains(PosixFilePermission.OTHERS_READ) ? "r":"-")
                .append(perms.contains(PosixFilePermission.OTHERS_WRITE) ? "w":"-")
                .append(perms.contains(PosixFilePermission.OTHERS_EXECUTE) ? "x":"-");




                StringBuilder sb = new StringBuilder(d);
                var last = attribs.lastModifiedTime().toInstant().atZone(ZoneOffset.UTC);
                sb.append(" ")
                        .append(attribs.owner().getName())
                        .append(" ")
                        .append(attribs.group().getName())
                        .append(" ")
                        .append(String.format("%7d",attribs.size()))
                        .append(" ")
                        .append(String.format("%3tb %2td",last, last))
                        .append(" ")
                        .append(file.getName());

                System.out.println(sb);

            } catch (IOException e) {

            }
        });


    }

}
