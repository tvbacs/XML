import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileLister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập đường dẫn của thư mục hoặc file từ người dùng
        System.out.println("Nhập đường dẫn của thư mục hoặc file:");
        String path = scanner.nextLine();

        // Tạo một đối tượng File từ đường dẫn được nhập
        File file = new File(path);

        // Kiểm tra xem thư mục hoặc file có tồn tại không
        if (file.exists()) {
            // Tạo một StringBuilder để xây dựng nội dung XML
            StringBuilder xmlBuilder = new StringBuilder();
            xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xmlBuilder.append("<directory>\n");
            // Gọi phương thức để liệt kê thư mục và tệp
            listFiles(file, xmlBuilder);
            xmlBuilder.append("</directory>");

            // Lưu nội dung XML vào file
            try {
                FileWriter writer = new FileWriter("directory_listing.xml");
                writer.write(xmlBuilder.toString());
                writer.close();
                System.out.println("Đã tạo file XML thành công.");
            } catch (IOException e) {
                System.out.println("Không thể tạo file XML.");
            }
        } else {
            System.out.println("Thư mục hoặc file không tồn tại.");
        }

        scanner.close();
    }

    // Phương thức đệ quy để liệt kê thư mục và tệp dưới dạng XML
    private static void listFiles(File file, StringBuilder xmlBuilder) {
        if (file.isDirectory()) {
            xmlBuilder.append("<directory name=\"").append(file.getName()).append("\">\n");
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    listFiles(subFile, xmlBuilder);
                }
            }
            xmlBuilder.append("</directory>\n");
        } else {
            xmlBuilder.append("<file>").append(file.getName()).append("</file>\n");
        }
    }
}
