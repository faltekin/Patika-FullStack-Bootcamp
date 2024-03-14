package dev.patika.library.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingSaveRequest {

    private String borrowerName;
    private String borrowerMail;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private int bookId;

}
