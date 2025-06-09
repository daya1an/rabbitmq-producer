package com.dayalan.rabbitmq_producer;

import lombok.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageDto {

    private String message;

    private String messageId;

    private Date messageDate;
}
