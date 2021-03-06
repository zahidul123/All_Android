package com.example.onekkosteachi.All_ModelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Book {

    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("rank_last_week")
    @Expose
    private Integer rankLastWeek;
    @SerializedName("weeks_on_list")
    @Expose
    private Integer weeksOnList;
    @SerializedName("asterisk")
    @Expose
    private Integer asterisk;
    @SerializedName("dagger")
    @Expose
    private Integer dagger;
    @SerializedName("primary_isbn10")
    @Expose
    private String primaryIsbn10;
    @SerializedName("primary_isbn13")
    @Expose
    private String primaryIsbn13;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("contributor")
    @Expose
    private String contributor;
    @SerializedName("contributor_note")
    @Expose
    private String contributorNote;
    @SerializedName("book_image")
    @Expose
    private String bookImage;
    @SerializedName("book_image_width")
    @Expose
    private Integer bookImageWidth;
    @SerializedName("book_image_height")
    @Expose
    private Integer bookImageHeight;
    @SerializedName("amazon_product_url")
    @Expose
    private String amazonProductUrl;
    @SerializedName("age_group")
    @Expose
    private String ageGroup;
    @SerializedName("book_review_link")
    @Expose
    private String bookReviewLink;
    @SerializedName("first_chapter_link")
    @Expose
    private String firstChapterLink;
    @SerializedName("sunday_review_link")
    @Expose
    private String sundayReviewLink;
    @SerializedName("article_chapter_link")
    @Expose
    private String articleChapterLink;
    @SerializedName("isbns")
    @Expose

    private List<Isbn> isbns = null;
    @SerializedName("buy_links")
    @Expose

    private List<BuyLink> buyLinks = null;
    @SerializedName("book_uri")
    @Expose
    private String bookUri;

    /**
     * No args constructor for use in serialization
     *
     */
    public Book() {
    }

    /**
     *
     * @param rankLastWeek
     * @param articleChapterLink
     * @param dagger
     * @param publisher
     * @param bookUri
     * @param author
     * @param title
     * @param rank
     * @param description
     * @param primaryIsbn13
     * @param contributor
     * @param sundayReviewLink
     * @param firstChapterLink
     * @param primaryIsbn10
     * @param bookImageHeight
     * @param ageGroup
     * @param amazonProductUrl
     * @param bookReviewLink
     * @param isbns
     * @param asterisk
     * @param weeksOnList
     * @param bookImageWidth
     * @param buyLinks
     * @param contributorNote
     * @param price
     * @param bookImage
     */
    public Book(Integer rank, Integer rankLastWeek, Integer weeksOnList, Integer asterisk, Integer dagger, String primaryIsbn10, String primaryIsbn13, String publisher, String description, Integer price, String title, String author, String contributor, String contributorNote, String bookImage, Integer bookImageWidth, Integer bookImageHeight, String amazonProductUrl, String ageGroup, String bookReviewLink, String firstChapterLink, String sundayReviewLink, String articleChapterLink, List<Isbn> isbns, List<BuyLink> buyLinks, String bookUri) {
        super();
        this.rank = rank;
        this.rankLastWeek = rankLastWeek;
        this.weeksOnList = weeksOnList;
        this.asterisk = asterisk;
        this.dagger = dagger;
        this.primaryIsbn10 = primaryIsbn10;
        this.primaryIsbn13 = primaryIsbn13;
        this.publisher = publisher;
        this.description = description;
        this.price = price;
        this.title = title;
        this.author = author;
        this.contributor = contributor;
        this.contributorNote = contributorNote;
        this.bookImage = bookImage;
        this.bookImageWidth = bookImageWidth;
        this.bookImageHeight = bookImageHeight;
        this.amazonProductUrl = amazonProductUrl;
        this.ageGroup = ageGroup;
        this.bookReviewLink = bookReviewLink;
        this.firstChapterLink = firstChapterLink;
        this.sundayReviewLink = sundayReviewLink;
        this.articleChapterLink = articleChapterLink;
        this.isbns = isbns;
        this.buyLinks = buyLinks;
        this.bookUri = bookUri;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getRankLastWeek() {
        return rankLastWeek;
    }

    public void setRankLastWeek(Integer rankLastWeek) {
        this.rankLastWeek = rankLastWeek;
    }

    public Integer getWeeksOnList() {
        return weeksOnList;
    }

    public void setWeeksOnList(Integer weeksOnList) {
        this.weeksOnList = weeksOnList;
    }

    public Integer getAsterisk() {
        return asterisk;
    }

    public void setAsterisk(Integer asterisk) {
        this.asterisk = asterisk;
    }

    public Integer getDagger() {
        return dagger;
    }

    public void setDagger(Integer dagger) {
        this.dagger = dagger;
    }

    public String getPrimaryIsbn10() {
        return primaryIsbn10;
    }

    public void setPrimaryIsbn10(String primaryIsbn10) {
        this.primaryIsbn10 = primaryIsbn10;
    }

    public String getPrimaryIsbn13() {
        return primaryIsbn13;
    }

    public void setPrimaryIsbn13(String primaryIsbn13) {
        this.primaryIsbn13 = primaryIsbn13;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getContributorNote() {
        return contributorNote;
    }

    public void setContributorNote(String contributorNote) {
        this.contributorNote = contributorNote;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public Integer getBookImageWidth() {
        return bookImageWidth;
    }

    public void setBookImageWidth(Integer bookImageWidth) {
        this.bookImageWidth = bookImageWidth;
    }

    public Integer getBookImageHeight() {
        return bookImageHeight;
    }

    public void setBookImageHeight(Integer bookImageHeight) {
        this.bookImageHeight = bookImageHeight;
    }

    public String getAmazonProductUrl() {
        return amazonProductUrl;
    }

    public void setAmazonProductUrl(String amazonProductUrl) {
        this.amazonProductUrl = amazonProductUrl;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getBookReviewLink() {
        return bookReviewLink;
    }

    public void setBookReviewLink(String bookReviewLink) {
        this.bookReviewLink = bookReviewLink;
    }

    public String getFirstChapterLink() {
        return firstChapterLink;
    }

    public void setFirstChapterLink(String firstChapterLink) {
        this.firstChapterLink = firstChapterLink;
    }

    public String getSundayReviewLink() {
        return sundayReviewLink;
    }

    public void setSundayReviewLink(String sundayReviewLink) {
        this.sundayReviewLink = sundayReviewLink;
    }

    public String getArticleChapterLink() {
        return articleChapterLink;
    }

    public void setArticleChapterLink(String articleChapterLink) {
        this.articleChapterLink = articleChapterLink;
    }

    public List<Isbn> getIsbns() {
        return isbns;
    }

    public void setIsbns(List<Isbn> isbns) {
        this.isbns = isbns;
    }

    public List<BuyLink> getBuyLinks() {
        return buyLinks;
    }

    public void setBuyLinks(List<BuyLink> buyLinks) {
        this.buyLinks = buyLinks;
    }

    public String getBookUri() {
        return bookUri;
    }

    public void setBookUri(String bookUri) {
        this.bookUri = bookUri;
    }

    @Override
    public String toString() {
        return "Book{" +
                "rank=" + rank +
                ", rankLastWeek=" + rankLastWeek +
                ", weeksOnList=" + weeksOnList +
                ", asterisk=" + asterisk +
                ", dagger=" + dagger +
                ", primaryIsbn10='" + primaryIsbn10 + '\'' +
                ", primaryIsbn13='" + primaryIsbn13 + '\'' +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", contributor='" + contributor + '\'' +
                ", contributorNote='" + contributorNote + '\'' +
                ", bookImage='" + bookImage + '\'' +
                ", bookImageWidth=" + bookImageWidth +
                ", bookImageHeight=" + bookImageHeight +
                ", amazonProductUrl='" + amazonProductUrl + '\'' +
                ", ageGroup='" + ageGroup + '\'' +
                ", bookReviewLink='" + bookReviewLink + '\'' +
                ", firstChapterLink='" + firstChapterLink + '\'' +
                ", sundayReviewLink='" + sundayReviewLink + '\'' +
                ", articleChapterLink='" + articleChapterLink + '\'' +
                ", isbns=" + isbns +
                ", buyLinks=" + buyLinks +
                ", bookUri='" + bookUri + '\'' +
                '}';
    }

}
