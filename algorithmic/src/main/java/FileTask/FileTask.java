/*Дан файл со списком слов. Разработайте алгоритм, создающий максимально возможный прямоугольник из букв так,
  чтобы каждая строка и каждый столбец образовывали слово (при чтении слева направо и сверху вниз).
  Слова могут выбираться в любом порядке, строки должны быть одинаковой длины, столбцы - одинаковой высоты.*/

package FileTask;

import org.apache.log4j.Logger;

import java.util.List;

import static util.fileUtil.ReadTextFromFile.readText;

class FileTask {
    private static final Logger logger = Logger.getLogger(FileTask.class);
    private static final String path = "src/main/java/FileTask/data.txt";

    String buildSquare() {

        List<String> wordsSource = readText(path);
        String answer = wordsSource.toString();

        /*@todo Реализовать запись результата в файл с ответом, и сравнение этих 2 файлов в тесте.*/

        return answer;
    }

}
