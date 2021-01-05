package de.cvd.gs.sanialarm.ui.login.data;

import org.jetbrains.annotations.NotNull;

public class LoginResult<T> {

    private LoginResult() {
    }

    @NotNull
    @Override
    public String toString() {
        if (this instanceof LoginResult.Success) {
            Success success = (Success) this;
            return "Login Success [data=" + success.getData().toString() + "]";
        } else if (this instanceof LoginResult.Error) {
            Error error = (LoginResult.Error) this;
            return "Login Error [data=" + error.getData().toString() + "]";
        }
        return "";
    }

    public final static class Success<T> extends LoginResult {
        private final T data;

        public Success(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }

    public final static class Error<T> extends LoginResult {
        private final T data;

        public Error(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }
}
