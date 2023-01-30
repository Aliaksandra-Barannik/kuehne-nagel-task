package dto;

import java.util.Objects;

public class TokenDto {

    private String token;
    private String expires;
    private String status;
    private String result;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TokenDto tokenDto = (TokenDto) o;
        return Objects.equals(token, tokenDto.token) &&
                Objects.equals(expires, tokenDto.expires) &&
                Objects.equals(status, tokenDto.status) &&
                Objects.equals(result, tokenDto.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, expires, status, result);
    }

    @Override
    public String toString() {
        return "TokenDto{" +
                "token='" + token + '\'' +
                ", expires='" + expires + '\'' +
                ", status='" + status + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public static class Builder {

        private TokenDto tokenDto = new TokenDto();

        public Builder withToken(String token) {
            tokenDto.token = token;
            return this;
        }

        public Builder withExpires(String expires) {
            tokenDto.expires = expires;
            return this;
        }

        public Builder withStatus(String status) {
            tokenDto.status = status;
            return this;
        }

        public Builder withResult(String result) {
            tokenDto.result = result;
            return this;
        }

        public TokenDto build() {
            return tokenDto;
        }
    }
}
