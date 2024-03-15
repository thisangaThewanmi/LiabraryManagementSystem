package lk.ijse.Tm;

import java.time.LocalDate;

public class NotReturnedTM {
    private int transactionId;
    private int bookId;
    private String title;
    private String category;
    private LocalDate borrowedDate;
    private LocalDate returnedDate;

    public NotReturnedTM(int transactionId, int bookId, String title, String category, LocalDate borrowedDate, LocalDate returnedDate) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.title = title;
        this.category = category;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
    }

    public NotReturnedTM() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }
}
