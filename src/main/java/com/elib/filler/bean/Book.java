/**
 * 
 */
package com.elib.filler.bean;

/**
 * @author Pavlo Romankevych
 * 
 */
public class Book {

  private String title;
  private String author;
  private String series;
  private String edition;
  private String publisher;
  private Integer publishYear;
  private String language;
  private String identifier;
  private boolean landscape;
  private boolean ocr;
  private boolean kromsated;
  private boolean color;
  private boolean bookmarks;
  private boolean kromsatedByScanmagic;
  private Integer dpi;
  private Integer pages;
  private String extension;

  public Book(String title, String author, String edition, String publisher, Integer publishYear,
          String language, boolean landscape, boolean ocr, boolean kromsated, boolean color, Integer dpi,
          Integer pages, String extension) {
    super();
    this.title = title;
    this.author = author;
    this.edition = edition;
    this.publisher = publisher;
    this.publishYear = publishYear;
    this.language = language;
    this.landscape = landscape;
    this.ocr = ocr;
    this.kromsated = kromsated;
    this.color = color;
    this.dpi = dpi;
    this.pages = pages;
    this.extension = extension;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getSeries() {
    return series;
  }

  public void setSeries(String series) {
    this.series = series;
  }

  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Integer getPublishYear() {
    return publishYear;
  }

  public void setPublishYear(Integer publishYear) {
    this.publishYear = publishYear;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public boolean isLandscape() {
    return landscape;
  }

  public void setLandscape(boolean landscape) {
    this.landscape = landscape;
  }

  public boolean isOcr() {
    return ocr;
  }

  public void setOcr(boolean ocr) {
    this.ocr = ocr;
  }

  public boolean isKromsated() {
    return kromsated;
  }

  public void setKromsated(boolean kromsated) {
    this.kromsated = kromsated;
  }

  public boolean isColor() {
    return color;
  }

  public void setColor(boolean color) {
    this.color = color;
  }

  public Integer getDpi() {
    return dpi;
  }

  public void setDpi(Integer dpi) {
    this.dpi = dpi;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public Book() {
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public boolean isBookmarks() {
    return bookmarks;
  }

  public void setBookmarks(boolean bookmarks) {
    this.bookmarks = bookmarks;
  }

  public boolean isKromsatedByScanmagic() {
    return kromsatedByScanmagic;
  }

  public void setKromsatedByScanmagic(boolean kromsatedByScanmagic) {
    this.kromsatedByScanmagic = kromsatedByScanmagic;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((author == null) ? 0 : author.hashCode());
    result = prime * result + (color ? 1231 : 1237);
    result = prime * result + ((dpi == null) ? 0 : dpi.hashCode());
    result = prime * result + ((edition == null) ? 0 : edition.hashCode());
    result = prime * result + ((extension == null) ? 0 : extension.hashCode());
    result = prime * result + (kromsated ? 1231 : 1237);
    result = prime * result + (landscape ? 1231 : 1237);
    result = prime * result + ((language == null) ? 0 : language.hashCode());
    result = prime * result + (ocr ? 1231 : 1237);
    result = prime * result + ((pages == null) ? 0 : pages.hashCode());
    result = prime * result + ((publishYear == null) ? 0 : publishYear.hashCode());
    result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Book other = (Book) obj;
    if (author == null) {
      if (other.author != null)
        return false;
    } else if (!author.equals(other.author))
      return false;
    if (color != other.color)
      return false;
    if (dpi == null) {
      if (other.dpi != null)
        return false;
    } else if (!dpi.equals(other.dpi))
      return false;
    if (edition == null) {
      if (other.edition != null)
        return false;
    } else if (!edition.equals(other.edition))
      return false;
    if (extension == null) {
      if (other.extension != null)
        return false;
    } else if (!extension.equals(other.extension))
      return false;
    if (kromsated != other.kromsated)
      return false;
    if (landscape != other.landscape)
      return false;
    if (language == null) {
      if (other.language != null)
        return false;
    } else if (!language.equals(other.language))
      return false;
    if (ocr != other.ocr)
      return false;
    if (pages == null) {
      if (other.pages != null)
        return false;
    } else if (!pages.equals(other.pages))
      return false;
    if (publishYear == null) {
      if (other.publishYear != null)
        return false;
    } else if (!publishYear.equals(other.publishYear))
      return false;
    if (publisher == null) {
      if (other.publisher != null)
        return false;
    } else if (!publisher.equals(other.publisher))
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Book [title=" + title + ", author=" + author + ", series=" + series + ", edition=" + edition
            + ", publisher=" + publisher + ", publishYear=" + publishYear + ", language=" + language + ", identifier="
            + identifier + ", landscape=" + landscape + ", ocr=" + ocr + ", kromsated=" + kromsated + ", color="
            + color + ", bookmarks=" + bookmarks + ", kromsatedByScanmagic=" + kromsatedByScanmagic + ", dpi=" + dpi
            + ", pages=" + pages + ", extension=" + extension + "]";
  }

}
