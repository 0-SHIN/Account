package org.example.account.dto;

import lombok.*;
import org.example.account.aop.AccountLockIdInterface;
import org.example.account.type.TransactionResultType;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class CancelBalance {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request implements AccountLockIdInterface {
        @NotBlank
        private String transactionId;

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;


        @NotNull
        @Min(10)
        @Max(1000_000_000)
        private Long amount;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String accountNumber;
        private TransactionResultType transactionResult;
        private String transactionId;
        private Long amount;
        private LocalDateTime transactedAt;

        public static CancelBalance.Response from(TransactionDto transactionDto) {
            return CancelBalance.Response.builder()
                    .accountNumber(transactionDto.getAccountNumber())
                    .transactionResult(transactionDto.getTransactionResultType())
                    .transactionId(transactionDto.getTransactionId())
                    .amount(transactionDto.getAmount())
                    .transactedAt(transactionDto.getTransactedAt())
                    .build();
        }
    }
}
