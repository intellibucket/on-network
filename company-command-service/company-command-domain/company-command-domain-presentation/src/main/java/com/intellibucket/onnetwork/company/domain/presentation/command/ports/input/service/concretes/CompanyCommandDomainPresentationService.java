package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.concretes;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCreateCompanyCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractCompanyCommandDomainPresentationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@InputPort
@Slf4j
public class CompanyCommandDomainPresentationService implements AbstractCompanyCommandDomainPresentationService {

    private final AbstractCreateCompanyCommandHandler createCompanyCommandHandler;

    public CompanyCommandDomainPresentationService(AbstractCreateCompanyCommandHandler createCompanyCommandHandler) {
        this.createCompanyCommandHandler = createCompanyCommandHandler;
    }

    @Override
    public void createCompany(SagaStartedProcess<CompanyCreatedEvent> request) {
        log.info("CompanyCommandDomainPresentationService.createCompany");
        try {
            this.createCompanyCommandHandler.createCompany(request.getEvent().getPayload());
        } catch (Exception e) {
            log.error("CompanyCommandDomainPresentationService.createCompany", e);
        }
    }

    @Override
    public void deleteCompany(CompanyID id) {

    }

}
