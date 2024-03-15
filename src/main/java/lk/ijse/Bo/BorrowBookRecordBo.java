package lk.ijse.Bo;

import lk.ijse.Tm.NotReturnedTM;
import lk.ijse.dto.TransactionDto;


import java.util.List;

public interface BorrowBookRecordBo {
    void borrowBook(TransactionDto transactionDto);
    List<NotReturnedTM> getNotReturnedListByUserId(int userId);
    void returnBook(NotReturnedTM obj);
}
