package model;

import Annotation.FieldLength;

public record Address (
        @FieldLength(5) String doorNumber,
        @FieldLength(15) String street,
        @FieldLength(15) String city,
        @FieldLength(5) String state,
        @FieldLength(6) long pincode
)

{
}