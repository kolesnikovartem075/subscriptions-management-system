package com.artem.subscriptionsmanagementsystem.dto.subscription;

import com.artem.subscriptionsmanagementsystem.database.entity.Status;
import java.time.LocalDate;
import lombok.Value;

@Value
public class SubscriptionEditDto {

    LocalDate startTime;
    LocalDate endTime;
}
