package objects;

import pages.AuthApi;

public class ManageObjects {

    private AuthApi authApi = null;

    public AuthApi getAuthApi() {
        return (authApi == null) ? new AuthApi() : authApi;
    }
}
