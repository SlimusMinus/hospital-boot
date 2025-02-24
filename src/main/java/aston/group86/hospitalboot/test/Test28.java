package aston.group86.hospitalboot.test;


import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Test28 {

  // private static final int WORD_COUNT = 7;

  public List<String> getWords(int wordCount) {
    //List<String> stringList = new ArrayList<>();
    String response = requestRandomWords();
    log.debug("get words: " + response);

    JSONArray jsonArray = new JSONArray(response);

   // return IntStream.range(0, jsonArray.length()).boxed()

    return Stream.iterate(0, integer -> integer < jsonArray.length(), integer -> integer+1)
        .map(index -> {
              String word = "";
              try {
                word = jsonArray.getJSONObject(index).getString("word");

              } catch (Exception e) {
                log.error("Bad word {}", e.getMessage());
              }
              return word;
            }
        )
        .filter(word -> !word.isBlank())
        .limit(wordCount)
        .toList();


    /*for (int i = 0; i < sizeArray; i++) {
      try {
        String jsonWord = jsonArray.getJSONObject(i).getString("word");
        if (jsonWord.isBlank()) {
          if (sizeArray < jsonArray.length()) {
            sizeArray++;
          }
          continue;
        }
        stringList.add(jsonWord);
      } catch (Exception e) {
        log.error("Bad word {}", e.getMessage());
      }
    }
    return stringList;*/
  }

  public static void main(String[] args) {

    List<String> words = new Test28().getWords(4);
    System.out.println(words);

  }

  private static String requestRandomWords() {
    //go to some resource and return JSON
    return "[\n"
        + "  {\n"
        + "    \"name\": \"firstName\",\n"
        + "    \"word\": \"first\",\n"
        + "    \"type\": \"firstType\"\n"
        + "  },\n"
        + "  {\n"
        + "    \"name\": \"secondName\",\n"
        + "    \"word\": \"second\",\n"
        + "    \"type\": \"secondType\"\n"
        + "  },\n"
        + "  {\n"
        + "    \"name\": \"thirdName\",\n"
        + "    \"word\": \"third\",\n"
        + "    \"type\": \"thirdType\"\n"
        + "  },\n"
        + "  {\n"
        + "    \"name\": \"fourthName\",\n"
        + "    \"word\": \"\",\n"
        + "    \"type\": \"fourthType\"\n"
        + "  },\n"
        + "  {\n"
        + "    \"name\": \"fifthName\",\n"
        + "    \"word\": \"fifth\",\n"
        + "    \"type\": \"fifthType\"\n"
        + "  },\n"
        + "  {\n"
        + "    \"name\": \"sixthName\",\n"
        + "    \"word\": \"sixth\",\n"
        + "    \"type\": \"sixthType\"\n"
        + "  },\n"
        + "  {\n"
        + "    \"name\": \"seventhName\",\n"
        + "    \"word\": \"\",\n"
        + "    \"type\": \"seventhType\"\n"
        + "  },\n"
        + "  {\n"
        + "    \"name\": \"eighthName\",\n"
        + "    \"word\": \"  \",\n"
        + "    \"type\": \"eighthType\"\n"
        + "  }\n"
        + "]";
  }

}