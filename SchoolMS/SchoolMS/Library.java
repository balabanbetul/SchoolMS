package SchoolMS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    String newBook;
    Scanner scanner = new Scanner(System.in);
    Scanner readFile = new Scanner(new File("C:/Users/volka/IdeaProjects/Projects/src/SchoolMS/BookList.txt"));

    ArrayList<String> bookList = new ArrayList<>();


    public Library() throws IOException {
        int count = 1;
        while (readFile.hasNextLine()) {
            String book = readFile.nextLine();
            try {
                if (book.substring(0, 3).contains("" + count)) {
                    bookList.add(book.substring(book.indexOf(".") + 2));
                    count++;
                }
            } catch (StringIndexOutOfBoundsException ignored) {
            }

        }
        saveFile();
    }

    private void addBook() throws IOException {
        System.out.println("Which book do you want to add?");
        newBook = scanner.nextLine();

        System.out.println("Do you want to add the file?\n1. Yes   2. No");
        if (scanner.nextLine().equals("1")) {
            bookList.add(newBook);
        }
        saveFile();
    }

    void getAddBook() throws IOException {
        addBook();
    }

    private void deleteBook() throws IOException {
        System.out.println("Which book do you want to remove?");
        String remove = scanner.nextLine();
        if (Integer.parseInt(remove) > 0 && Integer.parseInt(remove) - 1 < bookList.size() + 1) {
            System.out.println("Do you want to delete the file?\n1. Yes   2. No");
            if (scanner.nextLine().equals("1")) {
                bookList.remove(Integer.parseInt(remove) - 1);
            }
        }
        saveFile();
    }

    void getDeleteBook() throws IOException {
        deleteBook();
    }

    void showBookList() {
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println((i + 1) + ". " + bookList.get(i));
        }
        //System.out.println(bookList.size());
    }

    void saveFile() throws IOException {
        FileWriter saveBookList = new FileWriter("C:/Users/volka/IdeaProjects/Projects/src/SchoolMS/BookList.txt");
        for (int i = 0; i < bookList.size(); i++) {
            saveBookList.append(String.valueOf(i + 1)).append(". ").append(bookList.get(i)).append("\n");
        }
        saveBookList.close();
    }
}



