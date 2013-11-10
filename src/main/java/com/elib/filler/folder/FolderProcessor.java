/**
 * 
 */
package com.elib.filler.folder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.elib.filler.bean.FolderBean;
import com.elib.filler.util.FileExtension;

/**
 * @author Pavlo Romankevych
 * 
 */
public abstract class FolderProcessor {

  private final static String SCAN_RESULT_FILE_NAME = "ScanResult.txt";
  private final static String FILTER_RESULT_FILE_NAME = "FilterResult.txt";
  private FolderBean folderBean;

  public FolderProcessor() {
  }

  public FolderBean getFolderBean() {
    return folderBean;
  }

  public void setFolderBean(FolderBean folderBean) {
    this.folderBean = folderBean;
  }

  protected void createResultFile(List<File> fileList, String resultFileName) {
    getFolderBean().setResultFile(new File(getFolderBean().getFolderName() + "\\" + resultFileName));
    try {
      FileWriter fileWriter = new FileWriter(getFolderBean().getResultFile());
      BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
      for (File file : fileList) {
        bufferWriter.write(file.getAbsolutePath());
        bufferWriter.newLine();
      }
      bufferWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  protected boolean checkAndDeleteResultFiles(File fileForChecking) {
    if (fileForChecking.getName().equalsIgnoreCase(SCAN_RESULT_FILE_NAME)
            || fileForChecking.getName().equalsIgnoreCase(FILTER_RESULT_FILE_NAME)) {
      return fileForChecking.delete();
    }
    if (isFilterResultFile(fileForChecking.getName())) {
      return fileForChecking.delete();
    }
    return false;
  }

  private boolean isFilterResultFile(String fileName) {
    for (String str : FileExtension.getExtensions()) {
      if (fileName.equalsIgnoreCase("(" + str + ")" + FILTER_RESULT_FILE_NAME)) {
        return true;
      }
    }
    return false;
  }

  public static String getScanResultFileName() {
    return SCAN_RESULT_FILE_NAME;
  }

  public static String getFilterResultFileName() {
    return FILTER_RESULT_FILE_NAME;
  }

}
