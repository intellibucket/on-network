package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractRoleRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.RoleDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.account.RoleJPARepository;
import az.rock.flyjob.auth.root.account.RoleRoot;
import org.springframework.stereotype.Component;

@Component
public class RoleRepositoryAdapter implements AbstractRoleRepositoryAdapter {
    private final RoleJPARepository roleJPARepository;

    private final RoleDataAccessMapper roleDataAccessMapper;

    public RoleRepositoryAdapter(RoleJPARepository roleJPARepository,
                                 RoleDataAccessMapper roleDataAccessMapper) {
        this.roleJPARepository = roleJPARepository;
        this.roleDataAccessMapper = roleDataAccessMapper;
    }

    @Override
    public RoleRoot create(RoleRoot root) {
        return null;
    }
}
