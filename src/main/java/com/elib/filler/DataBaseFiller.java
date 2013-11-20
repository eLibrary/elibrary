/**
 * 
 */
package com.elib.filler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.elib.dao.BookDAO;
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
@Component
public class DataBaseFiller {
  @Autowired
  BookDAO bookDAO;

  @SuppressWarnings("resource")
  public DataBaseFiller() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
    AutowireCapableBeanFactory acbFactory = ctx.getAutowireCapableBeanFactory();
    acbFactory.autowireBean(this);
  }

  public void doSMth() {
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
    bookDAO.save(booksTr.get(0));
  }

  /**
   * @param args
   */

  public static void main(String[] args) {
    DataBaseFiller baseFiller = new DataBaseFiller();
    baseFiller.doSMth();
  }

}
