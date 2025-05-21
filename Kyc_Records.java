package model;

import Annotation.FieldLength;

import java.time.LocalDate;

public record Kyc_Records(
        @FieldLength(15) String fullName,
        @FieldLength(10) LocalDate date,
        @FieldLength(15) String state,
        @FieldLength(15) String nationality,
        @FieldLength(10) String panNumber,
        @FieldLength(15) String idProof,
        @FieldLength(15) String idNumber,
        @FieldLength(30) String phograph_file,
        @FieldLength(12) Long mobile_number,
        @FieldLength(35) String email
        )
{
}
