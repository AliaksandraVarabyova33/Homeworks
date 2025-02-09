package javahw;

public enum Role {
    ADMIN("1cvn_admin_token"),
    MODERATOR("2cvm_mod_token"),
    USER("3cgh_user_token");

    private final String token;

    Role(String token) {
        this.token = token;
    }

    public boolean customEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return token.equals(((Role) o).token);
    }

}
