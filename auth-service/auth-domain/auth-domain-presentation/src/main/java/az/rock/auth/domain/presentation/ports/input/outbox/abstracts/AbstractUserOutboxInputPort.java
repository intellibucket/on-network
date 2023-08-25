package az.rock.auth.domain.presentation.ports.input.outbox.abstracts;

import az.rock.flyjob.auth.root.UserOutboxRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.annotation.InputPort;
import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import org.springframework.transaction.annotation.Transactional;

@InputPort
@Transactional
public interface AbstractUserOutboxInputPort extends AbstractOutboxInputPort<AbstractDomainEvent<UserRoot>, UserOutboxRoot> {
}
