package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.user.CoverPictureRoot;
import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.FileMetaData;

public interface AbstractCoverPictureDomainMapper {
    CoverPictureRoot of(UserID userID, FileMetaData fileMetaData);
}
