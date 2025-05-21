package model;

import Annotation.FieldLength;

import java.time.LocalDate;
import java.time.LocalTime;

public record Transaction_Details(

        @FieldLength(12) long transaction_id,
        @FieldLength(10) String customer_name,
        @FieldLength(10) LocalDate transaction_date,
        @FieldLength(8) LocalTime transaction_time,
        @FieldLength(12) double account_balance,
        @FieldLength(3) String currency_type,
        @FieldLength(6) int branch_code,
        @FieldLength(8) boolean international_transfer,
        @FieldLength(10) float transaction_approval_status,
        @FieldLength(8) short processing_time

) {
}
