package az.rock.lib.domain;

import com.intellibucket.lib.payload.trx.TrxProcessStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutboxEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36, updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "transaction_id", length = 36, updatable = false, nullable = false)
    private UUID transactionId;

    @Version
    private Short version;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false, nullable = false)
    private Timestamp createdDate;

    @Column(name = "modification_date")
    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "outbox_status", nullable = false)
    private TrxProcessStatus trxProcessStatus;

    @Column(name = "topic", length = 200, nullable = false)
    private String topic;

    @Column(name = "step", length = 200, nullable = false, updatable = false)
    private String step;

    @Column(name = "event", nullable = false)
    private String event;

    /**
     * This field is used for must be retryable current step
     */
    @Column(name = "must_be_retryable_step", nullable = false, columnDefinition = "boolean default false")
    private Boolean mustBeRetryableStep;

}
