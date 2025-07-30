package dev.hspl.todo2ddd.common.application;

// An exception for translating the jpa jakarta.persistence.OptimisticLockException to a generic one
// This also used for client-side held resource/entity version checks(Optimistic concurrency control integrated with clients)

public class EntityVersionMismatchException extends ApplicationUserException {
    public EntityVersionMismatchException(String entityClassName, Object entityBusinessId, boolean clientSideCheck) {
        super("%s entity version mismatch error for %s with id %s".formatted(
                clientSideCheck ? "client-side" : "server-side",
                entityClassName, entityBusinessId.toString()
        ));
    }

    @Override
    public String problemKey() {
        return "common.entity.version_mismatch";
    }

    @Override
    public short groupingValue() {
        return 409;
    }
}
