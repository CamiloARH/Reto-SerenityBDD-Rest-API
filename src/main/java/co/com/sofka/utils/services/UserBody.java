package co.com.sofka.utils.services;

public enum UserBody {

    BODY("{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"zion resident\"\n" +
            "}");

    private final String value;

    public String getValue() {
        return value;
    }

    UserBody(String value) {
        this.value = value;
    }
}
