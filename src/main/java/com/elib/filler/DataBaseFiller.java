/**
 * 
 */
package com.elib.filler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.elib.dao.BookDAO;
import com.elib.dao.UserDAO;
import com.elib.entity.Book;
import com.elib.filler.folder.FolderBean;
import com.elib.filler.folder.FolderFilter;
import com.elib.filler.folder.FolderScanner;
import com.elib.filler.parser.FileNameParser;
import com.elib.filler.transliterator.BookTransliterator;

/**
 * @author Pavlo Romankevych
 * 
 */
public class DataBaseFiller {
  
  /**
   * @param args
   */
  
  public static void main(String[] args) {
    FolderScanner scanner = new FolderScanner();
    FolderFilter filter = new FolderFilter();
    FileNameParser parser = new FileNameParser();
    FolderBean folderBean = scanner.scanFolder("D:\\Diploma\\Info\\tmp", true);
    folderBean = filter.filterFolderFiles(folderBean);
    List<Book> booksPr = parser.parseFileNameToObject(folderBean);
    System.out.println(booksPr.size());
    BookTransliterator bookTransliterator = new BookTransliterator();
    List<Book> booksTr = bookTransliterator.transliterateBooks(booksPr);
    System.out.println(booksTr.size());
    //Temp temp = new Temp();
    //temp.store(booksTr.get(0));
  }

}
