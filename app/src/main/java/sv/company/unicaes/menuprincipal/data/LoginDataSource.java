package sv.company.unicaes.menuprincipal.data;

import sv.company.unicaes.menuprincipal.Variables;
import sv.company.unicaes.menuprincipal.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {

            if(username.equals("user"))
            {
                // TODO: handle loggedInUser authentication
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                "user",
                                "Juan Perez",0);

                Variables.user=fakeUser;

                return new Result.Success<>(fakeUser);
            }
            else if(username.equals("libreria"))
            {
                // TODO: handle loggedInUser authentication
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                "libreria",
                                "Libreria Villa Morena",1);

                Variables.user=fakeUser;

                return new Result.Success<>(fakeUser);
            }
            else
                return new Result.Error(new IOException("Nombre de usuario no reconocido"));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
