import java.util.Scanner;

public class DictionaryCommandline {
    private final int spaceNotoEng = 8;
    private final int spaceEngtoVie = 27;
    public DictionaryManagement dictM = new DictionaryManagement();
    public Scanner sc = new Scanner(System.in);
    
    public void Display(String target, String explain, int index){
        System.out.print(index + 1);
        for (int i = 0; i < spaceNotoEng -String.valueOf(index).length(); i++) {
            System.out.print(" ");
        }
        System.out.print("| " + target);
        for(int i = 0; i < spaceEngtoVie - target.length(); i++) {
            System.out.print(" ");
        }
        System.out.println("| " + explain);
    }
    public void showAllWords() {   
        System.out.println("VI-EN Dictionary");
        System.out.println("No      | English                    | Vietnamese");
        System.out.println("-------------------------------------------------");
        for(int i = 0; i < dictM.dic.WordList.size(); i++) {
            String _target = dictM.dic.WordList.get(i).getWordTarget();
            String _explain = dictM.dic.WordList.get(i).getWordExplain();
            Display(_target, _explain, i);
        }
    }
    
    public void dictionaryAdvanced() {
        dictM.insertFromFile();
        showAllWords();
        dictM.dictionaryLookup();
    }
    
    public void dictionarySearcher() {
        // Lam not phan nay
    }
}
