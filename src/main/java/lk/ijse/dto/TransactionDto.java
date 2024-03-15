package lk.ijse.dto;

import java.time.LocalDate;

public class TransactionDto {
    private int userId;
    private int bookId;
    private LocalDate borrowedDate;
    private LocalDate returnedDate;

    public TransactionDto() {
    }

    public TransactionDto(int userId, int bookId, LocalDate borrowedDate, LocalDate returnedDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    @Override
    public String toString() {
        return "TransactionDto{" +
                "userId=" + userId +
                ", bookId=" + bookId +
                ", borrowedDate=" + borrowedDate +
                ", returnedDate=" + returnedDate +
                '}';
    }
}
