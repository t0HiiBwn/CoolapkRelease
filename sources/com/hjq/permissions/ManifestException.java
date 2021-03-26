package com.hjq.permissions;

final class ManifestException extends RuntimeException {
    ManifestException() {
        super("No permissions are registered in the manifest file");
    }

    ManifestException(String str) {
        super(str + ": Permissions are not registered in the manifest file");
    }
}
