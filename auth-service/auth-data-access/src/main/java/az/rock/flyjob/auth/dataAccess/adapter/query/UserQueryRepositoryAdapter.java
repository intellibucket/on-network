package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractUserDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.UserQueryJPARepository;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserQueryRepositoryAdapter implements AbstractUserQueryRepositoryAdapter {
    private final UserQueryJPARepository userQueryJPARepository;
    //private final AbstractUserComposeQueryJPARepository userComposeQueryJPARepository;
    private final AbstractUserDataAccessMapper<UserEntity,UserRoot> abstractUserDataAccessMapper;

    public UserQueryRepositoryAdapter(UserQueryJPARepository userQueryJPARepository,
                                      //AbstractUserComposeQueryJPARepository userComposeQueryJPARepository,
                                      AbstractUserDataAccessMapper<UserEntity, UserRoot> abstractUserDataAccessMapper) {
        this.userQueryJPARepository = userQueryJPARepository;
        //this.userComposeQueryJPARepository = userComposeQueryJPARepository;
        this.abstractUserDataAccessMapper = abstractUserDataAccessMapper;
    }

    @Override
    public Optional<UserRoot> findById(UserID currentUser) {
        //var response = this.userComposeQueryJPARepository.findUserSimpleComposeByUserId(currentUser.getAbsoluteID());
        var optionalRoot =
                this.userQueryJPARepository.findById(currentUser.getAbsoluteID());
        if (optionalRoot.isPresent()) {
            var userEntity = optionalRoot.get();
            return this.abstractUserDataAccessMapper.toRoot(userEntity);
        }
        return Optional.empty();
    }

    @Override
    public Boolean isExistByUsername(String username) {
        return this.userQueryJPARepository.existsByUsername(username);
    }
}
