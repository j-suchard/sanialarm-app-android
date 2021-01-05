package de.cvd.gs.sanialarm.ui.login.data;

import de.cvd.gs.sanialarm.User;

public class LoginRepository {

    private static volatile LoginRepository instance;
    private LoginSource dataSource;
    private User user = null;

    private LoginRepository(LoginSource dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(LoginSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }
}
