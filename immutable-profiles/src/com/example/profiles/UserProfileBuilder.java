package com.example.profiles;

public class UserProfileBuilder {
    private String id = "";
    private String email = "";
    private String github = "";
    private String displayName = "";
    private String address = "";
    private boolean marketingOptIn = false;
    private String twitter = "";
    private String phone = "";

    public UserProfileBuilder withId(String id) {
        Validation.requireNonBlank(id, "id");
        this.id = id;
        return this;
    }

    public UserProfileBuilder withEmail(String email) {
        Validation.requireEmail(email);
        this.email = email;
        return this;
    }

    public UserProfileBuilder withGithub(String github) {
        this.github = github != null ? github : "";
        return this;
    }

    public UserProfileBuilder withDisplayName(String displayName) {
        this.displayName = displayName != null ? displayName : "";
        return this;
    }

    public UserProfileBuilder withAddress(String address) {
        this.address = address != null ? address : "";
        return this;
    }

    public UserProfileBuilder withMarketingOptIn(boolean marketingOptIn) {
        this.marketingOptIn = marketingOptIn;
        return this;
    }

    public UserProfileBuilder withTwitter(String twitter) {
        this.twitter = twitter != null ? twitter : "";
        return this;
    }

    public UserProfileBuilder withPhone(String phone) {
        this.phone = phone != null ? phone : "";
        return this;
    }

    public UserProfile build() {
        // Validate required fields
        Validation.requireNonBlank(id, "id");
        Validation.requireEmail(email);

        return new UserProfile(
            id,
            email,
            github,
            displayName,
            address,
            marketingOptIn,
            twitter,
            phone
        );
    }
}
