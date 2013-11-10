/**
 * 
 */
package com.elib.filler.folder;

import java.io.File;

import com.elib.filler.bean.FolderBean;

/**
 * @author Pavlo Romankevych
 * 
 */
public class FolderScanner extends FolderProcessor {

  public FolderScanner() {
  }

  public FolderBean scanFolder(String folderName) {
    setFolderBean(new FolderBean(folderName));
    scan(folderName);
    if (getFolderBean().getFiles() != null) {
      createResultFile(getFolderBean().getFiles(), getScanResultFileName());
    }
    return getFolderBean();
  }

  private void scan(String folderName) {
    File folder = new File(folderName);
    File[] list = folder.listFiles();
    if (list == null)
      return;
    for (File file : list) {
      if (file.isFile()) {
        if (!checkAndDeleteResultFiles(file)) {
          getFolderBean().getFiles().add(file);
          getFolderBean().getFileNameList().add(file.getName());
        }
      } else {
        scan(file.getAbsolutePath());
      }
    }
  }

}
