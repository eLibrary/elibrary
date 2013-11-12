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
    FolderBean folderBean = scanner.scanFolder("D:\\Diploma\\Info\\tmp");

    folderBean = filter.filterFolderFiles(folderBean);
    // ff.filterFolderFilesByExtension(fb, FileExtension.PDF); ff.filterFolderFilesByExtension(fb, FileExtension.DJVU);
    List<Book> books = parser.parseFileNameToObject(folderBean);
    System.out.println(books.size());
  }

}
