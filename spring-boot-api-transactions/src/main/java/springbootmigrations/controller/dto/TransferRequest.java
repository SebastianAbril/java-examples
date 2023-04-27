package springbootmigrations.controller.dto;

public class TransferRequest {
    private Long accountOriginId;
    private Long accountDestinationId;
    private Double amount;

    public Long getAccountOriginId() {
        return accountOriginId;
    }

    public void setAccountOriginId(Long accountOriginId) {
        this.accountOriginId = accountOriginId;
    }

    public Long getAccountDestinationId() {
        return accountDestinationId;
    }

    public void setAccountDestinationId(Long accountDestinationId) {
        this.accountDestinationId = accountDestinationId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
