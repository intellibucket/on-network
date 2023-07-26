package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class CoverPictureID extends RootID<UUID> implements IdReference<UUID> {
    protected CoverPictureID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static CoverPictureID of(UUID value) {
        return new CoverPictureID(value);
    }

    public static CoverPictureID of() {
        return new CoverPictureID(UUID.randomUUID());
    }
}
