import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupFiles {
    public static void main(String[] args) {
        // Определение пути к директории
        File directory = new File("path/to/directory");

        // Создание папки './backup' для хранения резервных копий
        File backupDirectory = new File("./backup");
        backupDirectory.mkdir();

        // Получение списка файлов в директории
        File[] files = directory.listFiles();

        // Обработка каждого файла
        for (File file : files) {
            // Проверка, является ли файл действительным файлом (не директорией)
            if (file.isFile()) {
                try {
                    // Создание пути для резервной копии
                    File backupFile = new File(backupDirectory + "/" + file.getName());

                    // Копирование файла в папку резервных копий
                    Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("Резервная копия файла " + file.getName() + " создана.");
                } catch (IOException e) {
                    System.out.println("Ошибка при создании резервной копии файла " + file.getName() + ": " + e.getMessage());
                }
            }
        }
    }
}