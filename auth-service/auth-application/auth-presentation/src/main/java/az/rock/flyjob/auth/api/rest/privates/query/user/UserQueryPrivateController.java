package az.rock.flyjob.auth.api.rest.privates.query.user;

import az.rock.auth.domain.presentation.dto.response.user.*;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.user.AbstractUserQueryDomainPresentation;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.valueObject.SimplePageable;
import az.rock.lib.valueObject.common.PageableRequest;
import az.rock.spec.auth.privates.query.UserQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/user",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserQueryPrivateController implements UserQueryPrivateSpec {

    private final AbstractUserQueryDomainPresentation userQueryDomainPresentation;

    public UserQueryPrivateController(AbstractUserQueryDomainPresentation userQueryDomainPresentation) {
        this.userQueryDomainPresentation = userQueryDomainPresentation;
    }


    @Override
    @GetMapping("/get-my-profile")
    public ResponseEntity<JSuccessDataResponse<MyUserProfileResponse>> getMyProfile() {
        var response = this.userQueryDomainPresentation.myProfile();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @GetMapping("/get-any-profile/{userId}")
    public ResponseEntity<JSuccessDataResponse<AnyUserProfileResponse>> getAnyProfile(@PathVariable(name = "userId" ) UUID userId) {
        var response = this.userQueryDomainPresentation.anyProfile(userId);
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }

    @Override
    @PostMapping("/get-user-list")
    public ResponseEntity<JSuccessDataResponse<List<SimpleAnyUserProfileResponse>>> getUserList(@RequestBody List<UUID> users) {
        return null;
    }

    @Override
    @PostMapping("/get-my-follower-items")
    public ResponseEntity<JSuccessDataResponse<SimplePageable<List<SimpleFollowerUserResponse>>>> getMyFollowerItems(@RequestBody PageableRequest request) {
        return null;
    }

    @Override
    @PostMapping("/get-my-networks-items")
    public ResponseEntity<JSuccessDataResponse<SimplePageable<List<SimpleNetworkUserResponse>>>> getMyNetworkItems(@RequestBody PageableRequest request) {
        return null;
    }


}
