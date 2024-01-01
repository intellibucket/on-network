package com.intellibucket.onnetwork.company.domain.presentation.command.coordinator.abstracts;

import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.coordinator.AbstractEventResponseCoordinator;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.trx.AbstractSagaProcess;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public abstract class AbstractCompanyCreatedResponseEventCoordinator extends AbstractEventResponseCoordinator<CompanyCreatedEvent> {
    protected abstract void createCompany(SagaStartedProcess<CompanyCreatedEvent> request);

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public abstract <S> void apply(AbstractSagaProcess<S> sagaProcess);


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected abstract <F> void onFail(AbstractSagaProcess<F> sagaProcess, JDomainException exception);

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected abstract <F> void onFail(AbstractSagaProcess<F> sagaProcess);


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected abstract void onError(AbstractSagaProcess<CompanyCreatedEvent> sagaProcess, Throwable throwable);
}
