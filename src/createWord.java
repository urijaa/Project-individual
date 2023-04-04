import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class createWord {
    private String[] arrRef;
    private String[] copyArrRef;
    private String copyString;
    StringBuilder builder;
    
    public void generateRandomWords(int numberOfWords){
        arrRef = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++){
            char[] word = new char[random.nextInt(8)+3];
            for(int j = 0; j < word.length; j++){
                word[j] = (char)('a' + random.nextInt(26));
            }
            arrRef[i] = new String(word);
        }
    }
    public String arrToString(){
        builder = new StringBuilder();
        for(String s : arrRef) {
            builder.append(s +" ");
        }
        copyString = builder.toString();
        return copyString;

    }

}