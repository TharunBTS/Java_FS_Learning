package model;

import Annotation.FieldLength;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Customer(
        @FieldLength(6) long customer_id,
        @FieldLength(20) String name,
        @FieldLength(10) String gender,
        @FieldLength(10) LocalDate date,
        @FieldLength(12) long mobile_number,
        @FieldLength(30) String email,
        @FieldLength(46) Address address,
        @FieldLength(15) String nationality,
        @FieldLength(20) String occupation,
        @FieldLength(10) String marital_status,
        @FieldLength(19) LocalDateTime registraion_date_time,
        @FieldLength(15) String category,
        @FieldLength(12) String income_level,
        @FieldLength(5) long credit_score,
        @FieldLength(15) String bank_service)
 {
}
