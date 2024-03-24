package az.rock.flyjob.js.domain.presentation.handler.query.concretes;

import az.rock.flyjob.js.domain.core.exception.interest.InterestNotFound;
import az.rock.flyjob.js.domain.presentation.dto.criteria.InterestCriteria;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.AnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.MyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleAnyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.interest.simple.SimpleMyInterestResponseModel;
import az.rock.flyjob.js.domain.presentation.handler.query.abstracts.AbstractInterestQueryHandler;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class InterestQueryHandler implements AbstractInterestQueryHandler {
    private final List<AccessModifier> modifierList = List.of(AccessModifier.values());

    private final AbstractSecurityContextHolder contextHolder;
    private final AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter;

    public InterestQueryHandler(AbstractSecurityContextHolder contextHolder,
                                AbstractInterestQueryRepositoryAdapter interestQueryRepositoryAdapter) {
        this.contextHolder = contextHolder;
        this.interestQueryRepositoryAdapter = interestQueryRepositoryAdapter;
    }

    @Override
    public SimplePageableResponse<AnyInterestResponseModel> findAllAnyInterests(UUID targetResumeId, SimplePageableRequest pageableRequest) throws InterestNotFound {
        final InterestCriteria criteria = toCriteria(ResumeID.of(targetResumeId), null, modifierList);
        var allAnyInterests = this.interestQueryRepositoryAdapter.fetchAllAnyInterests(criteria ,pageableRequest);
        if (!allAnyInterests.isEmpty()) {
            return  SimplePageableResponse.ofNoMore(pageableRequest.getSize(),pageableRequest.getPage(),allAnyInterests);
        }  else throw new InterestNotFound();
    }


    @Override
    public SimplePageableResponse<SimpleAnyInterestResponseModel> findAllAnySimpleInterest(UUID targetResumeId, SimplePageableRequest pageableRequest) throws InterestNotFound {
        final InterestCriteria criteria = toCriteria(ResumeID.of(targetResumeId), null, modifierList);
        var allAnySimpleInterest = this.interestQueryRepositoryAdapter.fetchAllAnySimpleInterest(criteria,pageableRequest);
        if (!allAnySimpleInterest.isEmpty()) {
           return  SimplePageableResponse.ofNoMore(pageableRequest.getSize(),pageableRequest.getPage(),allAnySimpleInterest);
        } else throw new InterestNotFound();
    }

    @Override
    public AnyInterestResponseModel findAnyById(UUID id) throws InterestNotFound {
        var resumeID = this.contextHolder.availableResumeID();
        var interestCriteria = toCriteria(resumeID, id, modifierList);
        var anyById = this.interestQueryRepositoryAdapter.fetchAnyById(interestCriteria);
        if (anyById.isPresent()) {
            return anyById.get();
        }else throw new InterestNotFound();
    }

    @Override
    public MyInterestResponseModel findMyInterestById(UUID id) throws InterestNotFound {
        var resumeID = this.contextHolder.availableResumeID();
        var interestCriteria = toCriteria(resumeID,id);
        var myInterest = this.interestQueryRepositoryAdapter.findMyInterestById(interestCriteria);
        return myInterest.map(MyInterestResponseModel::of)
                .orElseThrow(InterestNotFound::new);
    }

    @Override
    public SimplePageableResponse<MyInterestResponseModel> queryAllMyInterests(SimplePageableRequest pageableRequest) {
        var resumeID = this.contextHolder.availableResumeID();
        var interestCriteria = toCriteria(resumeID);
        var myInterest = this.interestQueryRepositoryAdapter.queryAllMyInterests(interestCriteria,pageableRequest).stream()
                .map(MyInterestResponseModel::of)
                .toList();
        return SimplePageableResponse.of(pageableRequest.getSize(),pageableRequest.getPage(),null,myInterest);
    }

    @Override
    public SimplePageableResponse<SimpleMyInterestResponseModel> queryAllMySimpleInterests(SimplePageableRequest pageableRequest) {
        return null;
    }


    //------------------------------------------------------------------------


    public InterestCriteria toCriteria(ResumeID resumeId, UUID id,List<AccessModifier> modifier) {
        return InterestCriteria.Builder.builder().
                resume(resumeId)
                .id(id)
                .accessModifier(modifier)
                .build();


    }

    public InterestCriteria toCriteria(ResumeID resumeID,UUID id){
        return InterestCriteria.Builder.builder()
                .resume(resumeID)
                .id(id)
                .build();
    }
    public InterestCriteria toCriteria(ResumeID resumeID){
        return InterestCriteria.Builder.builder()
                .resume(resumeID)
                .build();
    }
}
