/**
 * 
 */
package com.elib.filler.folder;

import java.io.File;

import com.elib.filler.bean.FolderBean;
import com.elib.filler.util.FileExtension;

/**
 * @author Pavlo Romankevych
 * 
 */
public class FolderFilter extends FolderProcessor {

  public FolderFilter() {
  }

  public FolderBean filterFolderFiles(FolderBean folderBean) {
    setFolderBean(new FolderBean(folderBean.getFolderName()));
    for (File file : folderBean.getFiles()) {
      for (String extension : FileExtension.getExtensions()) {
        if (isAllowedExtension(file, extension)) {
          getFolderBean().getFiles().add(file);
          getFolderBean().getFileNameList().add(file.getName());
        }
      }
    }
    if (getFolderBean().getFiles() != null) {
      createResultFile(getFolderBean().getFiles(), getFilterResultFileName());
    }
    return getFolderBean();
  }

  public FolderBean filterFolderFilesByExtension(FolderBean folderBean, String extension) {
    setFolderBean(new FolderBean(folderBean.getFolderName()));
    for (File file : folderBean.getFiles()) {
      if (isAllowedExtension(file, extension)) {
        getFolderBean().getFiles().add(file);
        getFolderBean().getFileNameList().add(file.getName());
      }
    }
    if (getFolderBean().getFileNameList() != null) {
      createResultFile(getFolderBean().getFiles(), "(" + extension + ")" + getFilterResultFileName());
    }
    return getFolderBean();
  }

  private boolean isAllowedExtension(File file, String extension) {
    int beginIndex = file.getName().lastIndexOf(".");
    int endIndex = file.getName().length();
    String str = "";
    if (beginIndex != -1) {
      str = file.getName().substring(beginIndex, endIndex);
    }
    if (str.equalsIgnoreCase("."+extension)) {
      return true;
    }
    return false;
  }

}
