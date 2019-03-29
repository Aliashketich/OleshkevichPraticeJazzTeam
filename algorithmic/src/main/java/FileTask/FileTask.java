/*Дан файл со списком слов. Разработайте алгоритм, создающий максимально возможный прямоугольник из букв так,
  чтобы каждая строка и каждый столбец образовывали слово (при чтении слева направо и сверху вниз).
  Слова могут выбираться в любом порядке, строки должны быть одинаковой длины, столбцы - одинаковой высоты.*/

package FileTask;

import org.apache.log4j.Logger;
import util.fileUtil.ReadTextFromFile;

import java.io.IOException;
import java.util.List;

public class FileTask {
    private static final Logger logger = Logger.getLogger(FileTask.class);
    private static final String path = "src/main/java/FileTask/data.txt";

    public String buildSquare() throws IOException {

        String answer = "";
        try {
            ReadTextFromFile readTextFromFile = new ReadTextFromFile();
            List<String> wordsSource = readTextFromFile.readText(path);
            answer=wordsSource.toString();
        }catch (IOException ex){
            logger.error(ex);
        }

        return answer;
    }

}
