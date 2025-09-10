class Users {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    Users(String username, int age) {
        this.username = username;
        this.age = age;
    }

    // Getters
    public String getUsername() { 
    	return username; 
    }
    
    public int getAge() { 
    	return age; 
    }
}