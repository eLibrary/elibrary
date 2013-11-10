package com.elib.filler.parser;

public class Container {

  private String newString = "";
  private String value = "";

  public String getNewString() {
    return newString;
  }

  public void setNewString(String newString) {
    this.newString = newString;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String toString() {
    return "newString = " + newString + "\nvalue = " + value;
  }
}
