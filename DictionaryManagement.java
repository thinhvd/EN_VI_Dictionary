import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DictionaryManagement {
    public Dictionary dic = new Dictionary();
    Scanner sc = new Scanner(System.in);
    public HashMap<String, String> map = new HashMap<>();
    List<String> lines = new ArrayList<String>();
    String line = null;;

    public void insertFromCommandline() {
        while (sc.hasNextLine()) {
            try {
                FileWriter file = new FileWriter("F://codejava//DictionaryProject//Dictionary.txt", true);
                String target = sc.nextLine();
                String explain = sc.nextLine();
                Word temp = new Word(target, explain);

                map.put(target, explain); // cho vao trong map
                file.write(target + "\t"); // nhap tieng anh
                file.write(explain + "\n"); // nhap tieng viet
                file.close();
            } catch (IOException ex) {
                System.out.println("Loi ghi file: " + ex);
            }
        }
    }

    public void insertFromFile() {
        File a = new File("F://codejava//DictionaryProject//Dictionary.txt");
        try {
            Scanner sc = new Scanner(a);
            String target = null;
            String explain = null;
            while (sc.hasNextLine()) {
                String firstline = sc.nextLine();
                int pos = firstline.indexOf('\t');
                if (pos > 0) {
                    target = firstline.substring(0, pos); // lay phan target
                    explain = firstline.substring(pos + 1);
                }
                else target = firstline.substring(1);
                Word newword = new Word(target, explain);
                dic.addWord(newword);
                map.put(target, explain);
            }
        } catch (IOException ex) {
            System.out.println("Loi doc file: " + ex);
        }

    }

    public void insertFromFileAdvanced() {
        File a = new File("D:\\BTL_Dictionary\\src\\data.dict");
        try {
            Scanner sc = new Scanner(a);
            String target;
            String explain;
            while (sc.hasNextLine()) {
                String temp = "bala";
                String firstLine = sc.nextLine();
                int pos = firstLine.indexOf('/'); // xac dinh vi tri phan phat am
                if (pos > 0) target = firstLine.substring(1, pos - 1); // bo phan phat am va dau @
                else target = firstLine.substring(1);
                explain = "/" + firstLine.substring(pos + 1);
                while (Character.compare(temp.charAt(0), '@') != 0) { // dau @ o dau moi tu
                    temp = sc.nextLine();
                    if (temp.equals("")) break;
                    explain = explain + "\n" + temp;
                    if (!sc.hasNextLine()) break;
                }
                Word newword = new Word(target, explain);
                dic.addWord(newword);
                map.put(target, explain);
            }

        } catch (FileNotFoundException e) {
            System.out.println("khong tim thay file");
        }
    }

    public void dictionaryLookup() {
        Scanner sc = new Scanner(System.in);
        System.out.print("The word you wanna search is: ");
        while (sc.hasNextLine()) {
            String temp = sc.next();
            if (map.get(temp) != null) {
                System.out.println("It means: " + map.get(temp));
                System.out.print("The word you wanna search is: ");
            } else {
                System.out.println("Word is not found, please search another word!");
                System.out.print("The word you wanna search is: ");
            }
        }
    }

    public void addWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The word you wanna add is: ");
        String target = sc.next();
        System.out.println("The word's meaning is: ");
        String explain = sc.next();
        Word temp = new Word(target, explain);
        dic.addWord(temp);
        map.put(target, explain);
    }

    public void addWordAdvanced(String target, String explain) {
        try {
            FileWriter file = new FileWriter("D:\\BTL_Dictionary\\src\\data.dict", true);
            file.flush();
            file.write("\n@" + target + '\n');
            file.write(explain + '\n');
            file.close();
        } catch (IOException e) {
            System.out.println("Khong tim thay file");
        }
    }

    public void deleteWord(String target) {
        if (map.containsKey(target)) {
            String explain = map.get(target);
            Word temp = new Word(target, explain);
            map.remove(target);
            dic.deleteWord(target);
        } else return;
    }

    public void deleteWordAdvanced(String target) {
        try {
            File f1 = new File("D:\\BTL_Dictionary\\src\\data.dict");
            Scanner sc = new Scanner(f1);
            String temp = '@' + target;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (line.length() > target.length() && line.substring(0, target.length() + 1).equals(temp) && line.substring(target.length() + 1, target.length() + 3).equals(" /")) {
                    line = line.replace(line.substring(1), "?");
                }
                lines.add(line);
            }

            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines)
                out.write(s + "\n");
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void editWord(String target) {
        if (map.containsKey(target)) {
            Scanner sc = new Scanner(System.in);
            String temp = sc.nextLine();
            map.put(target, temp);
        } else return;
    }

    public void dictionaryExportToFile() {
        try {
            File file = new File("F://codejava//DictionaryProject//dictionaryExportToFile.txt");
            FileWriter temp = new FileWriter(file);
            Iterator<String> itr = map.keySet().iterator(); //https://viettuts.vn/java-collection/hashmap-trong-java
            while (itr.hasNext()) {
                temp.write(itr.next() + "\t"); //them target va dau tab
                temp.write(map.get(itr.next()) + "\n"); //them explain va xuong dong
            }
        } catch (IOException e) {
            System.out.println("Khong tim thay file");
        }
    }
}