/**
 * 
 */
package com.elib.filler;

import java.util.List;

import com.elib.entity.Book;
import com.elib.filler.folder.FolderBean;
import com.elib.filler.folder.FolderFilter;
import com.elib.filler.folder.FolderScanner;
import com.elib.filler.parser.FileNameParser;

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
    FolderBean folderBean = scanner.scanFolder("D:\\Diploma\\Info", true);
    folderBean = filter.filterFolderFiles(folderBean);
   // folderBean = filter.filterFolderFilesByExtension(folderBean, FileExtension.DJVU);
    List<Book> books = parser.parseFileNameToObject(folderBean);
    System.out.println(books.size());
  }

}
