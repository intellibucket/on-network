package az.rock.flyjob.js.domain.presentation.coordinator.concretes;

import az.rock.flyjob.js.domain.presentation.coordinator.abstracts.AbstractResumeResponsiveEventResponsiveCoordinator;
import az.rock.lib.event.trx.Saga;

public class ResumeResponsiveEventResponsiveCoordinator extends AbstractResumeResponsiveEventResponsiveCoordinator {
    @Override
    protected void onError(Exception exception, Saga saga) {

    }

    @Override
    public void apply(Saga saga) {

    }

    @Override
    public void fail(Saga saga) {

    }
}
