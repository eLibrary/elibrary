/**
 * 
 */
package com.elib.filler;

import java.util.List;

import com.elib.filler.bean.Book;
import com.elib.filler.bean.FolderBean;
import com.elib.filler.folder.FolderFilter;
import com.elib.filler.folder.FolderScanner;
import com.elib.filler.parser.FileNameParser;
import com.elib.filler.util.FileExtension;

/**
 * @author Pavlo Romankevych
 * 
 */
public class Runner {

  /**
   * @param args
   */
  public static void main(String[] args) {
    FolderScanner scanner = new FolderScanner();
    FolderFilter filter = new FolderFilter();
    FileNameParser parser = new FileNameParser();
    FolderBean folderBean = scanner.scanFolder("D:\\Diploma\\Info", true);
    folderBean = filter.filterFolderFiles(folderBean);
   // folderBean = filter.filterFolderFilesByExtension(folderBean, FileExtension.DJVU);
    List<Book> books = parser.parseFileNameToObject(folderBean);
    System.out.println(books.size());
  }

}
