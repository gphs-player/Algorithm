### 非递归方式实现遍历
借助链表

```
public class PrintAllFile {

    public static void main(String[] args) {
        File file = new File("/xxx/xxx");
        printAllFile(file);
    }

    private static void printAllFile(File rootFile) {
        int num = 0;
        if (rootFile == null) return;
        if (rootFile.exists() && rootFile.isDirectory()) {
            File[] files = rootFile.listFiles();
            if (files == null || files.length == 0) {
                return;
            }
            LinkedList<File> dirs = new LinkedList<>();
            for (File subFile : files) {
                if (subFile.isFile()) {
                    num++;
                    System.out.println(subFile.getAbsolutePath());
                } else {
                    //所有文件夹添加进列表
                    dirs.add(subFile);
                }
            }

            while (!dirs.isEmpty()) {
                File file = dirs.removeFirst();

                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) return;
                for (File subFile : listFiles) {
                    if (subFile.isFile()) {
                        num++;
                        System.out.println(subFile.getAbsolutePath());
                    } else {
                        dirs.add(subFile);
                    }
                }
            }
        }
        System.out.println("一共有 " + num + " 个文件");

    }
}
```
