package lk.ijse.Tm;

public class BookTM {
    private int bookId;
    private String title;
    private String bookAuthor;
    private String category;
    private String availability;
    private int branchId;

    public BookTM() {
    }

    public BookTM(int bookId, String title, String bookAuthor, String category, String availability, int branchId) {
        this.bookId = bookId;
        this.title = title;
        this.bookAuthor = bookAuthor;
        this.category = category;
        this.availability = availability;
        this.branchId = branchId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
