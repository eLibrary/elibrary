/**
 * 
 */
package com.elib.filler.folder;

import java.io.File;

/**
 * @author Pavlo Romankevych
 * 
 */
public class FolderScanner extends FolderProcessor {

  public FolderScanner() {
  }

  public FolderBean scanFolder(String folderName, boolean scanSubfolders) {
    setFolderBean(new FolderBean(folderName));
    scan(folderName, scanSubfolders);
    if (getFolderBean().getFiles() != null) {
      createResultFile(getFolderBean().getFiles(), getScanResultFileName());
    }
    return getFolderBean();
  }

  private void scan(String folderName, boolean scanSubfolder) {
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
      } else if (scanSubfolder==true){
        scan(file.getAbsolutePath(), scanSubfolder);        
      }
    }
  }

}
